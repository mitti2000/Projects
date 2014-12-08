package com.mittidesign.gamemastertool;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    public String[] last5rollsArray = new String[5];

    CharDBContract.FeedReaderDbHelper mDbHelper = new CharDBContract.FeedReaderDbHelper(getContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        last5rollsClear();

        Button btnD2 = (Button) findViewById(R.id.dice_d2);
        btnD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(2);
            }
        });

        Button btnD4 = (Button) findViewById(R.id.dice_d4);
        btnD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(4);
            }
        });

        Button btnD6 = (Button) findViewById(R.id.dice_d6);
        btnD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(6);
            }
        });

        Button btnD8 = (Button) findViewById(R.id.dice_d8);
        btnD8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(8);
            }
        });

        Button btnD10 = (Button) findViewById(R.id.dice_d10);
        btnD10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(10);
            }
        });

        Button btnD12 = (Button) findViewById(R.id.dice_d12);
        btnD12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(12);
            }
        });

        Button btnD20 = (Button) findViewById(R.id.dice_d20);
        btnD20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(20);
            }
        });

        Button btnD30 = (Button) findViewById(R.id.dice_d30);
        btnD30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(30);
            }
        });

        Button btnD100 = (Button) findViewById(R.id.dice_d100);
        btnD100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(100);
            }
        });
    }

    public void rollDice(int dizeSize){
        Random randomNumber = new Random();
        TextView textViewDiceResult = (TextView) findViewById(R.id.dice_result);
        int diceResult = randomNumber.nextInt(dizeSize)+1;
        if (dizeSize==2){
            if(diceResult==1) {
                textViewDiceResult.setText(R.string.no);
                last5rolls(getString(R.string.no));
            }
            if(diceResult==2) {
                textViewDiceResult.setText(R.string.yes);
                last5rolls(getString(R.string.yes));
            }

        }
        else {
            textViewDiceResult.setText(Integer.toString(diceResult));
            last5rolls(Integer.toString(diceResult));
        }
    }

    public void last5rolls (String lastRoll){
        TextView textViewLast5Rolls = (TextView) findViewById(R.id.last_5_rolls);
        for(int i=last5rollsArray.length-1;i>0;i--){
            last5rollsArray[i]=last5rollsArray[i-1];
        }
        last5rollsArray[0]=lastRoll;
        textViewLast5Rolls.setText(last5rollsArray[0] + "/" +last5rollsArray[1] + "/" +last5rollsArray[2] + "/" +last5rollsArray[3] + "/" +last5rollsArray[4]);
    }

    public void last5rollsClear(){
        TextView textViewLast5Rolls = (TextView) findViewById(R.id.last_5_rolls);
        for(int i=0; i<last5rollsArray.length;i++){
            last5rollsArray[i]="-";
        }
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
