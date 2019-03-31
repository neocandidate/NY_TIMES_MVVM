package com.assignment.nytimes.api;

import android.content.Context;

import com.assignment.nytimes.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class ApiFactoryImpl implements ApiFactory {

    private Context context;

    @Inject
    ApiFactoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public <T> Single<T> create(Class<T> apiClass) {
        return retrofit()
                .map(retrofit -> retrofit.create(apiClass));
    }

    @Override
    public Single<Retrofit> retrofit() {
        return client().flatMap(this::intoRetrofit);
    }

    private Single<OkHttpClient> client() {
        return Single
                .fromCallable(() -> new OkHttpClient.Builder()
                        .connectTimeout(5, TimeUnit.MINUTES)
                        .readTimeout(5, TimeUnit.MINUTES))
                .flatMap(this::addLoggingInterceptor)
                .map(OkHttpClient.Builder::build);
    }

    private Single<OkHttpClient.Builder> addLoggingInterceptor(OkHttpClient.Builder builder) {
        return Single.fromCallable(
                () -> {
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    builder.addInterceptor(loggingInterceptor);

                    return builder;
                });
    }

    private Single<Retrofit> intoRetrofit(OkHttpClient client) {
        return Single.fromCallable(
                () -> new Retrofit.Builder()
                        .baseUrl(BuildConfig.BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
        );
    }
}
