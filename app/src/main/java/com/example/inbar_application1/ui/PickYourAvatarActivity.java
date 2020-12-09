package com.example.inbar_application1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.inbar_application1.R;

import java.util.ArrayList;

public class PickYourAvatarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_your_avatar);
        RecyclerView recyclerView = findViewById(R.id.profiles);
        recyclerView.setAdapter(new ProfilesAdapter(new ArrayList<Integer>()));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }


    public void startPlay(View view) {
        startActivity(new Intent(this, InstructionsActivity.class));
    }
}
