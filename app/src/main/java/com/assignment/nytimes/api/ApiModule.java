package com.assignment.nytimes.api;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Module
public interface ApiModule {

    @Binds
    ApiFactory bindApiFactory(ApiFactoryImpl apiFactoryImpl);
}
