package com.assignment.nytimes.ui.newsfeed.details.viewmodel;

import android.annotation.SuppressLint;

import com.assignment.nytimes.base.BaseViewModel;
import com.assignment.nytimes.ui.newsfeed.details.DetailsNavigator;
import com.assignment.nytimes.utils.rx.scheduler.RxScheduler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsDetailsViewModel extends BaseViewModel<DetailsNavigator> {

    RxScheduler mRxScheduler;
    private String mDate = "";
    private String mTitle = "";
    private String mContents = "";
    private String author = "";

    public NewsDetailsViewModel() {
    }

    public NewsDetailsViewModel(RxScheduler rxScheduler) {
        super(rxScheduler);
    }

    @SuppressLint("CheckResult")
    public void loadNewsDetails(String url) {
        getNavigator().showProgressDialog();
        List<String> content = new ArrayList<>();
        Observable.fromCallable(() -> {
            Document document = Jsoup.connect(url).get();
            content.add(document.select("p").text());
            return false;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    getNavigator().dismissProgressDialog();
                    getNavigator().loadDetails(content.get(0));
                }, error -> {
                    getNavigator().dismissProgressDialog();
                    getNavigator().showErrorMessage("Unable to load article");
                });
    }
}
