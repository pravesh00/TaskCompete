package com.five5.taskcompete.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.five5.taskcompete.Data.competition_data;
import com.five5.taskcompete.R;

import java.util.ArrayList;

public class CompetitionAdapter extends RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder> {
    ArrayList<competition_data> Competitions;

    public CompetitionAdapter(ArrayList<competition_data> competitions) {
        Competitions = competitions;
    }

    public CompetitionAdapter() {
    }

    @NonNull
    @Override
    public CompetitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.competition,parent,false);
        CompetitionViewHolder cvh= new CompetitionViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CompetitionViewHolder holder, int position) {
        competition_data currComp=Competitions.get(position);
        holder.compName.setText(currComp.getComp_name());
        holder.compDays.setText(currComp.getComp_days());
        holder.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return Competitions.size();
    }

    public class CompetitionViewHolder extends RecyclerView.ViewHolder{
        TextView compName,compDays;
        RelativeLayout lay;
        public CompetitionViewHolder(@NonNull View itemView) {
            super(itemView);
            compName=itemView.findViewById(R.id.txtCompName);
            compDays=itemView.findViewById(R.id.txtCompDays);
            lay=itemView.findViewById(R.id.CompLay);
        }
    }
}
