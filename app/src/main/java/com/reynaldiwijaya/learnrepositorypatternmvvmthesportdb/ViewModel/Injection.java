package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.ViewModel;

import android.content.Context;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Local.TeamLocalDataSource;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Remote.TeamRemoteDataSource;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.TeamRepository;

public class Injection {

    public static TeamRepository provideTeamRepository(Context context) {
        return new TeamRepository(new TeamRemoteDataSource(), new TeamLocalDataSource(context));
    }
}
