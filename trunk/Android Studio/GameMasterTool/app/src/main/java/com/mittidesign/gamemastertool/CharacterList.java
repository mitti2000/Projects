package com.mittidesign.gamemastertool;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;


public class CharacterList extends ActionBarActivity {

    private ListView charList;
    private CharDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);

        Character character_data[] = new Character[]{
                new Character("Tyrill"),
                new Character("Emgrisch"),
                new Character("Balbarosch"),
                new Character("Sam"),
                new Character("Goblinkönig"),
        };

        CharacterAdapter adapter = new CharacterAdapter(this, R.layout.charlist_item_row, character_data);

        charList = (ListView) findViewById(R.id.charList);
        View header = (View)getLayoutInflater().inflate(R.layout.charlist_header_row, null);
        charList.addHeaderView(header);
        charList.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_character_list, menu);
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
