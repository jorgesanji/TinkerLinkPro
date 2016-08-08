package com.cronosgroup.tinkerlink.interfaces;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;

/**
 * Created by jorgesanmartin on 2/24/16.
 */

public interface IOActionButtons {

    void onIconProfilePressed(RestContacto contacto);

    void onLikePressed(int position);

    void onSharePressed(int position);

    void onChatPressed(RestContacto restContacto);

    void onAddContactPressed(RestPost restPost);

    void onShowRecommendationPressed(int position);

    void onUserImagePressed(int position);
}