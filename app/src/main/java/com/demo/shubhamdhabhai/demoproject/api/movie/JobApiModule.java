package com.demo.shubhamdhabhai.demoproject.api.movie;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@Module
public class JobApiModule {

    @JobApiScope
    @Provides
    public JobApiService provideMovieApiService(OkHttpClient client, GsonConverterFactory gsonConverterFactory) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.dataatwork.org/v1/")
                .client(client)
                .addConverterFactory(gsonConverterFactory)
                .build();
        return retrofit.create(JobApiService.class);
    }

}
