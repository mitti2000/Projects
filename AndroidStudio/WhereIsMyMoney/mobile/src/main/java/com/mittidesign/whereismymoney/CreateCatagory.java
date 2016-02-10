package com.mittidesign.whereismymoney;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class CreateCatagory extends AppCompatActivity implements ColorPicker.OnColorChangedListener {

    //Buttons
    Button btnSetColor;
    Button btnColorPicker;
    Button btnConfirm;
    Button btnReset;

    //Inputs
    EditText categoryName;
    EditText inputRed;
    EditText inputGreen;
    EditText inputBlue;

    //Checkboxes
    CheckBox[] chkColor;
    RadioButton[] rdoColor;

    //Intent


    //Colors
    int colorChosen;
    float[] colorChosenHsv = new float[3];
    float[] colorHSVTemp = new float[3];
    int colorTemp;
    float brightnessValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_catagory);

        //Set Views
        //Buttons
        btnSetColor = (Button)findViewById(R.id.btn_setColor);
        btnColorPicker = (Button)findViewById(R.id.btn_colorPicker);
        btnConfirm = (Button)findViewById(R.id.btn_confirm);
        btnReset = (Button)findViewById(R.id.btn_reset);

        //Inputs
        categoryName = (EditText) findViewById(R.id.input_category_name);
        inputRed = (EditText) findViewById(R.id.inpColorValueRed);
        inputGreen = (EditText) findViewById(R.id.inpColorValueGreen);
        inputBlue = (EditText) findViewById(R.id.inpColorValueBlue);

        //Checkboxes
        chkColor = new CheckBox[10];
        rdoColor = new RadioButton[10];

        //Fill Checkbox Array
        chkColor[0] = (CheckBox) findViewById(R.id.chk_color_1);
        chkColor[1] = (CheckBox) findViewById(R.id.chk_color_2);
        chkColor[2] = (CheckBox) findViewById(R.id.chk_color_3);
        chkColor[3] = (CheckBox) findViewById(R.id.chk_color_4);
        chkColor[4] = (CheckBox) findViewById(R.id.chk_color_5);
        chkColor[5] = (CheckBox) findViewById(R.id.chk_color_6);
        chkColor[6] = (CheckBox) findViewById(R.id.chk_color_7);
        chkColor[7] = (CheckBox) findViewById(R.id.chk_color_8);
        chkColor[8] = (CheckBox) findViewById(R.id.chk_color_9);
        chkColor[9] = (CheckBox) findViewById(R.id.chk_color_10);

        rdoColor[0] = (RadioButton) findViewById(R.id.rdoColor1);
        rdoColor[1] = (RadioButton) findViewById(R.id.rdoColor2);
        rdoColor[2] = (RadioButton) findViewById(R.id.rdoColor3);
        rdoColor[3] = (RadioButton) findViewById(R.id.rdoColor4);
        rdoColor[4] = (RadioButton) findViewById(R.id.rdoColor5);
        rdoColor[5] = (RadioButton) findViewById(R.id.rdoColor6);
        rdoColor[6] = (RadioButton) findViewById(R.id.rdoColor7);
        rdoColor[7] = (RadioButton) findViewById(R.id.rdoColor8);
        rdoColor[8] = (RadioButton) findViewById(R.id.rdoColor9);
        rdoColor[9] = (RadioButton) findViewById(R.id.rdoColor10);

        //SQLite Open Helper
        final CategoryOpenHelper dbHelper = new CategoryOpenHelper(this);


        btnColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPicker(CreateCatagory.this, CreateCatagory.this, Color.RED).show();
            }
        });

        btnSetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColor();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputRed.setText(R.string.zero);
                inputGreen.setText(R.string.zero);
                inputBlue.setText(R.string.zero);
                for(int i=0; i<chkColor.length; i++){
                    chkColor[i].setBackgroundColor(getResources().getColor(R.color.white));
                }
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = categoryName.getText().toString();
                int color = Color.rgb(Integer.parseInt(inputRed.getText().toString()), Integer.parseInt(inputGreen.getText().toString()), Integer.parseInt(inputBlue.getText().toString()));

                Category category = new Category(name, color);

                int newId = dbHelper.addCategory(category);
                category.setId(newId);

                Intent i = new Intent(CreateCatagory.this, MainActivity.class);
                i.putExtra("id", newId);

                startActivity(i);
            }
        });



    }

    public void setColor(){
        colorChosen = Color.rgb(
                Integer.parseInt(inputRed.getText().toString()),
                Integer.parseInt(inputGreen.getText().toString()),
                Integer.parseInt(inputBlue.getText().toString()));

        Color.colorToHSV(colorChosen, colorChosenHsv);
        colorHSVTemp = colorChosenHsv;


        for(int i=chkColor.length-1; i>=0; i--){
            brightnessValue = i/10.0F;
            colorHSVTemp[1] = 1.0F-brightnessValue;
            colorTemp=Color.HSVToColor(colorHSVTemp);
            chkColor[i].setBackgroundColor(colorTemp);
        }

        for(int j=rdoColor.length-1; j>=0; j--){
            brightnessValue = j/10.0F;
            colorHSVTemp[1] = 1.0F-brightnessValue;
            colorTemp=Color.HSVToColor(colorHSVTemp);
            rdoColor[j].setBackgroundColor(colorTemp);
        }


    }

    @Override
    public void colorChanged(int color) {
        inputRed.setText(Integer.toString(Color.red(color)));
        inputGreen.setText(Integer.toString(Color.green(color)));
        inputBlue.setText(Integer.toString(Color.blue(color)));
    }

    Activity activity;

    public void getColor(View v) {
        new ColorPicker(activity, CreateCatagory.this, Color.WHITE)
                .show();
    }


}
