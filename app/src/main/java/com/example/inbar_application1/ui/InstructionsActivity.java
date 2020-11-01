package com.example.inbar_application1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.inbar_application1.R;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instractions);
    }

    public void letsDoThis(View view) {
        startActivity(new Intent(this, MainGameScreen.class));
    }
}
