package com.cronosgroup.tinkerlink.utils;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.Font;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

/**
 * Created by jorgesanmartin on 8/10/16.
 */
public class TLMMenuItem implements TLMMenuBuilder<TLMMenuItem, TLTextView> {

    public static final int SHOW_ACTION = MenuItem.SHOW_AS_ACTION_IF_ROOM;
    public static final int SHOW_ACTION_NEVER = MenuItem.SHOW_AS_ACTION_NEVER;

    private int id;
    private int icon;
    private int title;
    private int action;
    private int titleColor;

    public TLMMenuItem() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public TLMMenuItem setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public int getIcon() {
        return icon;
    }

    @Override
    public TLMMenuItem setIcon(int icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public int getTitle() {
        return title;
    }

    @Override
    public TLMMenuItem setTitle(int title) {
        this.title = title;
        return this;
    }

    @Override
    public int getAction() {
        return action;
    }

    @Override
    public TLMMenuItem setAction(int action) {
        this.action = action;
        return this;
    }

    @Override
    public int getTitleColor() {
        return titleColor;
    }

    @Override
    public TLMMenuItem setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    @Override
    public TLTextView Build(Context context) {
        int padding = DimenUtils.getIntPixelsFromDp(context, 6);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TLTextView titleView = new TLTextView(context);
        titleView.setPadding(padding, padding, padding, padding);
        titleView.setLayoutParams(params);
        titleView.setBackgroundResource(R.drawable.button_default_states);
        titleView.setGravity(Gravity.CENTER_VERTICAL);
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimensionPixelSize(R.dimen.text_size_small_16));
        titleView.setTextColor(context.getResources().getColor(getTitleColor()));
        titleView.setText(TypeFaceUtils.getStringByFontType(context, context.getString(getTitle()), Font.REGULAR));
        return titleView;
    }
}
