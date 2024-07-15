package com.demo.shubhamdhabhai.demoproject.home;

import android.content.Intent;
import android.os.Bundle;

import com.demo.shubhamdhabhai.demoproject.BaseActivity;
import com.demo.shubhamdhabhai.demoproject.R;
import com.demo.shubhamdhabhai.demoproject.joblist.JobListActivity;
import com.demo.shubhamdhabhai.demoproject.repolist.RepoListActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_get_job_list)
    public void onJobListClicked() {
        startActivity(new Intent(this, JobListActivity.class));
    }

    @OnClick(R.id.tv_github_repo)
    public void onGithubRepoClicked() {
        startActivity(new Intent(this, RepoListActivity.class));
    }
}
