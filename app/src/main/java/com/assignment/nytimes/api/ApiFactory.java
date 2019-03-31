package com.assignment.nytimes.api;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public interface ApiFactory {

    /**
     * This will be used for API request that are not requiring an authentication token on header.
     * <p>
     * e.g. Login Request, Forgot Password, etc.
     */
    <T> Single<T> create(Class<T> apiClass);

    /**
     * Expose instance of {@link Retrofit} whenever other module is in need of it.
     */
    Single<Retrofit> retrofit();
}
