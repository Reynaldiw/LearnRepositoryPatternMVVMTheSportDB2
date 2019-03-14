package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.TeamDetail;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.R;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private Context context;
    private List<TeamDetail> teamDetails;

    public TeamAdapter(Context context, List<TeamDetail> teamDetails) {
        this.context = context;
        this.teamDetails = teamDetails;
    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_tean, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvNama.setText(teamDetails.get(i).getTeamName());
        Glide.with(context)
                .load(teamDetails.get(i).getTeamLogo())
                .into(viewHolder.imgClub);
    }

    @Override
    public int getItemCount() {
        return teamDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama;
        ImageView imgClub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_club);
            imgClub = itemView.findViewById(R.id.imgClub);
        }
    }
}
