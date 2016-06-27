package com.cronosgroup.tinkerlink.view.sign.fragments.validation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 10/28/15.
 */
public class ValidationScreen extends RelativeLayout {

    private static final int TOTAL_TIME_COUNT_IN_MILLISECONDS = (60 * 1000) * 3;// duration 5 minutes
    private static final int DELAYTIME_TO_RESEND = 6000;

    public interface Listener {
        void getCode();
    }

    //Variables
    private CountDownTimer mCountDownTimer;
    private Listener listener;
    private Handler mHandler = new Handler(Looper.myLooper());

    //Views
    @BindView(R.id.titleValidation)
    TLTextView titleValidation;

    @BindView(R.id.timeToReSend)
    TLTextView timeToReSend;

    @BindView(R.id.userCodeSign)
    TLEditText userCodeSign;

    /**
     * @param context
     */
    public ValidationScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public ValidationScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ValidationScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public ValidationScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_sign_validation, this);
        ButterKnife.bind(this);
    }

    private void initCountDown() {
        mCountDownTimer = new CountDownTimer(TOTAL_TIME_COUNT_IN_MILLISECONDS, 1000) {

            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(leftTimeInMilliseconds) % 60;
                long minutes = TimeUnit.MILLISECONDS.toMinutes(leftTimeInMilliseconds);
                String text = String.format(getResources().getString(R.string.sign_resend_code_time), " " + ((minutes < 10) ? "0" : "") + minutes + " : " + ((seconds < 10) ? "0" : "") + seconds);
                timeToReSend.setText(text);
            }

            @Override
            public void onFinish() {
                listener.getCode();
                timeToReSend.setTextColor(Color.RED);
                timeToReSend.setText(getResources().getString(R.string.sign_resend_code_sended));

                //TODO: Reinit countdown
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        timeToReSend.setTextColor(getResources().getColor(R.color.black_opaque));
                        initCountDown();
                    }
                }, DELAYTIME_TO_RESEND);
            }

        }.start();
    }

    // Public methods


    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void startCounter() {
        initCountDown();
    }

    public void stopCounter() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    public void setTitle(String phone) {
        String text = String.format(getResources().getString(R.string.sign_code_info), phone);
        titleValidation.setText(text);
    }

    public String getValidationCode() {
        return userCodeSign.getText().toString();
    }

    public void setCode(String code) {
        userCodeSign.setText(code);
    }

    public String getCode() {
        return userCodeSign.getText().toString();
    }
}
