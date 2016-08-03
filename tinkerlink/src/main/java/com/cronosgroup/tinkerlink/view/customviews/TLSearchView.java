package com.cronosgroup.tinkerlink.view.customviews;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;
import android.widget.EditText;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 8/3/16.
 */
public class TLSearchView extends SearchView {

    public TLSearchView(Context context) {
        this(context, null);
    }

    public TLSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        int id = getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText edit = (EditText) findViewById(id);
        if (edit != null) {
            edit.setHintTextColor(getResources().getColor(R.color.black_opaque));
            edit.setTextColor(getContext().getResources().getColor(R.color.tinkercolor));
        }
    }

    public void takeFocus() {
        setFocusable(true);
        setIconified(false);
        requestFocus();
        requestFocusFromTouch();
    }

}
