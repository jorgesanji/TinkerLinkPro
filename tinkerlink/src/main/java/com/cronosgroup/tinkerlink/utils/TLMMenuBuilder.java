package com.cronosgroup.tinkerlink.utils;

import android.content.Context;
import android.view.View;

/**
 * Created by jorgesanmartin on 8/10/16.
 */
public interface TLMMenuBuilder<M extends TLMMenuItem, V extends View> {

    int getId();

    M setId(int id);

    int getIcon();

    M setIcon(int icon);

    int getTitle();

    M setTitle(int title);

    int getAction();

    M setAction(int action);

    int getTitleColor();

    M setTitleColor(int titleColor);

    V Build(Context context);
}
