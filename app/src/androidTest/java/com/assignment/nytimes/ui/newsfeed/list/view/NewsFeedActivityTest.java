package com.assignment.nytimes.ui.newsfeed.list.view;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.assignment.nytimes.R;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsFeedActivityTest {

    @Rule
    public ActivityTestRule<NewsFeedActivity> mActivityTestRule = new ActivityTestRule<>(NewsFeedActivity.class);
    private NewsFeedActivity mNewsFeedActivity = null;

    @Before
    public void setup() throws Exception {
        mNewsFeedActivity = mActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        mNewsFeedActivity = null;
    }

    @Test
    public void isViewPresent() {
        View view = mNewsFeedActivity.findViewById(R.id.frame_container);
        Assert.assertNotNull(view);
    }
}
