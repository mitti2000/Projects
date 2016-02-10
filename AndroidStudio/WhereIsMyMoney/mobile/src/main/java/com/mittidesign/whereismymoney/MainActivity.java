package com.mittidesign.whereismymoney;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    Button btnActivity1;
    TableLayout categoryList;
    List<Category> categories;
    TextView tableLine;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity1 = (Button) findViewById(R.id.btn_startActivity1);
        categoryList = (TableLayout) findViewById(R.id.categoryList);


        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act1 = new Intent(MainActivity.this, CreateCatagory.class);
                startActivity(act1);
            }
        });

        CategoryOpenHelper dbHelper = new CategoryOpenHelper(this);
        categories = dbHelper.getAllCategorys();
        for(Category category : categories){
            tableLine = new TextView(this);
            tableLine.setText("Category: " + category.getName() + ", ID: " + category.getId());
            tableLine.setBackgroundColor(category.getColor());
            categoryList.addView(tableLine);
        }



        //Category category;
            /*Bundle bundle = getIntent().getExtras();
            if (bundle==null){

            }
            else{
                if (bundle.getInt("id") != 0) {
                    CategoryOpenHelper dbHelper = new CategoryOpenHelper(this);
                    category = dbHelper.getCategory(bundle.getInt("id"));

                }
            }*/




    }


}
