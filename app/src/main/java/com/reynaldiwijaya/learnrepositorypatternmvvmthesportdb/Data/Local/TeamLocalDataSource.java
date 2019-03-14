package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Local;

import android.content.Context;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.TeamDataSource;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.Team;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.TeamDetail;

import java.util.List;

public class TeamLocalDataSource implements TeamDataSource {

    private Context context;
    private TeamDAO teamDAO;

    public TeamLocalDataSource(Context context) {
        this.context = context;
        teamDAO = TeamDatabase.getINSTANCE(context).teamDAO();
    }

    @Override
    public void getListTeam(final GetTeamsCallback getTeamsCallback) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<TeamDetail> teams = teamDAO.getTeams();

                if (teams.isEmpty()) {
                    getTeamsCallback.onDataNotAvailable("Data is not available");
                } else {
                    Team team = new Team(teams);
                    getTeamsCallback.onTeamLoaded(team);
                }
            }
        };
        new Thread(runnable).start();

    }

    public void saveDataTeam(final List<TeamDetail> teamDetails) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                teamDAO.insertTeam(teamDetails);
            }
        };
        new Thread(runnable).start();
    }
}
