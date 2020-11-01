package com.example.inbar_application1.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.example.inbar_application1.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingelItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singel_item);
        TextView nameTextView = findViewById(R.id.text_view_name);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        nameTextView.setText(name);

    }
}
