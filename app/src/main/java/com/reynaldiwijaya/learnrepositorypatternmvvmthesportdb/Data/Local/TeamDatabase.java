package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.TeamDetail;

@Database(entities = TeamDetail.class, version = 1)
public abstract class TeamDatabase extends RoomDatabase {

    private static TeamDatabase INSTANCE;

    public abstract TeamDAO teamDAO();

    private static final Object sLock = new Object();

    public static TeamDatabase getINSTANCE(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        TeamDatabase.class, "team.db")
                        .build();
            }
        }
        return INSTANCE;
    }

}
