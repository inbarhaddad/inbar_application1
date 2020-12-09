package com.example.inbar_application1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inbar_application1.R;
import com.example.inbar_application1.model.CluesOnClick;

import java.util.ArrayList;

public class MainGameScreen extends AppCompatActivity implements CluesOnClick {
    private ImageView cluePic;
    private ClueAdapter clueAdapter;
    private ArrayList<Clue> clues;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_screen);
        clues = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.cluesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        clueAdapter = new ClueAdapter(clues, this);
        recyclerView.setAdapter(clueAdapter);
    }
    public boolean checkIfExists(String description){
        for (int i = 0; i < clues.size() ; i++) {
            if (clues.get(i).getDescription().equals(description))
            return true;
        }
        return false;
    }
    public boolean checkIfAllCollected(){
        int num = 0;
        for (int i = 0; i < clues.size() ; i++) {

              num = num+ 1;
        }
        if (num == 4){
            return true;
        }
        return false;
    }

    public  void onClickItem(View view){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.clue_dialog);
        Dialog moveScreen = new Dialog(this);
        dialog.setContentView(R.layout.moving_screen_dialog);
        Clue clue = new Clue(1, view.getTag().toString(),0);
        if(view.getTag().toString().equals("key") && !checkIfExists("key")){
            clue.setIcon(R.drawable.clue1);
            clues.add(clue);
            ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(clue.getIcon());
            ((TextView)dialog.findViewById(R.id.clueDescription)).setText(clue.getDescription());
            dialog.show();
            clueAdapter.notifyDataSetChanged();
        }
        if (view.getTag().toString().equals("locker")&&!checkIfExists("locker")){
            clue.setIcon(R.drawable.locker);

            if (checkIfExists("key")){
                clues.add(clue);
                Clue note = new Clue(1, "locker",R.drawable.note);
                clues.add(note);
                ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(note.getIcon());
                ((TextView)dialog.findViewById(R.id.clueDescription)).setText("you opend the locker! that was whats inside!");
            }
            else{
                ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(clue.getIcon());
                ((TextView)dialog.findViewById(R.id.clueDescription)).setText("you found a locked box! try to look for a key to open it and then come back!");
            }
            dialog.show();
            clueAdapter.notifyDataSetChanged();
        }

        if(view.getTag().toString().equals("table") && !checkIfExists("table")){
            clue.setIcon(R.drawable.table);
            clues.add(clue);
            ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(clue.getIcon());
            ((TextView)dialog.findViewById(R.id.clueDescription)).setText("wonder why the red circles are there..");
            dialog.show();
            clueAdapter.notifyDataSetChanged();
        }



    }


    @Override
    public void onClickClueListener(Clue clue) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.clue_dialog);
        ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(clue.getIcon());
        ((TextView)dialog.findViewById(R.id.clueDescription)).setText(clue.getDescription());
        dialog.show();

    }
}
