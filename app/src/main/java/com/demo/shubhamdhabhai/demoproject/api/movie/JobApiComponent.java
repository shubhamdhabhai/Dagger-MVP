package com.demo.shubhamdhabhai.demoproject.api.movie;

import com.demo.shubhamdhabhai.demoproject.AppComponent;

import dagger.Component;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@JobApiScope
@Component(dependencies = {AppComponent.class}, modules = {JobApiModule.class})
public interface JobApiComponent {
    JobApiService getMovieApiService();
}
