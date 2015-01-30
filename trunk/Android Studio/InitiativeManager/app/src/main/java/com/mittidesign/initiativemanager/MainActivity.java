package com.mittidesign.initiativemanager;

import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;



public class MainActivity extends ActionBarActivity {

    private CharDataSource dataSource = null;
    private CharacterAdapter adapter = null;
    private ArrayList<Character> character_data = null;
    private ListView charList;
    private DialogFragment alertFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Laden der Datenbank
        if(dataSource == null) {
            dataSource = new CharDataSource(this);
            try {
                dataSource.open(); //get writeable Database
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Button btn_delete = (Button) findViewById(R.id.btn_delete_table);
        Button btn_newChar = (Button) findViewById(R.id.btn_new_char);
        Button btn_alert = (Button) findViewById(R.id.btn_alert);

        // TODO: Holen der Daten aus Datenbank
        if(character_data == null) {
            character_data = dataSource.getAllCharacters();
        }


        // TODO: Erstellen des Adapters
        if(adapter == null) {
            adapter = new CharacterAdapter(this, R.layout.charlist_item_row, character_data);
        }


        charList = (ListView) findViewById(R.id.char_list);
        View header = getLayoutInflater().inflate(R.layout.charlist_header_row, null);
        charList.addHeaderView(header);
        charList.setAdapter(adapter);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.deleteDatabase();
                adapter.clear();
            }
        });
        btn_newChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Character character = dataSource.createCharacter("New Char3");
                adapter.add(character);
            }
        });

        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertFragment = new AddCharDialogFragment();
                alertFragment.show(getFragmentManager(),"how_many");
            }
        });



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
