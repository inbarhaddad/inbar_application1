package com.example.inbar_application1.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inbar_application1.R;

import java.util.ArrayList;

public class ProfilesAdapter  extends RecyclerView.Adapter<ProfilesAdapter.ProfilesViewHolder> {
    ArrayList<Integer> pics = new ArrayList<>();

    public ProfilesAdapter(ArrayList<Integer> pics) {
        this.pics = pics;
        pics.add(R.drawable.profile);
        pics.add(R.drawable.profile3);
        pics.add(R.drawable.profile4);
        pics.add(R.drawable.profile5);
        pics.add(R.drawable.profile6);
        pics.add(R.drawable.profile7);
        pics.add(R.drawable.profile8);
        pics.add(R.drawable.profile9);

    }

    @NonNull
    @Override
    public ProfilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_layout,parent,false);
        return new ProfilesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfilesViewHolder holder, int position) {
        holder.imageView.setImageResource(pics.get(position));

    }

    @Override
    public int getItemCount() {
        return pics.size();
    }

    class ProfilesViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public ProfilesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profilePic);
        }
    }
}
