package com.assignment.nytimes.utils.rx.internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

import io.reactivex.Single;

import static android.net.NetworkInfo.State.CONNECTED;
import static android.net.NetworkInfo.State.CONNECTING;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class RxInternetImpl implements RxInternet {

    private ConnectivityManager connectivityManager;

    private Context context;

    @Inject
    RxInternetImpl(Context context, ConnectivityManager connectivityManager) {
        this.context = context;
        this.connectivityManager = connectivityManager;
    }

    @Override
    public Single<Boolean> hasInternetConnection() {
        return Single.defer(() -> {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            boolean hasConnection =
                    null != networkInfo
                            && (networkInfo.getState() == CONNECTED
                            || networkInfo.getState() == CONNECTING);

            if (hasConnection) return Single.just(hasConnection);
            return Single.error(new NoInternetConnectionException());
        });
    }
}
