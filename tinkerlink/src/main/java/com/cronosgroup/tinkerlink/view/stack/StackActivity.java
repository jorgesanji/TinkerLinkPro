package com.cronosgroup.tinkerlink.view.stack;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.enums.ToolBarStyle;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class StackActivity extends TinkerLinkActivity<StackFragment> {

    public static final String STACK_TYPE = "STACK";

    @Override
    public Class<StackFragment> getFragment() {
        return StackFragment.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StackCardType stackType = (StackCardType) getIntent().getExtras().getSerializable(StackActivity.STACK_TYPE);
        if (stackType != null) {
            setTitle(getString(stackType.getStackTitle()));
        }
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public ToolBarStyle getActivityStyle() {
        return ToolBarStyle.DEFAULTSTYLE;
    }

}
