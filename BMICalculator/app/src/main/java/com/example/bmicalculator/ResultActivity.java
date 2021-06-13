package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    private static DecimalFormat df = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        float BMI  = intent.getFloatExtra("BMI", 0);

        String cm  = df.format(BMI);
        TextView your_bmi = findViewById(R.id.bmi);
        your_bmi.setText(cm);

        TextView category = findViewById(R.id.category);
        category.setText(Category(BMI));

        TextView risk = findViewById(R.id.risk);
        risk.setText(Risk(BMI));

        TextView range = findViewById(R.id.range);
        range.setText(Range(BMI));



            getSupportActionBar().setTitle("BMI Result  ");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public String Category (double bmi) {
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi >=18.5 && bmi < 25) {
            category = "Normal Weight";
        } else if (bmi >=25 && bmi < 30) {
            category = "Overweight";
        } else if (bmi >=30 && bmi < 35) {
            category = "Moderately Obese";
        } else if (bmi >=35 && bmi <= 40) {
            category = "Severely Obese";
        }  else {
            category ="Very Severely Obese";
        }
        return category;
    }

    public String Risk (double bmi) {
        String risk;
        if (bmi < 18.5) {
            risk = "Malnutrition Risk";
        } else if (bmi >=18.5 && bmi <= 24.9) {
            risk = "Low Risk";
        } else if (bmi >=25 && bmi <= 29.9) {
            risk = "Enhanced Risk";
        } else if (bmi >=30 && bmi <= 34.9) {
            risk = "Medium Risk";
        } else if (bmi >=35 && bmi <= 39.9) {
            risk = "High Risk";
        }  else {
            risk ="Very High Risk";
        }
        return risk;
    }

    public String Range (double bmi) {
        String range;
        if (bmi < 18.5) {
            range = "18.5 and below";
        } else if (bmi >=18.5 && bmi <= 24.9) {
            range = "18.5 - 24.9";
        } else if (bmi >=25 && bmi <= 29.9) {
            range = "25 - 29.9";
        } else if (bmi >=30 && bmi <= 34.9) {
            range = "30 - 34.9";
        } else if (bmi >=35 && bmi <= 39.9) {
            range = "35 - 39.9";
        }  else {
            range ="40 and above";
        }
        return range;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.BMI:
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                return true;

            case R.id.about:
                startActivity(new Intent(ResultActivity.this, AboutActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}