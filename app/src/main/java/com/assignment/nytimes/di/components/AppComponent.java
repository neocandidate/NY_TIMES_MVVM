package com.assignment.nytimes.di.components;

import com.assignment.nytimes.NyTimesApp;
import com.assignment.nytimes.api.ApiModule;
import com.assignment.nytimes.di.ActivityBuilder;
import com.assignment.nytimes.di.modules.AppModule;
import com.assignment.nytimes.utils.rx.RxUtilityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApiModule.class,
        ActivityBuilder.class,
        AppModule.class,
        RxUtilityModule.class
})
public interface AppComponent {

    void inject(NyTimesApp app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(NyTimesApp nyTimesApp);

        AppComponent build();
    }
}
