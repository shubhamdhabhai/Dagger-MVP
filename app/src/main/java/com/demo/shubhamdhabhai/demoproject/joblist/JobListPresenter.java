package com.demo.shubhamdhabhai.demoproject.joblist;

import com.demo.shubhamdhabhai.demoproject.api.job.JobApiService;
import com.demo.shubhamdhabhai.demoproject.model.Job;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

public class JobListPresenter implements JobListContract.IJobListPresenter {

    private JobListContract.IJobListView view;

    private JobApiService apiService;

    public JobListPresenter(JobListContract.IJobListView view, JobApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void getJobList() {
        apiService.getJobList().enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                view.onGetJobListSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                view.onGetJobListFailure(t);

            }
        });
    }
}
