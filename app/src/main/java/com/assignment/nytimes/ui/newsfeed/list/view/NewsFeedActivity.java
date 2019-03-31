package com.assignment.nytimes.ui.newsfeed.list.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.assignment.nytimes.BR;
import com.assignment.nytimes.R;
import com.assignment.nytimes.base.BaseActivity;
import com.assignment.nytimes.databinding.ActivityNewsFeedBinding;
import com.assignment.nytimes.ui.newsfeed.list.viewmodel.NewsFeedViewModel;

import java.util.Objects;

import javax.inject.Inject;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsFeedActivity extends BaseActivity<ActivityNewsFeedBinding, NewsFeedViewModel> {

    @Inject
    NewsFeedViewModel newsFeedViewModel;
    private ActivityNewsFeedBinding mNewsFeedingDatabinding;

    public ActionBar mActionbar;

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

        setSupportActionBar(mNewsFeedingDatabinding.toolbar);
        mActionbar = Objects.requireNonNull(getSupportActionBar());

        mActionbar.setDisplayHomeAsUpEnabled(false);
        mActionbar.setDisplayShowTitleEnabled(false);
        mActionbar.setDisplayShowCustomEnabled(true);
        mActionbar.setCustomView(LayoutInflater.from(this).inflate(R.layout.cutome_actionbar, null));

        TextView toolbarTitle = mActionbar.getCustomView().findViewById(R.id.toolbar_title);
        toolbarTitle.setText(getString(R.string.app_name));

        loadFragment(new NewsFeedFragment(),
                R.id.frame_container,
                0,
                false);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();

    }
}
