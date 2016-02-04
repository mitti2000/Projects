package com.mittidesign.initiativemanager;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
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
import java.util.Random;


public class MainActivity extends Activity {  //ActionBar
    private String[] last5rollsArray = new String[5];
    private FightListAdapter adapter = null;
    private ArrayList<Character> character_data = null;
    private FightListDataSource dataSource;
    private int selectedCharacterPos;
    private Character selectedCharacter = null;
    private ListView fightList;
    private TextView labSelectedCharacter;
    private int oldPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new FightListDataSource(this);
            try {
                dataSource.open();
            } catch (Exception e) {
                e.printStackTrace();
            }

        //region Dice Rolling
        Button btn_d2 = (Button) findViewById(R.id.btn_d2);
        Button btn_d4 = (Button) findViewById(R.id.btn_d4);
        Button btn_d6 = (Button) findViewById(R.id.btn_d6);
        Button btn_d8 = (Button) findViewById(R.id.btn_d8);
        Button btn_d10 = (Button) findViewById(R.id.btn_d10);
        Button btn_d12 = (Button) findViewById(R.id.btn_d12);
        Button btn_d20 = (Button) findViewById(R.id.btn_d20);
        Button btn_d30 = (Button) findViewById(R.id.btn_d30);
        Button btn_d100 = (Button) findViewById(R.id.btn_d100);
        Button btn_clear = (Button) findViewById(R.id.btn_clear);

        //Roll Dice D2
        btn_d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(2);
            }
        });
        //Roll Dice D4
        btn_d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(4);
            }
        });
        //Roll Dice D6
        btn_d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(6);
            }
        });
        //Roll Dice D8
        btn_d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(8);
            }
        });
        //Roll Dice D10
        btn_d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(10);
            }
        });
        //Roll Dice D12
        btn_d12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(12);
            }
        });
        //Roll Dice D20
        btn_d20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(20);
            }
        });
        //Roll Dice D30
        btn_d30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(30);
            }
        });
        //Roll Dice D100
        btn_d100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(100);
            }
        });
        //Clear Rolls
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last5rollsClear();
                clearDiceResult();
            }
        });
        //endregion

        if(character_data == null) {
            character_data = dataSource.getAllCharacters();
        }


        if(adapter == null) {
            adapter = new FightListAdapter(this, R.layout.fightlist_item_row, character_data);
        }


        fightList = (ListView) findViewById(R.id.list_fightlist);
        View header = getLayoutInflater().inflate(R.layout.fightlist_header_row, null);
        fightList.addHeaderView(header);
        fightList.setAdapter(adapter);

        fightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedCharacterPos = position;
                if(selectedCharacterPos>0) {
                    selectedCharacter = (Character) fightList.getItemAtPosition(selectedCharacterPos);
                    changeBgColor(selectedCharacterPos);
                }
            }
        });


    }




    //Dice roller according to Dice Size
    public void rollDice(int dizeSize){
        Random randomNumber = new Random(); //Create Random Number
        TextView textViewDiceResult = (TextView) findViewById(R.id.lab_lastroll); //Set Variable for DiceResult Text View
        int diceResult = randomNumber.nextInt(dizeSize)+1; //Create Random Number between 1 and DiiceSIze
        //Create Yes and No Resulte for D2
        if (dizeSize==2){
            if(diceResult==1) {
                textViewDiceResult.setText(R.string.no); //Set DiceResult Text View
                last5rolls(getString(R.string.no)); //Add entry to last5rolls array
            }
            if(diceResult==2) {
                textViewDiceResult.setText(R.string.yes); //Set DiceResult Text View
                last5rolls(getString(R.string.yes)); //Add entry to last5rolls array
            }

        }
        else {
            textViewDiceResult.setText(Integer.toString(diceResult)); //Set DiceResult Text View
            last5rolls(Integer.toString(diceResult)); //Add entry to last5rolls array
        }
    }

    //Set last5Rolls TextView
    public void last5rolls (String lastRoll){
        TextView textViewLast5Rolls = (TextView) findViewById(R.id.lab_last5rolls); //Get TextView
        for(int i=last5rollsArray.length-1;i>0;i--){
            last5rollsArray[i]=last5rollsArray[i-1];
        }
        last5rollsArray[0]=lastRoll;
        textViewLast5Rolls.setText(last5rollsArray[0] + "/" +last5rollsArray[1] + "/" +last5rollsArray[2] + "/" +last5rollsArray[3] + "/" +last5rollsArray[4]);
    }

    //Clear DiceResult
    public void clearDiceResult(){
        TextView textViewDiceResult = (TextView) findViewById(R.id.lab_lastroll);
        textViewDiceResult.setText("");
    }

    //Reset last5rolls
    public void last5rollsClear(){
        TextView textViewLast5Rolls = (TextView) findViewById(R.id.lab_last5rolls); //Get TextView
        for(int i=0; i<last5rollsArray.length;i++){
            last5rollsArray[i]="-";
        }
        //Set Text View to -/-/-/-/-
        textViewLast5Rolls.setText(last5rollsArray[0] + "/" +last5rollsArray[1] + "/" +last5rollsArray[2] + "/" +last5rollsArray[3] + "/" +last5rollsArray[4]);
    }

    public void openCharList(View view) {
        Intent intent = new Intent(this, CharListActivity.class);
        startActivity(intent);
    }

    public void addCharToFightList(Character character){//String name, int initiative, int hp, int stamina, boolean npc
        Character dbCharacter = dataSource.createCharacter(character.getName(),character.getInitiative(), character.getHealthPoints(), character.getStamina(), character.isNpc());
        adapter.add(dbCharacter);
    }

    private void setSelectedCharacter(Character character){

    }

    private void changeBgColor(int position){
        if(oldPosition>=0) fightList.getChildAt(oldPosition).setBackground(getResources().getDrawable(R.drawable.abc_list_selector_holo_light));
        oldPosition = position;
        fightList.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.selected_char));
    }




    @Override
    protected void onResume(){
        super.onResume();
        if(GlobalHandler.getFightListCharacter()!= null && GlobalHandler.getAmountToAdd()>0){
            addCharToFightList(GlobalHandler.getFightListCharacter());
            GlobalHandler.setFightListCharacter(null);
            Log.d("Main Ac Amount", ""+GlobalHandler.getAmountToAdd());
            GlobalHandler.setAmountToAdd(0);
        }

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
