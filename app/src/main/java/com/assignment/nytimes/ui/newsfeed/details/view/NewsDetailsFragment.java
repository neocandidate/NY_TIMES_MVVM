package com.assignment.nytimes.ui.newsfeed.details.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.assignment.nytimes.BR;
import com.assignment.nytimes.R;
import com.assignment.nytimes.base.BaseFragment;
import com.assignment.nytimes.databinding.FragmentNewsDetailsBinding;
import com.assignment.nytimes.ui.newsfeed.details.DetailsNavigator;
import com.assignment.nytimes.ui.newsfeed.details.viewmodel.NewsDetailsViewModel;

import javax.inject.Inject;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsDetailsFragment extends BaseFragment<FragmentNewsDetailsBinding, NewsDetailsViewModel>
        implements DetailsNavigator {

    @Inject
    NewsDetailsViewModel newsDetailsViewModel;

    @Override
    public int getBindingVariable() {
        return BR.details;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_details;
    }

    @Override
    public NewsDetailsViewModel getViewModel() {
        return newsDetailsViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsDetailsViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String date = getArguments().getString("DATE", "");
        String title = getArguments().getString("TITLE", "");
        String author = getArguments().getString("AUTHOR", "");
        String url = getArguments().getString("URL", "");

        mViewDataBinding.textNewsAuthor.setText(author);
        mViewDataBinding.textNewsTitle.setText(title);
        mViewDataBinding.textNewsDate.setText(date);

        mViewModel.loadNewsDetails(url);

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

    @Override
    public void loadDetails(String content) {
        mViewDataBinding.textNewsContent.setText(content);
    }
}
