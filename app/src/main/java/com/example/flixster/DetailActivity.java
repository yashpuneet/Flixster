package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView dtvTitle;
    RatingBar drbRating;
    TextView dtvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dtvTitle = findViewById(R.id.dtvTitle);
        drbRating = findViewById(R.id.drbRating);
        dtvOverview = findViewById(R.id.dtvOverview);

        String title = getIntent().getStringExtra("title");
        dtvTitle.setText(title);
    }
}