package com.demo.shubhamdhabhai.demoproject.api.job;

import com.demo.shubhamdhabhai.demoproject.model.Job;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shubhamdhabhai on 26/01/18.
 */

public interface JobApiService {

    @GET("jobs")
    Call<List<Job>> getJobList();
}
