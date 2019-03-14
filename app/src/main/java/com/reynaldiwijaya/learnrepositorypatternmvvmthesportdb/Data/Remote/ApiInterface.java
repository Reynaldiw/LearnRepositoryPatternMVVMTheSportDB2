package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Remote;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/v1/json/1/search_all_teams.php")
    Call<Team> getAllTeam(@Query("l") String league);
}
