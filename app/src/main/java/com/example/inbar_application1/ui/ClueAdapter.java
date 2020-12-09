package com.example.inbar_application1.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inbar_application1.R;
import com.example.inbar_application1.model.CluesOnClick;

import java.util.ArrayList;

public class ClueAdapter extends RecyclerView.Adapter<ClueAdapter.ClueViewHolder> {
    private ArrayList<Clue> clues;
    private Context context;

    public ClueAdapter(ArrayList<Clue> clues, Context context ) {
        this.clues = clues;
        this.context = context;
    }

    @NonNull
    @Override
    public ClueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View clueView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem_clues , parent , false);
        return new ClueViewHolder(clueView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClueViewHolder holder, int position) {
        final Clue currentClue = clues.get(position);
        holder.decriptionTextView.setText(currentClue.getDescription());
        holder.iconImageView.setImageResource(currentClue.getIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CluesOnClick cluesOnClick = (CluesOnClick) context;
                cluesOnClick.onClickClueListener(currentClue);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clues.size();
    }

    public static class ClueViewHolder extends RecyclerView.ViewHolder {
        public TextView decriptionTextView;
        public ImageView iconImageView;

        public ClueViewHolder(@NonNull View itemView) {
            super(itemView);
            decriptionTextView = itemView.findViewById(R.id.decription);
            iconImageView = itemView.findViewById(R.id.imageClue);
        }
    }
}
