package com.demo.shubhamdhabhai.demoproject.repolist;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.demo.shubhamdhabhai.demoproject.BaseActivity;
import com.demo.shubhamdhabhai.demoproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoListActivity extends BaseActivity {

    @BindView(R.id.rv_repo_list)
    RecyclerView repoListRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        ButterKnife.bind(this);
    }
}
