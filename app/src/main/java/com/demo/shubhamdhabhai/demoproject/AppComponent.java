package com.demo.shubhamdhabhai.demoproject;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    OkHttpClient getOkHttpClient();
    GsonConverterFactory getGsonConvertorFactory();
}
