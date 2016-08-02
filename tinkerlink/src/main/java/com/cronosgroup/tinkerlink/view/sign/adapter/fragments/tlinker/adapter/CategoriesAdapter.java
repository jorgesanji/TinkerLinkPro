package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.adapter.viewholder.CategoryViewHolder;
import com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.adapter.viewholder.SkillsViewHolder;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CategoriesAdapter extends ExpandableRecyclerAdapter<CategoryViewHolder, SkillsViewHolder> {

    public interface IOSkillListener {
        void onSkillSelected(int position);
    }

    public interface IOCategoryListener {
        void onCategorySelected(CategoryViewHolder categoryViewHolder);
    }

    // Vars
    private LayoutInflater mInflator;
    private IOSkillListener skillListener;
    private IOCategoryListener categoryListener;
    private StackCard typeTinker;

    public CategoriesAdapter(@NonNull List<? extends ParentListItem> parentItemList, Context context) {
        super(parentItemList);
        this.mInflator = LayoutInflater.from(context);
    }

    @Override
    public CategoryViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View view = mInflator.inflate(R.layout.lay_category_item, parentViewGroup, false);
        CategoryViewHolder holder = new CategoryViewHolder(view, getTypeTinker());
        holder.setListener(getCategoryListener());
        return holder;
    }

    @Override
    public SkillsViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View view = mInflator.inflate(R.layout.lay_skills_item, childViewGroup, false);
        SkillsViewHolder holder = new SkillsViewHolder(view, getTypeTinker());
        holder.setListener(getSkillListener());
        return holder;
    }

    @Override
    public void onBindParentViewHolder(CategoryViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        parentViewHolder.configureItem((RestCategoria) parentListItem);
    }

    @Override
    public void onBindChildViewHolder(SkillsViewHolder childViewHolder, int position, Object childListItem) {
        childViewHolder.configureItem((String) childListItem);
    }

    public IOSkillListener getSkillListener() {
        return skillListener;
    }

    public void setSkillListener(IOSkillListener skillListener) {
        this.skillListener = skillListener;
    }

    public IOCategoryListener getCategoryListener() {
        return categoryListener;
    }

    public void setCategoryListener(IOCategoryListener categoryListener) {
        this.categoryListener = categoryListener;
    }

    public StackCard getTypeTinker() {
        return typeTinker;
    }

    public void setTypeTinker(StackCard typeTinker) {
        this.typeTinker = typeTinker;
    }
}
