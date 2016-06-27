package com.cronosgroup.tinkerlink.view.dialog.category.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.view.dialog.category.adapter.viewholder.ViewHolderCategory;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends BaseAdapter<ViewHolderCategory, RestCategoria> {

    private boolean isLinkerCard;

    public CategoryAdapter(List<RestCategoria> categorias, boolean isLinkerCard) {
        super(categorias, true);
        this.isLinkerCard = isLinkerCard;
    }

    @Override
    public ViewHolderCategory getHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewRow = inflater.inflate(R.layout.lay_item_dialog, parent, false);
        ViewHolderCategory viewHolder = new ViewHolderCategory(viewRow);
        viewHolder.setClickListener(getClickListener());
        return viewHolder;
    }

    @Override
    public void configItem(ViewHolderCategory holder, int position, boolean isLastItem) {
        holder.configItem(getItems().get(position).getProfesion(), isLinkerCard);
    }

    @Override
    public List<RestCategoria> filterBy(String query) {
        List<RestCategoria> categoriesList = new ArrayList<RestCategoria>();
        if (query.length() == 0) {
            getItems().clear();
            categoriesList = getAllItems();
        } else {
            for (RestCategoria categoria : getAllItems()) {
                if (categoria.getProfesion().toLowerCase().contains(query.toLowerCase())) {
                    categoriesList.add(categoria);
                }
            }
        }

        return categoriesList;
    }
}
