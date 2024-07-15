package com.demo.shubhamdhabhai.demoproject.repolist;

import com.demo.shubhamdhabhai.demoproject.api.github.GitHubApiService;
import com.demo.shubhamdhabhai.demoproject.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shubhamdhabhai on 25/01/18.
 */

public class RepoListPresenter implements RepoListContract.IRepoListPresenter {


    private final RepoListContract.IRepoListView view;
    private final GitHubApiService githubApiService;

    public RepoListPresenter(RepoListContract.IRepoListView view, GitHubApiService githubApiService) {
        this.view = view;
        this.githubApiService = githubApiService;
    }

    @Override
    public void getGithubRepoList(String username) {
        githubApiService.getRepoFromUserName(username).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                view.onGetRepoListSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                view.onGetRepoListFailure(t);
            }
        });
    }
}
