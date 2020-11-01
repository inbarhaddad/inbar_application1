package com.example.inbar_application1.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inbar_application1.model.User;
import  com.example.inbar_application1.R;

import java.util.ArrayList;

public class UserArrayAdapter extends ArrayAdapter<User> {

    public UserArrayAdapter(@NonNull Context context,@NonNull ArrayList<User> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View listItemView, @NonNull ViewGroup parent) {
       if (listItemView == null){
           listItemView = LayoutInflater.from(getContext()).inflate(
                   R.layout.list_view_user, parent, false);
       }
       User user = getItem(position);
       TextView nameTextView = listItemView.findViewById(R.id.name);
       nameTextView.setText(user.getName());

       ImageView avatarImage = listItemView.findViewById(R.id.image_avatar);
       avatarImage.setImageResource(R.drawable.ic_favorite_border_black_24dp);
       return listItemView;
    }
}
