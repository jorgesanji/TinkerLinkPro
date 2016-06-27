package com.cronosgroup.tinkerlink.view.base;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.view.BaseActivity;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class TinkerLinkActivity extends BaseActivity {

    public enum StyleToolBar {
        WHITESTYLE(1),
        LINKERSTYLE(2),
        TINKERSTYLE(3),
        CLEARSTYLE(4),
        LINKERCARDSTYLE(5),
        TINKERCARDSTYLE(6),
        HOMESTYLE(7);

        private int style;

        private StyleToolBar(int style) {
            this.style = style;
        }

        public int getStyle() {
            return style;
        }
    }

    @Inject
    Logger mLooger;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.progressBar)
    View mLoader;

    private View view;

    private Fragment currentFragment;

    public abstract boolean hasToolbar();

    public abstract StyleToolBar getActivityStyle();

    public abstract int getActivityIconBack();

    public abstract Fragment getFragment();

    @Override
    public View getView() {
        if (view == null) {
            view = getLayoutInflater().inflate(R.layout.activity_layout_base, null);
        }
        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        ButterKnife.bind(this);
        TinkerLinkApplication.getApp().getComponent().inject(this);
        initToolbar();
        initFragment();
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

    private void initToolbar() {

        if (!hasToolbar()) {
            mToolbar.setVisibility(View.GONE);
        } else {
            if (mToolbar != null) {
                if (getActivityStyle() == StyleToolBar.LINKERSTYLE) {
                    configLinkerDefaultMode();
                } else if (getActivityStyle() == StyleToolBar.WHITESTYLE) {
                    configToolBarWhiteMode();
                } else if (getActivityStyle() == StyleToolBar.CLEARSTYLE) {
                    configClearMode();
                } else if (getActivityStyle() == StyleToolBar.LINKERCARDSTYLE) {
                    configLinkerCardMode();
                } else if (getActivityStyle() == StyleToolBar.TINKERCARDSTYLE) {
                    configTinkerCardMode();
                } else if (getActivityStyle() == StyleToolBar.HOMESTYLE) {
                    configHomeStyle();
                } else {
                    configTinkerDefaultMode();
                }

                setSupportActionBar(mToolbar);
                if (getActivityIconBack() != 0) {
                    getSupportActionBar().setHomeAsUpIndicator(getActivityIconBack());
                }
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setIcon(getResources().getDrawable(R.mipmap.ic_tinker));
                getSupportActionBar().setTitle(getString(R.string.app_name));
            }
        }
    }

    private void initFragment() {
        this.currentFragment = getFragment();
        if (currentFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, currentFragment);
            transaction.commit();
        }
    }

    private void configToolbar(int backgroundColor, String title, int textColor, Drawable logo) {
        mToolbar.setBackgroundColor(backgroundColor);
        mToolbar.setTitle(title);
        mToolbar.setTitleTextColor(textColor);
        mToolbar.setLogo(logo);
    }

    protected void configToolBarWhiteMode() {
        configToolbar(getResources().getColor(R.color.white), "", getResources().getColor(R.color.black), null);
        mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(R.drawable.background_tinker_loader);
    }

    protected void configLinkerDefaultMode() {
        configToolbar(getResources().getColor(R.color.linkercolor), "", getResources().getColor(R.color.white), getResources().getDrawable(R.mipmap.ic_ti_02));
        mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(R.drawable.background_linker_loader);
    }

    protected void configTinkerDefaultMode() {
        configToolbar(getResources().getColor(R.color.tinkercolor), "", getResources().getColor(R.color.white), getResources().getDrawable(R.mipmap.ic_ti_02));
        mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(R.drawable.background_tinker_loader);
    }

    protected void configClearMode() {
        configToolbar(getResources().getColor(android.R.color.transparent), "", getResources().getColor(R.color.black), null);
        mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(R.drawable.background_tinker_loader);
    }

    protected void configLinkerCardMode() {
        configToolbar(getResources().getColor(R.color.linkercolor), "", getResources().getColor(R.color.white), getResources().getDrawable(R.mipmap.ic_ti_02));
        mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(R.drawable.background_tinker_loader);
    }

    protected void configTinkerCardMode() {
        configToolbar(getResources().getColor(R.color.tinkercolor), "", getResources().getColor(R.color.white), getResources().getDrawable(R.mipmap.ic_ti_02));
        mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(R.drawable.background_tinker_loader);
    }

    protected void configHomeStyle() {
        configToolbar(getResources().getColor(R.color.tinkercolor), "", getResources().getColor(R.color.white), getResources().getDrawable(R.mipmap.ic_ti_02));
        mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(R.drawable.background_tinker_loader);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    public void showLoading() {
        mLoader.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        mLoader.setVisibility(View.GONE);
    }

    @Override
    public int getStatusColor() {
        return getResources().getColor(R.color.tinkercolor);
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
}
