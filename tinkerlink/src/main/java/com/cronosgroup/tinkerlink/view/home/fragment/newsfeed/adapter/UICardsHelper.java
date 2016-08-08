package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderAddContact;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderLinker;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderLoader;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderRecommendation;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderShareLinker;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderShareProfile;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderShareRecommendation;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderShareStatus;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderShareTinker;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderShareUpdatePhoto;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderShareUpdateProfile;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderStatus;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderSuggestions;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderTinker;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderUpdatePhoto;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.ViewHolderUpdateProfile;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.viewholder.base.ViewHolderPostBase;
import com.cronosgroup.tinkerlink.interfaces.IOActionButtons;

/**
 * Created by jorgesanmartin on 11/11/15.
 */
public class UICardsHelper {

    public static int getTypeView(RestPost post) {
        return post.getTypePost().getType();
    }

    public static ViewHolderPostBase getViewHolder(ViewGroup parent, int viewType, IOActionButtons listener) {

        ViewHolderPostBase viewHolder = null;
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        RestPost.PostType postType = RestPost.PostType.typeFromInt(viewType);

        switch (postType) {
            case SUGGESTION:
                view = inflater.inflate(R.layout.lay_suggestions, parent, false);
                viewHolder = new ViewHolderSuggestions(view);
                break;
            case RECOMMENDATION:
                view = inflater.inflate(R.layout.lay_post_recommendation, parent, false);
                viewHolder = new ViewHolderRecommendation(view);
                break;
            case SHAREPROFILE:
                view = inflater.inflate(R.layout.lay_new_post_card, parent, false);
                viewHolder = new ViewHolderShareProfile(view);
                break;
            case ADDCONTACT:
                view = inflater.inflate(R.layout.lay_new_post_card, parent, false);
                viewHolder = new ViewHolderAddContact(view);
                break;
            case UPDATEPROFILE:
                view = inflater.inflate(R.layout.lay_post_update_profile, parent, false);
                viewHolder = new ViewHolderUpdateProfile(view);
                break;
            case UPDATEPHOTO:
                view = inflater.inflate(R.layout.lay_post_update_profile_image, parent, false);
                viewHolder = new ViewHolderUpdatePhoto(view);
                break;
            case TINKER:
                view = inflater.inflate(R.layout.lay_post_tinker, parent, false);
                viewHolder = new ViewHolderTinker(view);
                break;
            case LINKER:
                view = inflater.inflate(R.layout.lay_post_tinker, parent, false);
                viewHolder = new ViewHolderLinker(view);
                break;
            case STATUS:
                view = inflater.inflate(R.layout.lay_post_status, parent, false);
                viewHolder = new ViewHolderStatus(view);
                break;
            case LOAD:
                view = inflater.inflate(R.layout.lay_loader_newsfeed, parent, false);
                viewHolder = new ViewHolderLoader(view);
                break;
            case SHARE_LINKER:
                view = inflater.inflate(R.layout.lay_post_tinker, parent, false);
                viewHolder = new ViewHolderShareLinker(view);
                break;
            case SHARE_TINKER:
                view = inflater.inflate(R.layout.lay_post_tinker, parent, false);
                viewHolder = new ViewHolderShareTinker(view);
                break;
            case SHARE_UPDATEPHOTO:
                view = inflater.inflate(R.layout.lay_post_update_profile_image, parent, false);
                viewHolder = new ViewHolderShareUpdatePhoto(view);
                break;
            case SHARE_UPDATEPROFILE:
                view = inflater.inflate(R.layout.lay_post_update_profile, parent, false);
                viewHolder = new ViewHolderShareUpdateProfile(view);
                break;
            case SHARE_RECOMMENDATION:
                view = inflater.inflate(R.layout.lay_post_recommendation, parent, false);
                viewHolder = new ViewHolderShareRecommendation(view);
                break;
            case SHARE_STATUS:
                view = inflater.inflate(R.layout.lay_post_status, parent, false);
                viewHolder = new ViewHolderShareStatus(view);
                break;
        }

        if (viewHolder != null) {
            viewHolder.setActionButtons(listener);
        }

        return viewHolder;
    }
}
