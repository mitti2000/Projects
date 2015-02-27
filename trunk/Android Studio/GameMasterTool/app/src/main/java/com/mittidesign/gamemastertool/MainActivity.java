package com.mittidesign.gamemastertool;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.Random;
import org.w3c.dom.Text;


public class MainActivity extends Activity {
    public String[] last5rollsArray = new String[5];

    //TODO: Variabel for ListView Test
    private ListView charList;

    private CharDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        last5rollsClear();






        //TODO: Testing area for ListView
        //**********************************************************************
       /* Character character_data[] = new Character[]{
                new Character("Tyrill", 25,10,""),
                new Character("Emgrisch", 25,10,""),
                new Character("Balbarosch", 25,10,""),
                new Character("Sam", 25,10,""),
                new Character("Goblinkönig", 25,10,""),
        };*/

        Character character_data[] = new Character[]{
            dataSource.createCharacter("Tyrill"),
            dataSource.createCharacter("Balbarosch"),
            dataSource.createCharacter("Emgrisch")
        };

        CharacterAdapter adapter = new CharacterAdapter(this, R.layout.charlist_item_row, character_data);


        charList = (ListView) findViewById(R.id.charList);
        View header = (View)getLayoutInflater().inflate(R.layout.charlist_header_row, null);
        charList.addHeaderView(header);
        charList.setAdapter(adapter);
        //**********************************************************************

        //Roll Dice D2
        Button btnD2 = (Button) findViewById(R.id.dice_d2);
        btnD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(2);
            }
        });

        //Roll Dice D4
        Button btnD4 = (Button) findViewById(R.id.dice_d4);
        btnD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(4);
            }
        });

        //Roll Dice D6
        Button btnD6 = (Button) findViewById(R.id.dice_d6);
        btnD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(6);
            }
        });

        //Roll Dice D8
        Button btnD8 = (Button) findViewById(R.id.dice_d8);
        btnD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(8);
            }
        });

        //Roll Dice D10
        Button btnD10 = (Button) findViewById(R.id.dice_d10);
        btnD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(10);
            }
        });

        //Roll Dice D12
        Button btnD12 = (Button) findViewById(R.id.dice_d12);
        btnD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(12);
            }
        });

        //Roll Dice D20
        Button btnD20 = (Button) findViewById(R.id.dice_d20);
        btnD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(20);
            }
        });

        //Roll Dice D30
        Button btnD30 = (Button) findViewById(R.id.dice_d30);
        btnD30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(30);
            }
        });

        //Roll Dice D100
        Button btnD100 = (Button) findViewById(R.id.dice_d100);
        btnD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(100);
            }
        });

        //Clear Rolls
        Button btnClear = (Button) findViewById(R.id.dice_clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last5rollsClear();
                clearDiceResult();
            }
        });

// TODO: Daten für Database
// ********************************************
      dataSource = new CharDataSource(this);
        try {
            dataSource.open(); //get writeable Database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //*************************************
    public void openCharacterList(View view) {
        Intent intent = new Intent(this, CharacterList.class);
    }



    //Dice roller according to Dice Size
    public void rollDice(int dizeSize){
        Random randomNumber = new Random(); //Create Random Number
        TextView textViewDiceResult = (TextView) findViewById(R.id.dice_result); //Set Variable for DiceResult Text View
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
        TextView textViewLast5Rolls = (TextView) findViewById(R.id.last_5_rolls); //Get TextView
        for(int i=last5rollsArray.length-1;i>0;i--){
            last5rollsArray[i]=last5rollsArray[i-1];
        }
        last5rollsArray[0]=lastRoll;
        textViewLast5Rolls.setText(last5rollsArray[0] + "/" +last5rollsArray[1] + "/" +last5rollsArray[2] + "/" +last5rollsArray[3] + "/" +last5rollsArray[4]);
    }

    //Clear DiceResult
    public void clearDiceResult(){
        TextView textViewDiceResult = (TextView) findViewById(R.id.dice_result);
        textViewDiceResult.setText("");
    }

    //Reset last5rolls
    public void last5rollsClear(){
        TextView textViewLast5Rolls = (TextView) findViewById(R.id.last_5_rolls); //Get TextView
        for(int i=0; i<last5rollsArray.length;i++){
            last5rollsArray[i]="-";
        }
        //Set Text View to -/-/-/-/-
        textViewLast5Rolls.setText(last5rollsArray[0] + "/" +last5rollsArray[1] + "/" +last5rollsArray[2] + "/" +last5rollsArray[3] + "/" +last5rollsArray[4]);
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
