package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imfb ,imig ,tqfb , tqig , github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("About ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imfb = findViewById(R.id.imfb);
        imig = findViewById(R.id.imig);
        tqfb = findViewById(R.id.tqfb);
        tqig= findViewById(R.id.tqig);
        github= findViewById(R.id.gt);

        imfb.setOnClickListener(this);
        imig.setOnClickListener(this);
        tqfb.setOnClickListener(this);
        tqig.setOnClickListener(this);
        github.setOnClickListener(this);



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
                startActivity(new Intent(AboutActivity.this, MainActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imfb:
                URL("http://www.facebook.com/NyanRomeo");
                break;
            case R.id.imig:
                URL("https://www.instagram.com/imransahrom/");
                break;
            case R.id.tqfb:
                URL("https://www.facebook.com/ating.yakuza/");
                break;
            case R.id.tqig:
                URL("https://www.instagram.com/abdmuntaqim/");
                break;
            case R.id.gt:
                URL("https://github.com/imran-1999/BMI-calculator.git");
                break;
            default:
        }

    }

    private void URL(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent (Intent.ACTION_VIEW, uri));
    }
}