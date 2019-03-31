package com.assignment.nytimes;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.assignment.nytimes.base.BaseActivity;
import com.assignment.nytimes.di.components.AppComponent;
import com.assignment.nytimes.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Dhaval Parmar on 29/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NyTimesApp extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private BaseActivity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent().inject(this);
    }

    AppComponent initializeComponent() {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build();
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public BaseActivity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(BaseActivity currentActivity) {
        this.currentActivity = currentActivity;
    }
}
