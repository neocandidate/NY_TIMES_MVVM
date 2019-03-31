package com.assignment.nytimes.di;

import com.assignment.nytimes.ui.newsfeed.details.NewsDetailsModule;
import com.assignment.nytimes.ui.newsfeed.details.view.NewsDetailsFragment;
import com.assignment.nytimes.ui.newsfeed.list.NewsFeedActivityModule;
import com.assignment.nytimes.ui.newsfeed.list.usecase.NewsFeedLoaderUsecaseModule;
import com.assignment.nytimes.ui.newsfeed.list.view.NewsFeedActivity;
import com.assignment.nytimes.ui.newsfeed.list.view.NewsFeedFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            NewsFeedActivityModule.class,
            NewsFeedLoaderUsecaseModule.class
    })
    abstract NewsFeedActivity bindNewsFeedActivity();

    @ContributesAndroidInjector(modules = {
            NewsFeedActivityModule.class,
            NewsFeedLoaderUsecaseModule.class
    })
    abstract NewsFeedFragment bindNewsFeedFragment();

    @ContributesAndroidInjector(modules = {
            NewsDetailsModule.class
    })
    abstract NewsDetailsFragment bindNewsDetailFragment();
}
