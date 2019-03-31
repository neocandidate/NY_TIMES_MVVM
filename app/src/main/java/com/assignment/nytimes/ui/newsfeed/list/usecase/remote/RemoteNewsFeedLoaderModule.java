package com.assignment.nytimes.ui.newsfeed.list.usecase.remote;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Module
public interface RemoteNewsFeedLoaderModule {

    @Binds
    RemoteNewsFeedLoader bindRemotesplashScreenLoader(RemoteNewsFeedLoaderImpl remoteSplashScreenLoaderImpl);
}
