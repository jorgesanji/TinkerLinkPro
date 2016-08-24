package com.cronosgroup.tinkerlink.view.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.view.BaseActivity;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.enums.Font;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.utils.ImageLoaderHelper;
import com.cronosgroup.tinkerlink.utils.Reflector;
import com.cronosgroup.tinkerlink.utils.TypeFaceUtils;
import com.cronosgroup.tinkerlink.utils.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class TinkerLinkActivity<F extends MVPTinkerLinkFragment> extends BaseActivity {

    // Vars

    private F currentFragment;

    @Inject
    protected Logger mLooger;

    // Views

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.progressBar)
    protected View mLoader;

    protected ViewGroup view;

    // Abstract methods

    public abstract boolean hasToolbar();

    public abstract ToolBarStyle getToolBarStyle();

    public abstract Class<F> getFragment();

    /**
     * Init Default methods in activity
     */

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
    public ViewGroup getView() {
        if (view == null) {
            view = (ViewGroup) getLayoutInflater().inflate(getToolBarStyle().getLayout(), null);
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

    /**
     *  Configuration toolbar from Toolbar style
     */

    protected void initToolbar() {
        if (!hasToolbar()) {
            mToolbar.setVisibility(View.GONE);
        } else {
            ToolBarStyle style = getToolBarStyle();
            configToolBar(style);
            setSupportActionBar(mToolbar);
            if (style != ToolBarStyle.HOMESTYLE) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                getSupportActionBar().setTitle(null);
            }
        }
    }

    protected void initFragment() {
        this.currentFragment = (F) Fragment.instantiate(this, getFragment().getName());
        if (currentFragment != null) {
            currentFragment.setArguments(getIntent().getExtras());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, currentFragment);
            transaction.commit();
        }
    }

    protected void configToolbar(int backgroundColor, int logo) {
        mToolbar.setBackgroundColor(getResources().getColor(backgroundColor));
        if (logo != 0) {
            mToolbar.setLogo(getResources().getDrawable(logo));
        }
    }

    protected void configToolBar(ToolBarStyle style) {
        configToolbar(style.getBackgroundColor(), style.getIcon());
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

    private View addOverLayView(View overlay) {
        if (overlay != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.overLayContent);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            overlay.setId(R.id.overlay_view);
            overlay.setLayoutParams(params);
            frameLayout.addView(overlay);

            return overlay;
        }

        return null;
    }

    /**
     *  Access to activity properties
     */

    public View addOverLayView(View view, boolean clean) {
        View overLayView = findViewById(R.id.overlay_view);
        if (overLayView != null && clean) {
            getView().removeView(overLayView);
            overLayView = addOverLayView(view);
        } else if (overLayView == null) {
            overLayView = addOverLayView(view);
        }

        return overLayView;
    }

    public void showOverLayView() {
        findViewById(R.id.overLayContent).setVisibility(View.VISIBLE);
    }

    public void hideOverLayView() {
        findViewById(R.id.overLayContent).setVisibility(View.GONE);
    }

    public void showLoading() {
        mLoader.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        mLoader.setVisibility(View.GONE);
    }

    public void setDefaultToolBarElevation(){
        ViewCompat.setTranslationZ(mToolbar, getResources().getDimension(R.dimen.view_elevation));
    }

    public void setIconAndBackButton(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setDefaultToolBarElevation();
        setTitle(R.string.app_name);
    }

    @Override
    public void setTitle(int title) {
        setTitle(getString(title));
    }

    @Override
    public void setTitle(CharSequence title) {
        SpannableString spannableTitle = null;
        if (getToolBarStyle() != ToolBarStyle.HOMESTYLE) {
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
            spannableTitle = TypeFaceUtils.getStringByFontType(this, title.toString(), Font.REGULAR);
        } else {
            spannableTitle = TypeFaceUtils.paintTextWithColor(this, title.toString(), R.color.tinkercolor, getString(R.string.app_name_truncate_to_paint), R.color.linkercolor, Font.REGULAR);
        }

        getSupportActionBar().setTitle(spannableTitle);
    }

    public void setSubtitle(CharSequence subtitle) {
        SpannableString spannableSubTitle = TypeFaceUtils.getStringByFontType(this, subtitle.toString(), Font.LIGTH);
        getSupportActionBar().setSubtitle(spannableSubTitle);
    }

    public void setSubtitle(int subtitle) {
        SpannableString spannableSubTitle = TypeFaceUtils.getStringByFontType(this, getString(subtitle), Font.LIGTH);
        getSupportActionBar().setSubtitle(spannableSubTitle);
    }

    public void setLogo(Drawable resource) {
        getSupportActionBar().setLogo(resource);
    }

    public void setLogo(int resource) {
        getSupportActionBar().setLogo(resource);
    }

    @Override
    public int getStatusColor() {
        return getResources().getColor(getToolBarStyle().getStatusColor());
    }

    /**
     * Handling permissions
     */

    @Override
    public boolean canLaunchPermission() {
        return false;
    }

    @Override
    public List<PermissionsManager.Permission> getRequestPermission() {
        return null;
    }


    /**
     * Handling navigation
     */

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        if (getCurrentFragment() != null && (getCurrentFragment()).onBackPressed()) {
            return;
        }
        AppRestManager.sharedManager().cancelAllRequestWithTag(this);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Reflector.fixInputMethodManager(this);
        AppRestManager.sharedManager().cancelAllRequestWithTag(this);
    }
}
