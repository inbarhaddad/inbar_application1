package com.example.inbar_application1.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.inbar_application1.R;
import com.example.inbar_application1.model.CluesOnClick;
import java.util.ArrayList;

public class MainGameScreen extends AppCompatActivity implements CluesOnClick {
    private ImageView cluePic;
    private ClueAdapter clueAdapter;
    private Button sendToNextScreen;
    private ArrayList<Clue> collectedClues;
    private ArrayList<Clue> allTheClues;
    private FrameLayout frameLayout;
    private ImageView roomView;
    private int numScreen;
    private TextView howManyClues;
    private TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_screen);
        collectedClues = new ArrayList<>();
        allTheClues = new ArrayList<>();
        allTheClues.add(new Clue(1, "table",R.drawable.table,470, 280, 800, 460 ));
        allTheClues.add(new Clue(1, "key",R.drawable.clue1,560, 200, 680, 235 ));
        allTheClues.add(new Clue(1, "locker",R.drawable.locker,1390, 605, 1550, 780 ));
        allTheClues.add(new Clue(2,"pinned note",R.drawable.pinnednote,250, 480, 380, 545));
        allTheClues.add(new Clue(2,"laptop",R.drawable.laptopbenjamin,1280, 510, 1440, 610));
        allTheClues.add(new Clue(2,"book",R.drawable.pinnednote,1530, 500, 1600, 555));

        howManyClues = findViewById(R.id.howMuchCluesFound);
        location = findViewById(R.id.locationTheProHouse);

        RecyclerView recyclerView = findViewById(R.id.cluesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        clueAdapter = new ClueAdapter(collectedClues, this);
        recyclerView.setAdapter(clueAdapter);

        frameLayout = findViewById(R.id.frame_layout_screen);
//        RoomView roomView = new RoomView(this);

        numScreen = 1;
        roomView = new ImageView(this);
        roomView.setScaleType(ImageView.ScaleType.FIT_XY);
//        roomView.setImageResource(R.drawable.messy);
        init();
        frameLayout.addView(roomView);
        roomView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                Clue c = returnTheClue( x, y);
                if (c != null){
                    onClickFrameLayout(c);
                }
//                Toast.makeText(MainGameScreen.this, x+" +"+y,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
    public boolean checkIfExists(String description){
        for (int i = 0; i < collectedClues.size() ; i++) {
            if (collectedClues.get(i).getDescription().equals(description))
            return true;
        }
        return false;
    }
    public Clue returnTheClue(float x,  float y){
        for (int i = 0; i< allTheClues.size(); i++){
            if (x >= allTheClues.get(i).getX0() && x<= allTheClues.get(i).getX1() && y>= allTheClues.get(i).getY0() && y <= allTheClues.get(i).getY1() ){
                return allTheClues.get(i);
            }
        }
        return null;
    }
    private  void init(){
        if (numScreen == 1){
            roomView.setImageResource(R.drawable.messywithclues);
        }
        if (numScreen == 2){
            roomView.setImageResource(R.drawable.atticeithclues);
            collectedClues.clear();
            clueAdapter.notifyDataSetChanged();
            howManyClues.setText(collectedClues.size()+" clues have collected");
            location.setText("you are located in: the professor's attic ");
        }
    }
    public boolean checkIfAllCollected(){
        int num = 0;
        for (int i = 0; i < collectedClues.size() ; i++) {

              num = num+ 1;
        }
        if (num == 4&& numScreen == 1 || num == 3 && numScreen ==2){
            return true;
        }
        return false;
    }
    public void onClickFrameLayout(Clue c){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.clue_dialog);
        if (c.getDescription().equals("key")&&!checkIfExists("key")&& numScreen ==1){
            c.setIcon(R.drawable.clue1);
            collectedClues.add(c);
            ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(c.getIcon());
            ((TextView)dialog.findViewById(R.id.clueDescription)).setText("you found a key! but what does it open?");
            dialog.show();
            clueAdapter.notifyDataSetChanged();
            howManyClues.setText(collectedClues.size()+" clues have collected");
        }
        if (c.getDescription().equals("locker") &&!checkIfExists("locker")&&numScreen ==1){
            c.setIcon(R.drawable.locker);

            if (checkIfExists("key")){
                collectedClues.add(c);
                Clue note = new Clue(1, "note",R.drawable.note, 0,0,0,0);
                collectedClues.add(note);
                ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(note.getIcon());
                ((TextView)dialog.findViewById(R.id.clueDescription)).setText("you opened the locker! that was whats inside!");
                howManyClues.setText(collectedClues.size()+" clues have collected");
            }
            else{
                ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(c.getIcon());
                ((TextView)dialog.findViewById(R.id.clueDescription)).setText("you found a locked box! try to look for a key to open it and then come back!");
            }
            dialog.show();
            clueAdapter.notifyDataSetChanged();
        }
        if(c.getDescription().equals("table") && !checkIfExists("table")&&numScreen ==1){
            c.setIcon(R.drawable.table);
            collectedClues.add(c);
            ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(c.getIcon());
            ((TextView)dialog.findViewById(R.id.clueDescription)).setText("wonder why the red circles are there..");
            dialog.show();
            clueAdapter.notifyDataSetChanged();
            howManyClues.setText(collectedClues.size()+" clues have collected");
        }
        if(c.getDescription().equals("book") && !checkIfExists("book")&&numScreen ==2){
            c.setIcon(R.drawable.bluebook);
            collectedClues.add(c);
            ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(c.getIcon());
            ((TextView)dialog.findViewById(R.id.clueDescription)).setText("to do list? whats that all about?");
            dialog.show();
            clueAdapter.notifyDataSetChanged();
            howManyClues.setText(collectedClues.size()+" clues have collected");
        }
        if(c.getDescription().equals("pinned note") && !checkIfExists("pinned note")&&numScreen ==2){
            c.setIcon(R.drawable.pinnednote);
            collectedClues.add(c);
            ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(c.getIcon());
            ((TextView)dialog.findViewById(R.id.clueDescription)).setText("what is blue and also has pages?");
            dialog.show();
            clueAdapter.notifyDataSetChanged();
            howManyClues.setText(collectedClues.size()+" clues have collected");
        }
        if(c.getDescription().equals("laptop") && !checkIfExists("laptop")&&numScreen ==2){
            c.setIcon(R.drawable.laptopbenjamin);
            collectedClues.add(c);
            ((ImageView)dialog.findViewById(R.id.iconClue)).setImageResource(c.getIcon());
            ((TextView)dialog.findViewById(R.id.clueDescription)).setText("once youll collect all the clues in the room, click done and guess the computer password");
            dialog.show();
            clueAdapter.notifyDataSetChanged();
            howManyClues.setText(collectedClues.size()+" clues have collected");
        }
    }
    public  void onClickItem(View view){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.clue_dialog);
        if (view.getTag().toString().equals("done")){
            if (checkIfAllCollected()){
                dialog.setContentView(R.layout.moving_screen_dialog);
                if (numScreen == 2){ ((TextView)dialog.findViewById(R.id.cluesCollected)).setText("guess the password based on the clues: you only have one shot");}
                final EditText edit=(EditText)dialog.findViewById(R.id.type);
                edit.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }
                    @Override
                    public void afterTextChanged(Editable s) {
                        String text= edit.getText().toString();
                        if(text.equals("attic") && numScreen ==1){
//                            startActivity(new Intent(MainGameScreen.this, AtticScreen.class));

                            numScreen++;
                            init();
                            text = "";
                        }
                        if (numScreen == 2 && text.equals("carrots")){
                            startActivity(new Intent(MainGameScreen.this, WinnerActivity.class));
                        }
                        if (numScreen == 2 && !text.equals("attic") && !text.equals("carrots") && text.length() >= 7){ startActivity(new Intent(MainGameScreen.this, LoserActivity.class));}


                    }
                });
                dialog.show();
            }
            else{
                Toast.makeText(MainGameScreen.this, "you didnt collect all the clues",Toast.LENGTH_SHORT).show();
            }
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
