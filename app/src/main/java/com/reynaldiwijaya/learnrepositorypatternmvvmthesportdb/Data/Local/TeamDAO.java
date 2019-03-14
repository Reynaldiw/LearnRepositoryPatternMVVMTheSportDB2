package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.TeamDetail;

import java.util.List;

@Dao
public interface TeamDAO {

    @Query("SELECT * FROM team")
    List<TeamDetail> getTeams();

    @Insert
    void insertTeam(List<TeamDetail> teamDetails);
}
