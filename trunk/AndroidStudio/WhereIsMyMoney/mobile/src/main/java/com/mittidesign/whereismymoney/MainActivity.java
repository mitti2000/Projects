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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity1 = (Button) findViewById(R.id.btn_startActivity1);

        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act1 = new Intent(MainActivity.this, CreateCatagory.class);
                startActivity(act1);
            }
        });


    }


}
