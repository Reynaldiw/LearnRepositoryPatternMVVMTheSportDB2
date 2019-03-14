package com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Adapter.TeamAdapter;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.Model.TeamDetail;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.R;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.ViewModel.Injection;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.ViewModel.TeamNavigator;
import com.reynaldiwijaya.learnrepositorypatternmvvmthesportdb.ViewModel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamNavigator {

    private TeamViewModel teamViewModel;
    private RecyclerView rvTeam;

    private TeamAdapter teamAdapter;
    private List<TeamDetail> teamDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTeam = findViewById(R.id.rv_teams);
        teamViewModel = new TeamViewModel(Injection.provideTeamRepository(this), this);
        teamDetails = new ArrayList<>();
        teamViewModel.setTeamNavigator(this);
        teamViewModel.getListTeam();
        initAdapter();
    }

    private void initAdapter() {
        teamAdapter = new TeamAdapter(this, teamDetails);
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        rvTeam.setAdapter(teamAdapter);
    }

    @Override
    public void loadListTeam(List<TeamDetail> teams) {
        teamDetails.addAll(teams);
        teamAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListTeam(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }
}
