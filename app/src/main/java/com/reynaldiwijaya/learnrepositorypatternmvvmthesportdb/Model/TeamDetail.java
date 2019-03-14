package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Utils.Constans;

@Entity(tableName = "team")
public class TeamDetail {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "teamName")
    @SerializedName("strTeam")
    public String teamName;

    @ColumnInfo(name = "teamLogo")
    @SerializedName("strTeamBadge")
    public String teamLogo;

    public TeamDetail(int id, String teamName, String teamLogo) {
        this.id = id;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }
}
