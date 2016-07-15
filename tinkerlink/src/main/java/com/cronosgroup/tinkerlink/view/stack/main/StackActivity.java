package com.cronosgroup.tinkerlink.view.stack.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TinkerLinkActivity;

public class StackActivity extends TinkerLinkActivity {

    public static final String STACK_TYPE = "STACK";

    public enum Stack {
        LINKER(1, R.color.linkercolor, R.string.watch_linkers, R.string.stack_watch_linker),
        TINKER(2, R.color.tinkercolor, R.string.watch_tinkers, R.string.stack_watch_tinker);

        private final int stackType;
        private final int stackColor;
        private final int stackTitle;
        private final int stackTitleAction;

        private Stack(int stackType, int stackColor, int stackTitle, int stackTitleAction) {
            this.stackType = stackType;
            this.stackColor = stackColor;
            this.stackTitle = stackTitle;
            this.stackTitleAction = stackTitleAction;
        }

        public int getStackType() {
            return stackType;
        }

        public int getStackColor() {
            return stackColor;
        }

        public int getStackTitle() {
            return stackTitle;
        }

        public int getStackTitleAction() {
            return stackTitleAction;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean hasToolbar() {
        return true;
    }

    @Override
    public StyleToolBar getActivityStyle() {
        return StyleToolBar.DEFAULTSTYLE;
    }

    @Override
    public Fragment getFragment() {
        return new StackFragment();
    }
}
