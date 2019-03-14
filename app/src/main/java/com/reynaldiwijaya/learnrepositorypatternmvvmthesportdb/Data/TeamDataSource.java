package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.Team;

public interface TeamDataSource {

    void getListTeam(GetTeamsCallback getTeamsCallback);

    interface GetTeamsCallback {

        void onTeamLoaded(Team data);
        void onDataNotAvailable(String error);
    }

}
