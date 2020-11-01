package com.example.inbar_application1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.inbar_application1.R;

import java.util.ArrayList;

public class OpenScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_scrn);


    }

    public void letsStart(View view) {
        startActivity(new Intent(this, PickYourAvatarActivity.class));
    }
}
