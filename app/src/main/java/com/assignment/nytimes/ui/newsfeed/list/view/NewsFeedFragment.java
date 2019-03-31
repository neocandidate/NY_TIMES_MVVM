package com.assignment.nytimes.ui.newsfeed.list.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;
import android.widget.Toast;

import com.assignment.nytimes.BR;
import com.assignment.nytimes.R;
import com.assignment.nytimes.api.newsfeed.list.ResultsItem;
import com.assignment.nytimes.base.BaseFragment;
import com.assignment.nytimes.databinding.FragmentNewsFeedBinding;
import com.assignment.nytimes.ui.newsfeed.details.view.NewsDetailsFragment;
import com.assignment.nytimes.ui.newsfeed.list.NewsFeedNavigator;
import com.assignment.nytimes.ui.newsfeed.list.viewmodel.NewsFeedViewModel;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsFeedFragment extends BaseFragment<FragmentNewsFeedBinding, NewsFeedViewModel>
        implements NewsFeedNavigator {

    @Inject
    NewsFeedViewModel newsFeedViewModel;

    private int NEWS_LOAD_DAYS = 7;

    @Override
    public int getBindingVariable() {
        return BR.feeds;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_feed;
    }

    @Override
    public NewsFeedViewModel getViewModel() {
        return newsFeedViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.loadNewsFeeds(NEWS_LOAD_DAYS);
    }

    @Override
    public void loadNews(List<ResultsItem> results) {
        mViewDataBinding.recyclerNewsFeed.setAdapter(new NewsFeedAdapter(results, position -> {
            NewsDetailsFragment mFragment = new NewsDetailsFragment();
            Bundle mBundle = new Bundle();
            mBundle.putString("TITLE", results.get(position).getTitle());
            mBundle.putString("AUTHOR", results.get(position).getByline());
            mBundle.putString("DATE", results.get(position).getPublishedDate());
            mBundle.putString("URL", results.get(position).getUrl());
            mFragment.setArguments(mBundle);

            getBaseActivity().loadFragment(mFragment,
                    R.id.frame_container,
                    0,
                    true);
        }));
        mViewDataBinding.recyclerNewsFeed.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()),
                DividerItemDecoration.VERTICAL));
    }

    @Override
    public void showProgressDialog() {
        getBaseActivity().showLoading();
    }

    @Override
    public void dismissProgressDialog() {
        getBaseActivity().hideLoading();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDismiss() {

    }
}
