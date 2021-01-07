package com.example.inbar_application1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.inbar_application1.R;

public class LoserActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loser);
//        frameLayout = findViewById(R.id.frame_layout_room);
//        RoomView roomView = new RoomView(this);
//        frameLayout.addView(roomView);
//        roomView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                float x = event.getX();
//                float y = event.getY();
//                Toast.makeText(LoserActivity.this, x+"",Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
    }
    public void onClick(View v){
        startActivity(new Intent(LoserActivity.this, OpenScreenActivity.class));
    }
}
