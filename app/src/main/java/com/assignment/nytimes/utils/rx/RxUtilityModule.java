package com.assignment.nytimes.utils.rx;

import com.assignment.nytimes.utils.rx.internet.RxInternet;
import com.assignment.nytimes.utils.rx.internet.RxInternetImpl;
import com.assignment.nytimes.utils.rx.scheduler.RxScheduler;
import com.assignment.nytimes.utils.rx.scheduler.RxSchedulerImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Module
public interface RxUtilityModule {
    @Binds
    RxInternet bindsRxInternet(RxInternetImpl rxInternetImpl);

    @Binds
    RxScheduler bindRxScheudle(RxSchedulerImpl rxSchedulerImpl);
}
