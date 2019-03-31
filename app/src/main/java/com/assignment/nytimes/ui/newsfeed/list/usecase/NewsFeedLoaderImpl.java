package com.assignment.nytimes.ui.newsfeed.list.usecase;

import com.assignment.nytimes.api.newsfeed.list.NewsDto;
import com.assignment.nytimes.ui.newsfeed.list.usecase.remote.RemoteNewsFeedLoader;
import com.assignment.nytimes.utils.rx.internet.RxInternet;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsFeedLoaderImpl implements NewsFeedLoader {

    private RxInternet rxInternet;

    private RemoteNewsFeedLoader mRemoteNewsFeedLoader;

    @Inject
    public NewsFeedLoaderImpl(RxInternet rxInternet, RemoteNewsFeedLoader mRemoteNewsFeedLoader) {
        this.rxInternet = rxInternet;
        this.mRemoteNewsFeedLoader = mRemoteNewsFeedLoader;
    }

    @Override
    public Single<NewsDto> fetchNewsFeeds(String days, String apiKey) {
        return rxInternet
                .hasInternetConnection()
                .flatMap(isConnected -> mRemoteNewsFeedLoader.fetchNewsFeed(days, apiKey));
    }
}
