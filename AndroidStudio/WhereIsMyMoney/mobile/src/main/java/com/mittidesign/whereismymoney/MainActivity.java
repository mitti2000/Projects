package com.mittidesign.whereismymoney;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText redValueString = (EditText)findViewById(R.id.redValue);
        final EditText greenValueString = (EditText)findViewById(R.id.greenValue);
        final EditText blueValueString = (EditText)findViewById(R.id.blueValue);
        final TextView txtError = (TextView)findViewById(R.id.txtError);
        final FrameLayout colorField = (FrameLayout) findViewById(R.id.colorField);

        final Button btnChangeColor = (Button)findViewById(R.id.btnChangeColor);
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int redValue;
                int greenValue;
                int blueValue;
                redValue = Integer.parseInt(redValueString.getText().toString());
                if (redValue<0 || redValue>255) txtError.setText("Falsche Werte");
                greenValue = Integer.parseInt(greenValueString.getText().toString());
                if (greenValue<0 || redValue>255) txtError.setText("Falsche Werte");
                blueValue = Integer.parseInt(blueValueString.getText().toString());
                if (blueValue<0 || redValue>255) txtError.setText("Falsche Werte");

                int fieldColor = Color.rgb(redValue, blueValue, greenValue);

                colorField.setBackgroundColor(fieldColor);
            }
        });
    }
}
