package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 30/5/16.
 */
public class TLActionButton extends RelativeLayout {

    private static final String TAG = TLActionButton.class.getName();

    @BindView(R.id.ic_action)
    TLImageView ic_action;

    @BindView(R.id.badge_action)
    View badge_action;

    @BindView(R.id.title_action)
    TLTextView title_action;

    public TLActionButton(Context context) {
        this(context, null);
    }

    public TLActionButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLActionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.lay_action_menu_button, this);
        ButterKnife.bind(this);
        if (attrs != null) {
            TypedArray attributes = null;
            try {
//                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLImageView);
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }

    }


}
