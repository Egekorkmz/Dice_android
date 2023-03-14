package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView displayline1, displayline2, result;

    NumberPicker num_roll, num_face;

    Button roll;

    Switch displayOn;

    ScrollView display;

    Drawable border, main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayline1 = findViewById(R.id.DisplayLine1);
        displayline2 = findViewById(R.id.DisplayLine2);
        result = findViewById(R.id.result);
        display = findViewById(R.id.scrollView2);
        roll = findViewById(R.id.Roll);
        border = getDrawable(R.drawable.border);
        main = getDrawable(R.drawable.main);
        displayOn = findViewById(R.id.switch1);
        num_roll = findViewById(R.id.rollNum);
        num_face = findViewById(R.id.faceNum);
        num_face.setMinValue(4);
        num_face.setMaxValue(100);
        num_roll.setMinValue(1);
        num_roll.setMaxValue(100);
        display.setVisibility(View.GONE);
        result.setVisibility(View.GONE);
        getSupportActionBar().setBackgroundDrawable(main);


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0, num;
                String str1 = "", str2 = "";
                Random rand = new Random();

                for(int i = 1; i <= num_roll.getValue(); i++){
                    num = rand.nextInt(num_face.getValue()-1)+1;
                    sum += num;
                    if(i % 2 != 0){
                        str1 += i + ". roll --> " + num + "\n";
                    }else{
                        str2 += i + ". roll --> " + num + "\n";
                    }
                }

                displayline1.setText(str1);
                displayline2.setText(str2);
                result.setText("Total : " + sum);
                result.setVisibility(View.VISIBLE);
                if(displayOn.isChecked()){
                    display.setVisibility(View.VISIBLE);
                    display.setBackground(border);
                }
            }
        });

        displayOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(displayOn.isChecked()){
                    if(result.getText().length() > 0){
                        display.setVisibility(View.VISIBLE);
                        display.setBackground(border);
                    }
                }else{
                    display.setVisibility(View.GONE);
                }
            }
        });
    }
}