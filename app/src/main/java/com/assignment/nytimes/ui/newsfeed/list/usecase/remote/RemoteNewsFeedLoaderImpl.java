package com.assignment.nytimes.ui.newsfeed.list.usecase.remote;

import com.assignment.nytimes.api.ApiCalls;
import com.assignment.nytimes.api.ApiFactory;
import com.assignment.nytimes.api.newsfeed.list.NewsDto;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class RemoteNewsFeedLoaderImpl implements RemoteNewsFeedLoader {

    private ApiFactory apiFactory;

    @Inject
    public RemoteNewsFeedLoaderImpl(ApiFactory apiFactory) {
        this.apiFactory = apiFactory;
    }

    @Override
    public Single<NewsDto> fetchNewsFeed(String days, String apiKey) {
        return apiFactory.create(ApiCalls.class)
                .flatMap(apiCalls -> apiCalls.loadNews(days, apiKey))
                .flatMap(this::fetchNewsFeedResponse);
    }

    private Single<NewsDto> fetchNewsFeedResponse(Response<NewsDto> response) {
        return Single.just(response.body());
    }
}
