package com.cronosgroup.tinkerlink.view.base;

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

    // Variables

    public enum StyleToolBar {
        DEFAULTSTYLE(1, 0, R.color.white, R.string.app_name, R.color.black, R.drawable.background_loader, R.mipmap.ic_tinker),
        LINKERSTYLE(2, 0, R.color.linkercolor, 0, R.color.white, R.drawable.background_linker_loader, R.mipmap.ic_tinker),
        TINKERSTYLE(3, 0, R.color.tinkercolor, 0, R.color.white, R.drawable.background_loader, R.mipmap.ic_tinker);

        private final int style;
        private final int arrowIcon;
        private final int backgroundColor;
        private final int text;
        private final int textColor;
        private final int backgroundLoader;
        private final int icon;

        StyleToolBar(int style, int arrowIcon, int backgroundColor, int text, int textColor, int backgroundLoader, int icon) {
            this.style = style;
            this.arrowIcon = arrowIcon;
            this.backgroundColor = backgroundColor;
            this.text = text;
            this.textColor = textColor;
            this.backgroundLoader = backgroundLoader;
            this.icon = icon;
        }

        public int getIcon() {
            return icon;
        }

        public int getBackgroundColor() {
            return backgroundColor;
        }

        public int getText() {
            return text;
        }

        public int getTextColor() {
            return textColor;
        }

        public int getBackgroundLoader() {
            return backgroundLoader;
        }

        public int getStyle() {
            return style;
        }

        public int getArrowIcon() {
            return arrowIcon;
        }
    }

    private Fragment currentFragment;

    // Views

    @Inject
    Logger mLooger;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.progressBar)
    View mLoader;

    private View view;

    // Abstract methods

    public abstract boolean hasToolbar();

    public abstract StyleToolBar getActivityStyle();

    public abstract Fragment getFragment();

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
    public View getView() {
        if (view == null) {
            view = getLayoutInflater().inflate(R.layout.activity_layout_base, null);
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

            if (style.getArrowIcon() != 0) {
                getSupportActionBar().setHomeAsUpIndicator(style.getArrowIcon());
            }

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void initFragment() {
        this.currentFragment = getFragment();
        if (currentFragment != null) {
            currentFragment.setArguments(getIntent().getExtras());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, currentFragment);
            transaction.commit();
        }
    }

    protected void configToolbar(int backgroundColor, int title, int textColor, int logo) {
        mToolbar.setBackgroundColor(getResources().getColor(backgroundColor));
        if (title != 0) {
            mToolbar.setTitle(getResources().getString(title));
        }
        mToolbar.setTitleTextColor(getResources().getColor(textColor));
        if (logo != 0) {
            mToolbar.setLogo(getResources().getDrawable(logo));
        }
    }

    protected void configToolBar(StyleToolBar style) {
        configToolbar(style.getBackgroundColor(), style.getText(), style.getTextColor(), style.getIcon());
        mLoader.findViewById(R.id.backgroundColor).setBackgroundResource(style.getBackgroundLoader());
    }

    // Public methods

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
