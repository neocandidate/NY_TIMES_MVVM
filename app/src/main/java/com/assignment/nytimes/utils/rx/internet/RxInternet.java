package com.assignment.nytimes.utils.rx.internet;

import io.reactivex.Single;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public interface RxInternet {
    Single<Boolean> hasInternetConnection();
}
