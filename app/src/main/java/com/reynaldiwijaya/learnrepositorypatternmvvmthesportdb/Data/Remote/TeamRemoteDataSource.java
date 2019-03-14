package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Remote;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.TeamDataSource;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.Team;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamRemoteDataSource implements TeamDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);


    @Override
    public void getListTeam(final GetTeamsCallback getTeamsCallback) {
        Call<Team> call = apiInterface.getAllTeam("English Premier League");
        call.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                getTeamsCallback.onTeamLoaded(response.body());
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                getTeamsCallback.onDataNotAvailable(t.toString());
            }
        });
    }
}
