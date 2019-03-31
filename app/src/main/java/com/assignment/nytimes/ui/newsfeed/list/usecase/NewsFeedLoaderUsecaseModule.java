package com.assignment.nytimes.ui.newsfeed.list.usecase;

import com.assignment.nytimes.ui.newsfeed.list.usecase.remote.RemoteNewsFeedLoaderModule;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Module(includes = RemoteNewsFeedLoaderModule.class)
public interface NewsFeedLoaderUsecaseModule {

    @Binds
    NewsFeedLoader bindNewsFeedLoader(NewsFeedLoaderImpl newsFeedLoaderimpl);
}
