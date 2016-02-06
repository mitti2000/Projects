package com.mittidesign.whereismymoney;

import android.app.Activity;
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

public class MainActivity extends AppCompatActivity implements ColorPicker.OnColorChangedListener{

    EditText redValueString;
    EditText greenValueString;
    EditText blueValueString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redValueString = (EditText)findViewById(R.id.redValue);
        greenValueString = (EditText)findViewById(R.id.greenValue);
        blueValueString = (EditText)findViewById(R.id.blueValue);
        redValueString.setText("150");
        greenValueString.setText("50");
        blueValueString.setText("80");
        final TextView txtError = (TextView)findViewById(R.id.txtError);
        final FrameLayout colorField = (FrameLayout) findViewById(R.id.colorChosen);
        final FrameLayout colorDarker = (FrameLayout) findViewById(R.id.colorDarker);
        final FrameLayout colorBrighter = (FrameLayout) findViewById(R.id.colorBrighter);

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
                if (greenValue<0 || greenValue>255) txtError.setText("Falsche Werte");
                blueValue = Integer.parseInt(blueValueString.getText().toString());
                if (blueValue<0 || blueValue>255) txtError.setText("Falsche Werte");

                float[] hsvColor = new float[3];
                int fieldColor = Color.rgb(redValue, greenValue, blueValue);
                Color.colorToHSV(fieldColor, hsvColor);

                float hsvColorBrighter[] = {hsvColor[0], hsvColor[1]-0.4F, hsvColor[2]};
                float hsvColorDarker[] = {hsvColor[0], hsvColor[1]-0.2F, hsvColor[2]};

                int darkerColor = Color.HSVToColor(hsvColorDarker);
                int brighterColor = Color.HSVToColor(hsvColorBrighter);
                //Log.d("Color", "HSV Color 0 = " + hsvColor[0] + ", HSV Color 1 = " + hsvColor[1] + ", HSV Color 2 = " + hsvColor[2]);
                //Log.d("FieldColor", "Field Color = " + fieldColor);
                colorField.setBackgroundColor(fieldColor);
                colorBrighter.setBackgroundColor(brighterColor);
                colorDarker.setBackgroundColor(darkerColor);
            }
        });

        final Button btnColorPicker = (Button) findViewById(R.id.btnColorPicker);
        btnColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPicker(MainActivity.this, MainActivity.this, Color.RED).show();
            }
        });
    }

    @Override
    public void colorChanged(int color) {
        redValueString.setText(Integer.toString(Color.red(color)));
        greenValueString.setText(Integer.toString(Color.green(color)));
        blueValueString.setText(Integer.toString(Color.blue(color)));
        float[] hsvColor = new float[3];
        Color.colorToHSV(color, hsvColor);
        Log.d("Color", "HSV1 = " + hsvColor[0] + ", HSV2 = " + hsvColor[1] + ", HSV2 = " + hsvColor[2]);
    }

    Activity activity;

    public void getColor(View v) {
        new ColorPicker(activity, MainActivity.this, Color.WHITE)
                .show();
    }
}
