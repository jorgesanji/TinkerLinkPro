package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;
import com.cronosgroup.tinkerlink.view.interfaces.IOActionButtons;
import com.cronosgroup.tinkerlink.view.interfaces.IOLoadMore;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView news feed list adapter.
 */
public class HomeAdapter extends BaseAdapter<ViewHolderPostBase, RestPost> {

    private static final int ELEMENTS_TO_REQUEST_LOAD = 15;

    private IOActionButtons actionButtons;
    private IOLoadMore loadMorePost;
    private List<String> idListRequested = new ArrayList<>();
    private boolean me;

    @Override
    public int getItemViewType(int position) {
        return UICardsHelper.getTypeView(getItems().get(position));
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent, int viewType) {
        ViewHolderPostBase holder = UICardsHelper.getViewHolder(parent, viewType, actionButtons);
        if (holder != null) {
            holder.setClickListener(getClickListener());
        }
        return holder;
    }

    @Override
    public void configItem(ViewHolderPostBase holder, int position, boolean isLastItem) {
        RestPost post = getItems().get(position);
        holder.configureItem(post);
        // Load Next Posts
        if (loadMorePost != null) {
            if ((position % ELEMENTS_TO_REQUEST_LOAD) == 0 && position > 0) {
                RestPost lastPost = getItems().get(getItems().size() - 1);
                if (lastPost.getTypePost() == RestPost.PostType.LOAD) {
                    lastPost = getItems().get(getItems().size() - 2);
                }
                String idPost = lastPost.getId();
                if (!idListRequested.contains(idPost)) {
                    idListRequested.add(idPost);
                    loadMorePost.onLoadByOffset(idPost);
                }
            }
        }
    }

    @Override
    public List<RestPost> filterBy(String query) {
        return null;
    }

    // Public methods

    public void setLoadMorePost(IOLoadMore loadMorePost) {
        this.loadMorePost = loadMorePost;
    }

    public void setActionButtons(IOActionButtons actionButtons) {
        this.actionButtons = actionButtons;
    }

    public boolean isMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public void reloadData() {
        idListRequested.clear();
        getItems().clear();
        notifyDataSetChanged();
    }
}