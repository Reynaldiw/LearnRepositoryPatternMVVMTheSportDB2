package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
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
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.databinding.ListTeanBinding;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private List<TeamDetail> teamDetails;

    private LayoutInflater layoutInflater;

    public TeamAdapter(List<TeamDetail> teamDetails) {
        this.teamDetails = teamDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        ListTeanBinding listTeanBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_tean, viewGroup, false);

        return new ViewHolder(listTeanBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder viewHolder, int i) {
        viewHolder.binding.setTeamDetailVm(teamDetails.get(i));
    }

    @Override
    public int getItemCount() {
        return teamDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ListTeanBinding binding;

        ViewHolder(ListTeanBinding listTeanBinding) {
            super(listTeanBinding.getRoot());
            this.binding = listTeanBinding;

        }
    }
}
