package com.five5.taskcompete.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.five5.taskcompete.Data.User_data;
import com.five5.taskcompete.R;

import java.util.ArrayList;

public class AddFriendAdapter extends RecyclerView.Adapter<AddFriendAdapter.AddFriendViewHolder> {
    ArrayList<User_data> users;

    public AddFriendAdapter(ArrayList<User_data> users) {
        this.users = users;
    }

    public AddFriendAdapter() {
    }

    @NonNull
    @Override
    public AddFriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_friend,parent,false);
        AddFriendViewHolder afvh=new AddFriendViewHolder(v);
        return afvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AddFriendViewHolder holder, int position) {
        User_data usr=users.get(position);
        holder.friend.setText(usr.getName());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class AddFriendViewHolder extends RecyclerView.ViewHolder{
        TextView friend;

        public AddFriendViewHolder(@NonNull View itemView) {
            super(itemView);
            friend=itemView.findViewById(R.id.txtNameNewFriend);
        }
    }
}
