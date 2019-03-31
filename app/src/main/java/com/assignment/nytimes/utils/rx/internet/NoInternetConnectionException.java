package com.assignment.nytimes.utils.rx.internet;

import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.assignment.nytimes.R;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NoInternetConnectionException extends Throwable {

    @VisibleForTesting
    public static final String ERROR_MESSAGE = "No internet connection";

    public NoInternetConnectionException(Context context) {
        super(context.getString(R.string.no_internet_connection));
    }

    public NoInternetConnectionException() {
        super(ERROR_MESSAGE);
    }
}
