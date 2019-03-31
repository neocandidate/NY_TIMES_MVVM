package com.assignment.nytimes.ui.newsfeed.list.view;

import android.support.test.espresso.Espresso;

import com.assignment.nytimes.R;

import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsFeedFragmentTest {

    @Test
    public void onNewsFeedClick() {
        Espresso.onView(withId(R.id.recycler_news_feed)).perform(click());
    }
}
