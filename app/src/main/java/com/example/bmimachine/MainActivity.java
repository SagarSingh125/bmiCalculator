package com.example.bmimachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText enteredWeight,enteredHeightInch,enteredHeightFt;
        Button calculateBmi;
        TextView testResult;
        LinearLayout llMain;


        enteredWeight = findViewById(R.id.enteredWeight);
        enteredHeightInch = findViewById(R.id.enteredHeightInch);
        enteredHeightFt = findViewById(R.id.enteredHeightFt);
        calculateBmi = findViewById(R.id.calculateBmi);
        testResult = findViewById(R.id.testResult);
        llMain= findViewById(R.id.llMain);

        calculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(enteredWeight.getText().toString());
                int ft=Integer.parseInt(enteredHeightFt.getText().toString());
                int inc=Integer.parseInt(enteredHeightInch.getText().toString());

                int totalIn = ft*12 +inc;
                double totalCm= totalIn*2.54;
                double totalM=totalCm/100;
                double bmi=wt/(totalM*totalM);

                if(bmi>25){
                    testResult.setText(R.string.you_are_over_weight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (bmi<18){
                    testResult.setText(R.string.you_are_under_weight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    testResult.setText(R.string.you_are_fit);
                    llMain.setBackgroundColor(getResources().getColor(R.color.green));
                }

            }
        });


    }
}