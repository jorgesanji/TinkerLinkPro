package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.manager.AppUserSessionManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.view.interfaces.IOActionButtons;

import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 11/11/15.
 */
public abstract class ViewHolderPostBase<T extends RestPost> extends BaseViewHolder<T> {

    private IOActionButtons actionButtons;
    private T post;

    private AppConfigManager appConfigManager;
    private AppUserSessionManager appUserSessionManager;

    /**
     * @param view
     */
    public ViewHolderPostBase(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    @Override
    public void configureItem(T item) {
        super.configureItem(item);
        this.post = item;
    }

    // Public methods

    public void setActionButtons(IOActionButtons actionButtons) {
        this.actionButtons = actionButtons;
    }

    public IOActionButtons getActionButtons() {
        return actionButtons;
    }

    public boolean isMe() {
        return isMe(post.getUser().getUser());
    }

    public boolean isMe(RestUser restUser) {
        return restUser.getId().equalsIgnoreCase(appUserSessionManager.getCurrentUser().getIdUser());
    }

    public Resources getResources() {
        return itemView.getResources();
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public T getPost() {
        return post;
    }

    public void setPost(T post) {
        this.post = post;
    }

    public AppConfigManager getAppConfigManager() {
        return appConfigManager;
    }

    public AppUserSessionManager getAppUserSessionManager() {
        return appUserSessionManager;
    }

    public ViewHolderPostBase<T> setAppConfigManager(AppConfigManager appConfigManager) {
        this.appConfigManager = appConfigManager;
        return this;
    }

    public ViewHolderPostBase<T> setAppUserSessionManager(AppUserSessionManager appUserSessionManager) {
        this.appUserSessionManager = appUserSessionManager;
        return this;
    }
}
