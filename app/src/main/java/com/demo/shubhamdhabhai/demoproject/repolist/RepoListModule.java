package com.demo.shubhamdhabhai.demoproject.repolist;

import com.demo.shubhamdhabhai.demoproject.api.github.GitHubApiService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@Module
public class RepoListModule {
    private RepoListContract.IRepoListView repoListView;

    public RepoListModule(RepoListContract.IRepoListView view) {
        repoListView = view;
    }

    @Provides
    @GithubRepoScope
    public RepoListContract.IRepoListPresenter providesRepoListPresenter(GitHubApiService apiService) {
        return new RepoListPresenter(repoListView, apiService);
    }

    @Provides
    @GithubRepoScope
    public RepoListAdapter providesRepoAdapter() {
        return new RepoListAdapter();
    }

}
