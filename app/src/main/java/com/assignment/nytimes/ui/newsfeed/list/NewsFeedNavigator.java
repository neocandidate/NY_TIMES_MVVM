package com.assignment.nytimes.ui.newsfeed.list;

import com.assignment.nytimes.api.newsfeed.list.ResultsItem;
import com.assignment.nytimes.base.BaseNavigator;

import java.util.List;

/**
 * Created by Dhaval Parmar on 30/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public interface NewsFeedNavigator extends BaseNavigator {
    void loadNews(List<ResultsItem> results);
}
