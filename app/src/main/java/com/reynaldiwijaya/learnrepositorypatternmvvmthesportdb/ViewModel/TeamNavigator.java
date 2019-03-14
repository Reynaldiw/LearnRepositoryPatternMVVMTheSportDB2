package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.ViewModel;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.TeamDetail;

import java.util.List;

public interface TeamNavigator {

    void loadListTeam(List<TeamDetail> teams);
    void errorLoadListTeam(String error);
}
