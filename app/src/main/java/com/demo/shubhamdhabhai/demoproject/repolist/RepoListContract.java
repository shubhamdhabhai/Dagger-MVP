package com.demo.shubhamdhabhai.demoproject.repolist;

import com.demo.shubhamdhabhai.demoproject.model.Repo;

import java.util.List;

/**
 * Created by shubhamdhabhai on 25/01/18.
 */

public interface RepoListContract {

    public interface IRepoListPresenter {
        void getGithubRepoList(String username);
    }

    public interface IRepoListView {
        void onGetRepoListSuccess(List<Repo> repoList);
        void onGetRepoListFailure(Throwable throwable);

    }
}
