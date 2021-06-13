package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    float height,weight,heightincm;
    EditText he_txt ,w_txt;
    Button calc;
    ImageView reset;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        he_txt = findViewById(R.id.height_ts);
        w_txt = findViewById(R.id.weight);
        calc = findViewById(R.id.calculate);
        reset= findViewById(R.id.reset);

    sharedPref = this.getSharedPreferences("height", Context.MODE_PRIVATE);
    sharedPref = this.getSharedPreferences("weight", Context.MODE_PRIVATE);

        float hg = sharedPref.getFloat("height", 0);
        float wg = sharedPref.getFloat("weight", 0);
        he_txt.setText((String.valueOf(hg)));
        w_txt.setText((String.valueOf(wg)));

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    CalculateBMI();

                } catch (Exception exception) {

                    Toast.makeText(MainActivity.this, "Please enter your height or weight", Toast.LENGTH_SHORT).show();
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               reset();
            }
        });



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

            case R.id.about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void CalculateBMI() {


        height = Float.parseFloat(he_txt.getText().toString());

        heightincm = height / 100;
        weight =Float.parseFloat(w_txt.getText().toString());

        float BMI = weight / (heightincm*heightincm);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat("height", height);
        editor.putFloat("weight", weight);
        editor.apply();

        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
        intent.putExtra("BMI",BMI);
        startActivity(intent);
    }

    private void reset() {

        float reset = 0;

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat("height", reset);
        editor.putFloat("weight", reset);
        editor.apply();

        he_txt.setText("");
        w_txt.setText("");

    }



}