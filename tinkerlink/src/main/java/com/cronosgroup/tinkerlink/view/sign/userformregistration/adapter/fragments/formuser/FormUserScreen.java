package com.cronosgroup.tinkerlink.view.sign.userformregistration.adapter.fragments.formuser;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class FormUserScreen extends TLBaseView {

    public interface Listener {
        void onSelectCountry();
    }

    //Vars
    private Listener listener;

    //Views

    /**
     * @param context
     */
    public FormUserScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public FormUserScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public FormUserScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FormUserScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_form_user;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Actions

    @OnClick(R.id.selectorCountry)
    protected void selectorPressed() {
        listener.onSelectCountry();
    }

    // Public method

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}

