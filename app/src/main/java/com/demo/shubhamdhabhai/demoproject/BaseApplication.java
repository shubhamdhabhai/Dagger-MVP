package com.demo.shubhamdhabhai.demoproject;

import android.app.Application;

/**
 * Created by shubhamdhabhai on 25/01/18.
 */

public class BaseApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
        //appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
