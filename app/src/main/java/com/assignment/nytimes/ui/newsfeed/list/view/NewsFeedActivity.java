package com.assignment.nytimes.ui.newsfeed.list.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.assignment.nytimes.BR;
import com.assignment.nytimes.R;
import com.assignment.nytimes.base.BaseActivity;
import com.assignment.nytimes.databinding.ActivityNewsFeedBinding;
import com.assignment.nytimes.ui.newsfeed.list.viewmodel.NewsFeedViewModel;

import javax.inject.Inject;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsFeedActivity extends BaseActivity<ActivityNewsFeedBinding, NewsFeedViewModel> {

    @Inject
    NewsFeedViewModel newsFeedViewModel;
    private ActivityNewsFeedBinding mNewsFeedingDatabinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_feed;
    }

    @Override
    public NewsFeedViewModel getViewModel() {
        return newsFeedViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNewsFeedingDatabinding = getViewDataBinding();

        loadFragment(new NewsFeedFragment(),
                R.id.frame_container,
                0,
                false);

    }
}
