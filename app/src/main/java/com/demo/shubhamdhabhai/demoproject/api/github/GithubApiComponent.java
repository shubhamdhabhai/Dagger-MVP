package com.demo.shubhamdhabhai.demoproject.api.github;

import com.demo.shubhamdhabhai.demoproject.AppComponent;

import dagger.Component;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@GithubApiScope
@Component(dependencies = {AppComponent.class}, modules = {GithubApiModule.class})
public interface GithubApiComponent {
    GitHubApiService getGithubApiService();
}
