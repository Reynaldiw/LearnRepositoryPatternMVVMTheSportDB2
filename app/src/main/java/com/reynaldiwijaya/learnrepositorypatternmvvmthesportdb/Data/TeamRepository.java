package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Local.TeamLocalDataSource;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Remote.TeamRemoteDataSource;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.Team;

public class TeamRepository implements TeamDataSource {

    private TeamRemoteDataSource teamRemoteDataSource;
    private TeamLocalDataSource teamLocalDataSource;

    public TeamRepository(TeamRemoteDataSource teamRemoteDataSource, TeamLocalDataSource teamLocalDataSource) {
        this.teamRemoteDataSource = teamRemoteDataSource;
        this.teamLocalDataSource = teamLocalDataSource;
    }

    public void getTeamsFromRemote(final GetTeamsCallback getTeamsCallback) {

        teamRemoteDataSource.getListTeam(new GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                teamLocalDataSource.saveDataTeam(data.getTeams());
                getTeamsCallback.onTeamLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String error) {
                getTeamsCallback.onDataNotAvailable(error);
            }
        });

    }

    @Override
    public void getListTeam(final GetTeamsCallback getTeamsCallback) {
        teamLocalDataSource.getListTeam(new GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                getTeamsCallback.onTeamLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String error) {
                getTeamsFromRemote(getTeamsCallback);
            }
        });
    }
}
