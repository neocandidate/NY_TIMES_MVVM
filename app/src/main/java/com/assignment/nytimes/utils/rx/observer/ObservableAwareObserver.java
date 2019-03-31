package com.assignment.nytimes.utils.rx.observer;

import android.support.annotation.CallSuper;

import io.reactivex.Observer;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public abstract class ObservableAwareObserver<T> implements BaseAwareObserver,
        Observer<T> {

    @CallSuper
    @Override
    public void onError(Throwable e) {
        onCommonError(e);
    }

    @Override
    public void onCommonError(Throwable e) {

    }
}
