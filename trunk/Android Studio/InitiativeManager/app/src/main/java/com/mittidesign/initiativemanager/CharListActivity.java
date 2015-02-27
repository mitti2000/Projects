package com.mittidesign.initiativemanager;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class CharListActivity extends Activity implements AddCharDialogFragment.AddCharDialogListener, EditCharDialogFragment.EditCharDialogListener, AddFightDialogFragment.AddFightDialogListener {

    private CharDataSource dataSource;
    private CharListAdapter adapter = null;
    private ArrayList<Character> character_data = null;
    private Character selectedCharacter = null;
    private int selectedCharacterPos;
    private ListView charList;
    private TextView labSelectedCharacter;
    private int oldPosition = -1;

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_INITIATIVE = "initiative";
    public static final String EXTRA_HP = "hp";
    public static final String EXTRA_STAMINA = "stamina";
    public static final String EXTRA_NPC = "npc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_list);

       dataSource = new CharDataSource(this);
        try {
            dataSource.open(); //get writeable Database
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if(character_data == null) {
            character_data = dataSource.getAllCharacters();
        }

        if(adapter == null) {
            adapter = new CharListAdapter(this, R.layout.charlist_item_row, character_data);
        }

        charList = (ListView) findViewById(R.id.character_list);
        View header = getLayoutInflater().inflate(R.layout.charlist_header_row, null);
        charList.addHeaderView(header);
        charList.setAdapter(adapter);

        charList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedCharacterPos = position;
                if(selectedCharacterPos>0) {
                    selectedCharacter = (Character) charList.getItemAtPosition(position);
                    setSelectedCharacter(selectedCharacter);

                    changeBgColor(selectedCharacterPos);
                }
            }
        });


        Button btn_addChar = (Button) findViewById(R.id.btn_new_char);
        Button btn_deleteChar = (Button) findViewById(R.id.btn_delete_char);
        Button btn_deleteDB = (Button) findViewById(R.id.btn_delete_db);
        Button btn_editChar = (Button) findViewById(R.id.btn_edit_char);
        Button btn_addFight = (Button) findViewById(R.id.btn_add_fight);

        btn_addChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddCharacterFragement();
            }
        });

        btn_deleteDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.deleteDatabase();
                adapter.clear();
            }
        });

        btn_deleteChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedCharacter!=null) dataSource.deleteCharacter(selectedCharacter);
                //charList.removeViewAt(selectedCharacterPos);
                adapter.remove(selectedCharacter);
                labSelectedCharacter = (TextView) findViewById(R.id.lab_selected_char);
                labSelectedCharacter.setText("*select a character*");
                selectedCharacter = null;
                }
        });

        btn_editChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedCharacter!=null){
                    GlobalHandler.editableChar(selectedCharacter);
                    openEditCharacterFragment();
                }
            }
        });

        btn_addFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedCharacter!=null){
                    addCharToFight(selectedCharacter);
                    Log.d("Add Button","yes");
                }
            }
        });
    }


    private void setSelectedCharacter(Character character){
        labSelectedCharacter = (TextView) findViewById(R.id.lab_selected_char);
        labSelectedCharacter.setText(character.getName());
    }

    private void openAddCharacterFragement() {
        DialogFragment newFragment = new AddCharDialogFragment();
        newFragment.show(getFragmentManager(), "add_char");
    }

    private void openEditCharacterFragment(){
        DialogFragment newFragment = new EditCharDialogFragment();
        newFragment.show(getFragmentManager(), "edit_char");

    }

    private void changeBgColor(int position){
        if(oldPosition>=0) charList.getChildAt(oldPosition).setBackground(getResources().getDrawable(R.drawable.abc_list_selector_holo_light));
        oldPosition = position;
        charList.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.selected_char));
    }



    @Override
    public void onAddCharDialogPositiveClick(DialogFragment dialog){
        if(GlobalHandler.charListEntry!=null){
            String name = GlobalHandler.charListEntry.getName();
            int hp = GlobalHandler.charListEntry.getHealthPoints();
            int stamina = GlobalHandler.charListEntry.getStamina();
            boolean npc = GlobalHandler.charListEntry.isNpc();
            Character character = dataSource.createCharacter(name, hp, stamina, npc);
            adapter.add(character);
        }
    }

    @Override
    public void onAddCharDialogNegativeClick(DialogFragment dialog){
        Log.d("Button pressed: ", "cancel");
    }



    @Override
    public void onEditCharDialogPositiveClick(DialogFragment dialog){
        if(GlobalHandler.charListEntry!=null) {
            String name = GlobalHandler.charListEntry.getName();
            int hp = GlobalHandler.charListEntry.getHealthPoints();
            int stamina = GlobalHandler.charListEntry.getStamina();
            boolean npc = GlobalHandler.charListEntry.isNpc();

            int position = adapter.getPosition(selectedCharacter);
            Character character = adapter.getItem(position);

            character.setName(name);
            character.setHealthPoints(hp);
            character.setStamina(stamina);
            if(npc) character.setNpc(1);
            else character.setNpc(0);

            adapter.notifyDataSetChanged();
            dataSource.editCharacter(character);
            selectedCharacter = character;
        }
    }

    @Override
    public void onEditCharDialogNegativeClick(DialogFragment dialog){
        Log.d("Edit Button pressed: ", "cancel");
    }

    @Override
    public void onAddFightDialogPositiveClick(DialogFragment dialog){
        Log.d("Amount", "" + GlobalHandler.getAmountToAdd());
        finish();
    }

    @Override
    public void onAddFightDialogNegativeClick(DialogFragment dialog){

    }

    public void addCharToFight(Character character) {
        GlobalHandler.setFightListCharacter(character);
        DialogFragment newFragment = new AddFightDialogFragment();
        newFragment.show(getFragmentManager(), "add_fight");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_char_list, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
