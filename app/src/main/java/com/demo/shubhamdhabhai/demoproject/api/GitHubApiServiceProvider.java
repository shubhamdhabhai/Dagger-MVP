package com.demo.shubhamdhabhai.demoproject.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shubhamdhabhai on 25/01/18.
 */

public class GitHubApiServiceProvider {

    GitHubApiService providesApiService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // TODO: 08/04/16 might want to remove this in prod

        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);


        // Logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.interceptors().add(interceptor);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(GitHubApiService.class);
    }
}
