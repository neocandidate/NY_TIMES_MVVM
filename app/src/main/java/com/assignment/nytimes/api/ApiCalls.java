package com.assignment.nytimes.api;

import com.assignment.nytimes.api.newsfeed.list.NewsDto;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public interface ApiCalls {

    @GET("/svc/mostpopular/v2/viewed/{days}.json")
    Single<Response<NewsDto>> loadNews(@Path("days") String days,
                                       @Query("api-key") String apiKey);
}
