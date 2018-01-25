package com.demo.shubhamdhabhai.demoproject.repolist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.shubhamdhabhai.demoproject.R;
import com.demo.shubhamdhabhai.demoproject.model.Repo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shubhamdhabhai on 25/01/18.
 */

public class RepoAdapter extends RecyclerView.Adapter {

    private List<Repo> repoList;

    public RepoAdapter() {
        repoList = new ArrayList<>();
    }

    public void addAll(List<Repo> repoList) {
        this.repoList = repoList;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_repo_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RepoViewHolder)(holder)).bind(repoList.get(position));
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_repo_name)
        TextView repoNameTv;

        public RepoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(Repo repo) {
            repoNameTv.setText(repo.getName());
        }
    }
}
