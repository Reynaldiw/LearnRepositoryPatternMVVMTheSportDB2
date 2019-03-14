package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Team extends BaseObservable {

    @SerializedName("teams")
    List<TeamDetail> teams;

    public Team(List<TeamDetail> teams) {
        this.teams = teams;
    }

    @Bindable
    public List<TeamDetail> getTeams() {
        return teams;
    }
}
