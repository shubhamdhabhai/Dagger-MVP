package com.demo.shubhamdhabhai.demoproject.joblist;

import com.demo.shubhamdhabhai.demoproject.model.Job;

import java.util.List;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

public interface JobListContract {

    public interface IJobListPresenter {
        void getJobList();
    }

    public interface IJobListView {
        void onGetJobListSuccess(List<Job> jobs);
        void onGetJobListFailure(Throwable t);
    }
}
