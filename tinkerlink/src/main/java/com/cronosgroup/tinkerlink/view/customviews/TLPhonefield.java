package com.cronosgroup.tinkerlink.view.customviews;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;
import com.lamudi.phonefield.PhoneField;

/**
 * Created by jorgesanmartin on 8/24/16.
 */
public class TLPhonefield extends PhoneField {

    protected TextInputLayout mImput;

    public TLPhonefield(Context context) {
        super(context);
        init();
    }

    public TLPhonefield(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TLPhonefield(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mImput = (TextInputLayout) findViewById(R.id.phoneInput);

        findViewById(R.id.showCountries).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpinner().performClick();
            }
        });
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setDefaultCountry(LocaleUtils.getIsoCode());
        setHint(R.string.sign_select_phone_hint);
        mImput.setError(getContext().getString(R.string.error_form_phone));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.lay_phone_field;
    }
}
