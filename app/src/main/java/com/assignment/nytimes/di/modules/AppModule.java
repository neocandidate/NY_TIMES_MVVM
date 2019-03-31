package com.assignment.nytimes.di.modules;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import com.assignment.nytimes.NyTimesApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Application provideApplication(NyTimesApp nyTimesApp) {
        return nyTimesApp;
    }

    @Provides
    @Singleton
    Context provideContext(NyTimesApp nyTimesApp) {
        return nyTimesApp.getApplicationContext();
    }

    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
