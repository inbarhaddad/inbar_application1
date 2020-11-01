package com.example.inbar_application1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inbar_application1.R;

import java.util.ArrayList;

import com.example.inbar_application1.model.User;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersArrayList;
    private ListView usersListView;
    private  UserArrayAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersArrayList = new ArrayList<User>();
        usersArrayList.add(new User("inbar ", "haddad"));
        usersArrayList.add(new User("uuuuuu ", "hhhhh"));
        usersArrayList.add(new User("gggg ", "jjjjj"));
        usersArrayList.add(new User("ddddd ", "aaaaa"));
        usersArrayList.add(new User("bbbbb ", "ccccc"));

        usersListView = findViewById(R.id.listview_users);
        userAdapter = new UserArrayAdapter(this, usersArrayList);
        usersListView.setAdapter(userAdapter);
        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "clicked " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, SingelItemActivity.class);
                intent.putExtra("name", ((TextView)findViewById(R.id.name)).getText());
                startActivity(intent);
            }

        });
    }
}
