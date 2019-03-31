package com.assignment.nytimes.ui.newsfeed.details;

import com.assignment.nytimes.ui.newsfeed.details.viewmodel.NewsDetailsViewModel;
import com.assignment.nytimes.utils.rx.scheduler.RxScheduler;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Module
public class NewsDetailsModule {
    @Provides
    NewsDetailsViewModel provideViewModel(RxScheduler rxScheduler) {
        return new NewsDetailsViewModel(rxScheduler);
    }
}
