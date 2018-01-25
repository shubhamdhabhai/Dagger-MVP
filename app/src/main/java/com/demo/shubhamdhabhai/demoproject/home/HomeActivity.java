package com.demo.shubhamdhabhai.demoproject.home;

import android.os.Bundle;
import android.widget.EditText;

import com.demo.shubhamdhabhai.demoproject.BaseActivity;
import com.demo.shubhamdhabhai.demoproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText userNameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_search_repo)
    public void clickSearchRepo() {
        // make api call
    }
}
