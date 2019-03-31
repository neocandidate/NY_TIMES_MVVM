package com.assignment.nytimes.ui.newsfeed.list.viewmodel;

import android.databinding.ObservableField;

import com.assignment.nytimes.BuildConfig;
import com.assignment.nytimes.api.newsfeed.list.NewsDto;
import com.assignment.nytimes.base.BaseViewModel;
import com.assignment.nytimes.ui.newsfeed.list.NewsFeedNavigator;
import com.assignment.nytimes.ui.newsfeed.list.usecase.NewsFeedLoader;
import com.assignment.nytimes.utils.rx.observer.SingleAwareObserver;
import com.assignment.nytimes.utils.rx.scheduler.RxScheduler;

import io.reactivex.disposables.Disposable;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsFeedViewModel extends BaseViewModel<NewsFeedNavigator> {

    private ObservableField<Boolean> isListEmpty = new ObservableField<>();
    private NewsFeedLoader mNewsFeedLoader;

    public NewsFeedViewModel() {
    }

    public NewsFeedViewModel(RxScheduler rxScheduler, NewsFeedLoader newsFeedLoader) {
        super(rxScheduler);
        this.mNewsFeedLoader = newsFeedLoader;
        isListEmpty.set(true);
    }

    public void loadNewsFeeds(int days) {
        getNavigator().showProgressDialog();
        mNewsFeedLoader.fetchNewsFeeds(String.valueOf(days), BuildConfig.NY_TIMES_API_KEY)
                .compose(getRxScheduler().forSingle())
                .subscribe(new SingleAwareObserver<NewsDto>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getCompositeDisposable().add(d);
                    }

                    @Override
                    public void onSuccess(NewsDto newsDto) {
                        getNavigator().dismissProgressDialog();
                        getNavigator().loadNews(newsDto.getResults());
                    }

                    @Override
                    public void onCommonError(Throwable e) {
                        getNavigator().dismissProgressDialog();
                        getNavigator().showErrorMessage("Unable to load feeds");
                        super.onCommonError(e);
                        e.printStackTrace();
                    }
                });
    }

    public ObservableField<Boolean> getIsListEmpty() {
        return isListEmpty;
    }
}
