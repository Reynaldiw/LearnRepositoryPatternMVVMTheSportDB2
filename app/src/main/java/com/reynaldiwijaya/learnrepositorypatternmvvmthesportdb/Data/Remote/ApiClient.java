package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Data.Remote;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Utils.Constans;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constans.BASE_URL)
                .build();

        return retrofit;
    }
}
