package com.assignment.nytimes.base;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public interface BaseNavigator {

    void showProgressDialog();

    void dismissProgressDialog();

    void showErrorMessage(String errorMessage);

    void onDismiss();
}
