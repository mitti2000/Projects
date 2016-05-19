package com.mittidesign.whereismymoney;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.IOException;
import java.util.List;

public class CreateCatagory extends AppCompatActivity implements ColorPicker.OnColorChangedListener, AdapterView.OnItemSelectedListener {

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
    RadioGroup rdoColorGroup;

    //Spinner
    Spinner spnMasterCategory;
    Category master;

    //Colors
    int colorChosen;
    float[] colorChosenHsv = new float[3];
    float[] colorHSVTemp = new float[3];
    int colorTemp;
    float brightnessValue;

    //DB Helper
    CategoryOpenHelper dbHelper;


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

        rdoColorGroup = (RadioGroup) findViewById(R.id.rdo_colorChoice);
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

        //Spinner
        spnMasterCategory = (Spinner) findViewById(R.id.spin_Master_category);

        //SQLite Open Helper
        dbHelper = new CategoryOpenHelper(this);

        //Spinner
        spnMasterCategory.setAdapter(getCategoryArrayAdapter());


        //Buttons
        btnColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPicker(CreateCatagory.this, CreateCatagory.this, Color.RED).show();
                setColor();
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
                int color = Color.BLACK;

                Drawable radioButtonBackground = findViewById(rdoColorGroup.getCheckedRadioButtonId()).getBackground();
                if(radioButtonBackground instanceof ColorDrawable)
                    color = ((ColorDrawable) radioButtonBackground).getColor();
                else Log.d("Fehler", "Fehler");

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


        /*for(int i=chkColor.length-1; i>=0; i--){
            brightnessValue = i/10.0F;
            colorHSVTemp[1] = 1.0F-brightnessValue;
            colorTemp=Color.HSVToColor(colorHSVTemp);
            chkColor[i].setBackgroundColor(colorTemp);
        }*/

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

    public ArrayAdapter<String> getCategoryArrayAdapter(){
        List<Category> categories = dbHelper.getAllCategorys();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.master_category_spinner_layout);

        for(Category category : categories){
            adapter.add(category.getName());
        }

        return adapter;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        master = (Category) parent.getItemAtPosition(pos);
        Log.d("MasterCategory","Item is: " + master.getName());
    }

    public void onNothingSelected(AdapterView<?> parent){
        master = null;
    }


}
