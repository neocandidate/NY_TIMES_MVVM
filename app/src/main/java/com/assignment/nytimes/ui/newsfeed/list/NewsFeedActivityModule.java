package com.assignment.nytimes.ui.newsfeed.list;

import com.assignment.nytimes.ui.newsfeed.list.usecase.NewsFeedLoader;
import com.assignment.nytimes.ui.newsfeed.list.viewmodel.NewsFeedViewModel;
import com.assignment.nytimes.utils.rx.scheduler.RxScheduler;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Module
public class NewsFeedActivityModule {

    @Provides
    NewsFeedViewModel provideViewModel(RxScheduler rxScheduler,
                                       NewsFeedLoader newsFeedLoader) {
        return new NewsFeedViewModel(rxScheduler, newsFeedLoader);
    }
}
