package com.five5.taskcompete.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.five5.taskcompete.Data.notification;
import com.five5.taskcompete.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    ArrayList<notification> Notifications;

    public NotificationAdapter(ArrayList<notification> notifications) {
        Notifications = notifications;
    }

    public NotificationAdapter() {
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.notification,parent,false);
        NotificationViewHolder nvh=new NotificationViewHolder(v);

        return nvh;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        notification notify= Notifications.get(position);
        holder.notifTV.setText(notify.getContent());

    }

    @Override
    public int getItemCount() {
        return Notifications.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder{
        TextView notifTV;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            notifTV=itemView.findViewById(R.id.txtNotify);
        }
    }
}
