package com.cronosgroup.tinkerlink.view.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.view.BaseActivity;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.enums.StyleToolBar;
import com.cronosgroup.tinkerlink.utils.logger.Logger;
import com.cronosgroup.tinkerlink.utils.ImageLoaderHelper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class TinkerLinkActivity<F extends MVPTinkerLinkFragment> extends BaseActivity {

    // Variables

    private TinkerLinkFragment currentFragment;

    @Inject
    Logger mLooger;

    // Views

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.progressBar)
    View mLoader;

    protected View view;

    // Abstract methods

    public abstract boolean hasToolbar();

    public abstract StyleToolBar getActivityStyle();

    public abstract Class<F> getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        ButterKnife.bind(this);
        TinkerLinkApplication.getApp().getComponent().inject((TinkerLinkActivity<MVPTinkerLinkFragment>) this);
        initToolbar();
        initFragment();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (currentFragment != null) {
            currentFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public View getView() {
        if (view == null) {
            view = getLayoutInflater().inflate(getActivityStyle().getLayout(), null);
        }
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    protected void initToolbar() {
        if (!hasToolbar()) {
            mToolbar.setVisibility(View.GONE);
        } else {
            StyleToolBar style = getActivityStyle();
            configToolBar(style);
            setSupportActionBar(mToolbar);
            if (style != StyleToolBar.HOMESTYLE) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                getSupportActionBar().setTitle(null);
            }
        }
    }

    protected void initFragment() {
        this.currentFragment = (TinkerLinkFragment) Fragment.instantiate(this, getFragment().getName());
        if (currentFragment != null) {
            currentFragment.setArguments(getIntent().getExtras());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, currentFragment);
            transaction.commit();
        }
    }

    protected void configToolbar(int backgroundColor, int textColor, int logo) {
        mToolbar.setBackgroundColor(getResources().getColor(backgroundColor));
        mToolbar.setTitleTextColor(getResources().getColor(textColor));
        if (logo != 0) {
            mToolbar.setLogo(getResources().getDrawable(logo));
        }
    }

    protected void configToolBar(StyleToolBar style) {
        configToolbar(style.getBackgroundColor(), style.getTextColor(), style.getIcon());
        try {
            mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(R.drawable.background_loader);
        } catch (Exception ex) {
        }
    }

    protected void setToolBarIconFromUrl(String url, final int placeHolder) {
        mToolbar.setLogo(placeHolder);
        if (url.isEmpty()) {
            return;
        }

        ImageLoaderHelper.getImageFromUrl(60, url, new ImageLoaderHelper.IOLoadImageListener() {
            @Override
            public void onFinishLoadImage(Bitmap bitmap) {
                if (mToolbar != null) {
                    RoundedBitmapDrawable rounddrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                    rounddrawable.setCircular(true);
                    rounddrawable.setAntiAlias(true);
                    mToolbar.setLogo(rounddrawable);
                }
            }

            @Override
            public void onErrorLoadImage() {
                if (mToolbar != null) {
                    mToolbar.setLogo(placeHolder);
                }
            }
        });
    }

    protected TinkerLinkFragment getCurrentFragment() {
        return currentFragment;
    }

    // Public methods

    public void showLoading() {
        mLoader.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        mLoader.setVisibility(View.GONE);
    }

    @Override
    public int getStatusColor() {
        return getResources().getColor(getActivityStyle().getStatusColor());
    }

    @Override
    public boolean canLaunchPermission() {
        return false;
    }

    @Override
    public List<PermissionsManager.Permission> getRequestPermission() {
        return null;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void setTitle(int title) {
        if (getActivityStyle() != StyleToolBar.HOMESTYLE) {
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        getSupportActionBar().setTitle(title);
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(title);
    }

    public void setSubtitle(CharSequence subtitle) {
        getSupportActionBar().setSubtitle(subtitle);
    }

    public void setSubtitle(int subtitle) {
        getSupportActionBar().setSubtitle(subtitle);
    }

    public void setLogo(Drawable resource) {
        getSupportActionBar().setLogo(resource);
    }

    public void setLogo(int resource) {
        getSupportActionBar().setLogo(resource);
    }

    @Override
    public void onBackPressed() {
        if (getCurrentFragment() != null && getCurrentFragment().onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

}
