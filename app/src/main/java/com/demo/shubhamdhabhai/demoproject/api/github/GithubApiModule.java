package com.demo.shubhamdhabhai.demoproject.api.github;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@Module
public class GithubApiModule {

    @GithubApiScope
    @Provides
    public GitHubApiService provideGithubApiService(OkHttpClient client, GsonConverterFactory gsonConverterFactory) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(client)
                .addConverterFactory(gsonConverterFactory)
                .build();
        return retrofit.create(GitHubApiService.class);
    }
}
