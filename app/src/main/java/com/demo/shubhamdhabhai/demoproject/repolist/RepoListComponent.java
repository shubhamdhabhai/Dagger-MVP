package com.demo.shubhamdhabhai.demoproject.repolist;

import com.demo.shubhamdhabhai.demoproject.api.github.GithubApiComponent;

import dagger.Component;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@RepoListScope
@Component(dependencies = {GithubApiComponent.class}, modules = {RepoListModule.class})
public interface RepoListComponent {

    void inject(RepoListActivity repoListActivity);
}
