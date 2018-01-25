package com.demo.shubhamdhabhai.demoproject.api;

import com.demo.shubhamdhabhai.demoproject.model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shubhamdhabhai on 25/01/18.
 */

public interface GitHubApiService {

    @GET("/users/{username}/repos")
    Call<List<Repo>> getRepoFromUserName(@Path("username") String username);
}
