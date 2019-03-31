package com.assignment.nytimes.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.assignment.nytimes.utils.rx.scheduler.RxScheduler;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Dhaval Parmar on 29/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public abstract class BaseViewModel<N> extends ViewModel {

    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private RxScheduler rxScheduler;

    private N mNavigator;

    public BaseViewModel(RxScheduler rxScheduler) {
        this.rxScheduler = rxScheduler;
    }

    public BaseViewModel() {
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    protected N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }

    protected RxScheduler getRxScheduler() {
        return rxScheduler;
    }

    public void setRxScheduler(RxScheduler rxScheduler) {
        this.rxScheduler = rxScheduler;
    }
}
