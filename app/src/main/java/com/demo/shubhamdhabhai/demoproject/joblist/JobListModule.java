package com.demo.shubhamdhabhai.demoproject.joblist;

import com.demo.shubhamdhabhai.demoproject.api.movie.JobApiService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@Module
public class JobListModule {

    private JobListContract.IJobListView view;

    public JobListModule(JobListContract.IJobListView view) {
        this.view = view;
    }

    @JobListScope
    @Provides
    public JobListContract.IJobListPresenter provideMovieListPresenter(JobApiService apiService) {
        return new JobListPresenter(view, apiService);
    }

    @JobListScope
    @Provides
    public JobListAdapter provideListAdapter() {
        return new JobListAdapter();
    }
}
