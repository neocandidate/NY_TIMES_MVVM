package com.assignment.nytimes.ui.newsfeed.list.usecase;

import com.assignment.nytimes.api.newsfeed.list.NewsDto;

import io.reactivex.Single;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public interface NewsFeedLoader {
    Single<NewsDto> fetchNewsFeeds(String days, String apiKey);
}
