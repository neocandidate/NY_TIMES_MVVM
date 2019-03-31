package com.assignment.nytimes.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.assignment.nytimes.NyTimesApp;
import com.assignment.nytimes.utils.common.CommonUtils;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Dhaval Parmar on 29/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel>
        extends AppCompatActivity implements HasSupportFragmentInjector {

    protected V mViewModel;
    protected NyTimesApp nyTimesApp;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    private T mViewDataBinding;
    private ProgressDialog mProgressDialog;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    @LayoutRes
    public abstract int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performDataBinding();
        nyTimesApp = (NyTimesApp) this.getApplicationContext();
    }

    @Override
    protected void onResume() {
        super.onResume();
        nyTimesApp.setCurrentActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        clearReferences();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearReferences();
    }

    public void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    public void showLoading() {
        if (!isFinishing()) {
            hideLoading();
            mProgressDialog = CommonUtils.showLoadingDialog(this);
        }
    }

    public void hideLoading() {
        if (!isFinishing() && mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    public void loadFragment(Fragment mFragment,
                             int container,
                             int transactionType,
                             boolean isAddToBackStack) {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (transactionType) {
            case 0:
                mFragmentTransaction.add(container, mFragment, mFragment.getClass().getName());
                if (isAddToBackStack)
                    mFragmentTransaction.addToBackStack(mFragment.getClass().getName());
                break;
            case 1:
                mFragmentTransaction.replace(container, mFragment, mFragment.getClass().getName());
                if (isAddToBackStack)
                    mFragmentTransaction.addToBackStack(mFragment.getClass().getName());
                break;
            case 2:
                mFragmentTransaction.remove(mFragment);
                getSupportFragmentManager().popBackStack();
                break;
        }
        mFragmentTransaction.commit();
    }

    private void clearReferences() {
        Activity currActivity = nyTimesApp.getCurrentActivity();
        if (this.equals(currActivity))
            nyTimesApp.setCurrentActivity(null);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
