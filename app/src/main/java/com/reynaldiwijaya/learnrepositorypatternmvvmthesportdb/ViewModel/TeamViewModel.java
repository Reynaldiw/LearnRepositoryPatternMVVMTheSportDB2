package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.ViewModel;

import android.content.Context;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.TeamDataSource;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.TeamRepository;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.Team;

public class TeamViewModel {

    private TeamRepository teamRepository;
    private TeamNavigator teamNavigator;

    public TeamViewModel(TeamRepository teamRepository, Context context) {
        this.teamRepository = teamRepository;
    }

    public void setTeamNavigator(TeamNavigator teamNavigator) {
        this.teamNavigator = teamNavigator;
    }

    public void getListTeam() {
        teamRepository.getListTeam(new TeamDataSource.GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                teamNavigator.loadListTeam(data.getTeams());
            }

            @Override
            public void onDataNotAvailable(String error) {
                teamNavigator.errorLoadListTeam(error);
            }
        });
    }
}
