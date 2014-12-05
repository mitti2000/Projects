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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    public void rollDice(int dizeSize){
        Random randomNumber = new Random();
        TextView textViewDiceResult = (TextView) findViewById(R.id.dice_result);
        int diceResult = randomNumber.nextInt(dizeSize)+1;
        textViewDiceResult.setText(Integer.toString(diceResult));
        Log.d("RollDice", "RollDice " + diceResult);
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
