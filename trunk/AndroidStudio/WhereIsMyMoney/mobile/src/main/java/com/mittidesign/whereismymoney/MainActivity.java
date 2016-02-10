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
import android.widget.TextView;

import com.google.android.gms.vision.Frame;

public class MainActivity extends AppCompatActivity{

    Button btnActivity1;
    TextView txtCategoryName;
    TextView txtCategoryID;
    TextView txtCategoryColor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity1 = (Button) findViewById(R.id.btn_startActivity1);

        txtCategoryColor = (TextView) findViewById(R.id.txtCategoryColor);
        txtCategoryName = (TextView) findViewById(R.id.txtCategoryName);
        txtCategoryID = (TextView) findViewById(R.id.txtCategoryID);




        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act1 = new Intent(MainActivity.this, CreateCatagory.class);
                startActivity(act1);
            }
        });

        Category category;
            Bundle bundle = getIntent().getExtras();
            if (bundle==null){
                txtCategoryID.setText("no ID");
                txtCategoryName.setText("no Name");
                txtCategoryColor.setBackgroundColor(Color.BLACK);
            }
            else{
                if (bundle.getInt("id") != 0) {
                    CategoryOpenHelper dbHelper = new CategoryOpenHelper(this);
                    category = dbHelper.getCategory(bundle.getInt("id"));
                    txtCategoryID.setText(category.getId());
                    txtCategoryName.setText(category.getName());
                    txtCategoryColor.setBackgroundColor(category.getColor());
                }
            }




    }


}
