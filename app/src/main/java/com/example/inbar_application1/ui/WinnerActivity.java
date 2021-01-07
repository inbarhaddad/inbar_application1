package com.example.inbar_application1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.inbar_application1.R;

public class WinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
    }
    public void onClick(View v){
        startActivity(new Intent(WinnerActivity.this, OpenScreenActivity.class));
    }
}
