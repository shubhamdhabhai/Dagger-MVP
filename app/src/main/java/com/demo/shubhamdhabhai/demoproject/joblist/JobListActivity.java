package com.demo.shubhamdhabhai.demoproject.joblist;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.demo.shubhamdhabhai.demoproject.BaseActivity;
import com.demo.shubhamdhabhai.demoproject.BaseApplication;
import com.demo.shubhamdhabhai.demoproject.R;
import com.demo.shubhamdhabhai.demoproject.api.movie.DaggerJobApiComponent;
import com.demo.shubhamdhabhai.demoproject.api.movie.JobApiComponent;
import com.demo.shubhamdhabhai.demoproject.api.movie.JobApiModule;
import com.demo.shubhamdhabhai.demoproject.model.Job;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JobListActivity extends BaseActivity implements JobListContract.IJobListView {

    @BindView(R.id.rv_movie_list)
    RecyclerView movieListRv;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    JobListAdapter jobListAdapter;

    @Inject
    JobListContract.IJobListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        ButterKnife.bind(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        movieListRv.setLayoutManager(layoutManager);
        JobApiComponent jobApiComponent = DaggerJobApiComponent.builder()
                .appComponent(((BaseApplication) getApplication()).getAppComponent())
                .jobApiModule(new JobApiModule())
                .build();

        JobListComponent jobListComponent = DaggerJobListComponent.builder()
                .jobApiComponent(jobApiComponent)
                .jobListModule(new JobListModule(this))
                .build();
        jobListComponent.inject(this);
    }

    @OnClick(R.id.tv_movie_list)
    public void onMovieListClick() {
        progressBar.setVisibility(View.VISIBLE);
        presenter.getJobList();
    }


    @Override
    public void onGetJobListSuccess(List<Job> jobs) {
        jobListAdapter.clear();
        jobListAdapter.addAll(jobs);
        movieListRv.setAdapter(jobListAdapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onGetJobListFailure(Throwable t) {
        progressBar.setVisibility(View.GONE);
        Snackbar.make(movieListRv, R.string.failed_to_load_jobs, Snackbar.LENGTH_LONG).show();
    }
}
