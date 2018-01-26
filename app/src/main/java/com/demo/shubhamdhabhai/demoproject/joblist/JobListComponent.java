package com.demo.shubhamdhabhai.demoproject.joblist;

import com.demo.shubhamdhabhai.demoproject.api.movie.JobApiComponent;

import dagger.Component;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

@JobListScope
@Component(dependencies = {JobApiComponent.class}, modules = {JobListModule.class})
public interface JobListComponent {
    void inject(JobListActivity jobListActivity);
}
