package com.demo.shubhamdhabhai.demoproject.joblist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.shubhamdhabhai.demoproject.R;
import com.demo.shubhamdhabhai.demoproject.model.Job;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shubhamdhabhai on 25/01/18.
 */

public class JobListAdapter extends RecyclerView.Adapter {

    private List<Job> jobList;

    public JobListAdapter() {
        jobList = new ArrayList<>();
    }

    public void addAll(List<Job> repoList) {
        this.jobList = repoList;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_repo_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MovieViewHolder)(holder)).bind(jobList.get(position));
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public void clear() {
        jobList.clear();
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_repo_name)
        TextView repoNameTv;

        public MovieViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(Job job) {
            repoNameTv.setText(job.getTitle());
        }
    }
}
