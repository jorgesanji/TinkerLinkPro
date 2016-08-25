package com.cronosgroup.tinkerlink.view.sign.userformregistration.adapter.fragments.tlinker.adapter.viewholder;

import android.view.View;
import android.widget.CheckBox;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.view.sign.userformregistration.adapter.fragments.tlinker.adapter.CategoriesAdapter;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class SkillsViewHolder extends ChildViewHolder {

    // Vars
    private CategoriesAdapter.IOSkillListener listener;
    private StackCardType type;

    // Views
    @BindView(R.id.titleSkill)
    protected TLTextView mTitle;

    @BindView(R.id.skillSelector)
    protected CheckBox mSkillSelector;

    public SkillsViewHolder(View itemView, StackCardType type) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.type = type;
    }

    public void configureItem(String name) {
        mTitle.setText(name);
    }

    @OnClick(R.id.categorySelected)
    protected void selectorSkillPressed() {
        if (listener != null) {
            listener.onSkillSelected(getAdapterPosition());
        }
    }

    @OnClick(R.id.titleSkill)
    protected void titlePressed() {
        mSkillSelector.setChecked(!mSkillSelector.isChecked());
        if (listener != null) {
            listener.onSkillSelected(getAdapterPosition());
        }
    }

    public CategoriesAdapter.IOSkillListener getListener() {
        return listener;
    }

    public void setListener(CategoriesAdapter.IOSkillListener listener) {
        this.listener = listener;
    }
}