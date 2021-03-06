package com.cronosgroup.tinkerlink.view.sign;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLButton;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPager;
import com.cronosgroup.tinkerlink.view.customviews.TLViewPagerIndicator;
import com.cronosgroup.tinkerlink.view.sign.adapter.SignAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Sing view.
 */
public class SignScreen extends RelativeLayout {

    /**
     * listeners of the Sing's screen.
     */

    public interface Listener {
        void verifiedPage(int page);
    }

    // Vars
    private Listener listener;
    private SignAdapter mAdapter;
    private FragmentManager fragmentManager;

    // Views
    @BindView(R.id.signPager)
    TLViewPager mPager;

    @BindView(R.id.loginTitle)
    TLTextView mLoginTitle;

    @BindView(R.id.nextButton)
    TLButton mNextButton;

    @BindView(R.id.pageIndicator)
    TLViewPagerIndicator mPageIndicator;

    /**
     * @param context
     */
    public SignScreen(Context context, FragmentManager fragmentManager) {
        super(context);
        this.fragmentManager = fragmentManager;
        init();
    }

    /**
     * @param context
     */
    public SignScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public SignScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SignScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SignScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_sign, this);
        ButterKnife.bind(this);
    }


    private void setCurrentPage(int position, int titleLogin, int titleButtom) {
        mLoginTitle.setText(getResources().getString(titleLogin));
        mNextButton.setText(getResources().getString(titleButtom));
        mPageIndicator.setCurrentSelected(position);
    }

    // **************  UI Actions **************

    @OnClick(R.id.nextButton)
    protected void onNextStepPressed() {
        listener.verifiedPage(mPager.getCurrentItem());
    }

    // Public Methods

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initAdapter() {
        mAdapter = new SignAdapter(fragmentManager, getContext());
        mPager.setAdapter(mAdapter);
        mPager.setDisableSwipe(true);
        mPager.setOffscreenPageLimit(1);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case SignAdapter.FACEBOOK_PAGE:
                        setCurrentPage(position, R.string.sign_title_start, R.string.sign_next_button);
                        break;
                    case SignAdapter.PHONE_PAGE:
                        setCurrentPage(position, R.string.sign_title_validate, R.string.sign_title_send_message);
                        break;
                    case SignAdapter.VALIDATION_PAGE:
                        setCurrentPage(position, R.string.sign_title_enter_code, R.string.sign_title_send_code);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public int showNextPage() {
        mPager.setCurrentItem(mPager.getCurrentItem() + 1, true);
        return mPager.getCurrentItem();
    }

    public boolean showPreviousPage() {
        if (mPager.getCurrentItem() - 1 >= 0) {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1, true);
            return true;
        }
        return false;
    }
}