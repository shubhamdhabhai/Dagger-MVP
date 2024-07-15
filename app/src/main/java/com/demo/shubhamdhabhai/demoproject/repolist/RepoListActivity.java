package com.demo.shubhamdhabhai.demoproject.repolist;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.demo.shubhamdhabhai.demoproject.BaseActivity;
import com.demo.shubhamdhabhai.demoproject.BaseApplication;
import com.demo.shubhamdhabhai.demoproject.R;
import com.demo.shubhamdhabhai.demoproject.api.github.DaggerGithubApiComponent;
import com.demo.shubhamdhabhai.demoproject.api.github.GithubApiComponent;
import com.demo.shubhamdhabhai.demoproject.api.github.GithubApiModule;
import com.demo.shubhamdhabhai.demoproject.model.Repo;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RepoListActivity extends BaseActivity implements RepoListContract.IRepoListView {

    @BindView(R.id.et_username)
    EditText userNameEt;

    @BindView(R.id.rv_repo_list)
    RecyclerView repoListRv;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    RepoListContract.IRepoListPresenter repoListPresenter;

    @Inject
    RepoListAdapter repoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        ButterKnife.bind(this);
        GithubApiComponent githubApiComponent = DaggerGithubApiComponent.builder()
                .appComponent(((BaseApplication) getApplication()).getAppComponent())
                .githubApiModule(new GithubApiModule())
                .build();

        RepoListComponent repoListComponent = DaggerRepoListComponent.builder()
                .githubApiComponent(githubApiComponent)
                .repoListModule(new RepoListModule(this))
                .build();
        repoListComponent.inject(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        repoListRv.setLayoutManager(layoutManager);
    }

    @OnClick(R.id.tv_search_repo)
    public void clickSearchRepo() {
        if(TextUtils.isEmpty(userNameEt.getText())) {
            Snackbar.make(userNameEt, "Enter A valid user name", Snackbar.LENGTH_LONG).show();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        repoListPresenter.getGithubRepoList(userNameEt.getText().toString());
    }

    @Override
    public void onGetRepoListSuccess(List<Repo> repoList) {
        repoListAdapter.clear();
        repoListAdapter.addAll(repoList);
        repoListRv.setAdapter(repoListAdapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onGetRepoListFailure(Throwable throwable) {
        progressBar.setVisibility(View.GONE);
        Snackbar.make(userNameEt, "Could not fetch repo for this user name", Snackbar.LENGTH_LONG).show();
    }
}
