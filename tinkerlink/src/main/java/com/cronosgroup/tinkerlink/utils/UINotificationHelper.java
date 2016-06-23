package com.cronosgroup.tinkerlink.utils;

import android.util.Pair;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.NotificationsManager;

/**
 * Created by jorgesanmartin on 1/15/16.
 */
public class UINotificationHelper {

    public static Pair<Integer, Integer> getResourcesFromType(int type) {

        switch (type) {
            case NotificationsManager.NOTIFICACION_CONTACT_REQUESTED_TO_ME:
                return new Pair<>(R.mipmap.ic_action_account_child, R.string.notifications_request_contact_with_me);
            case NotificationsManager.NOTIFICACION_CONTACT_ACCEPTED_TO_ME:
                return new Pair<>(R.mipmap.ic_action_account_child, R.string.notifications_request_accept_contact_with_me);
            case NotificationsManager.NOTIFICACION_CONTACT_ACCEPTED_FROM_ME:
                return new Pair<>(R.mipmap.ic_action_account_child, R.string.notifications_request_accept_contact_from_me);
            case NotificationsManager.NOTIFICACION_CONTACT_REJECTED_TO_ME:
                return new Pair<>(R.mipmap.ic_action_account_child, R.string.notifications_request_contact_with_me);
//            case NotificationsManager.NOTIFICACION_CONTACT_REJECTED_FROM_ME:
//                return new Pair<>(R.mipmap.ic_action_account_child, R.string.notifications_request_accept_contact_from_me);
            case NotificationsManager.NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_TO_ME:
                return new Pair<>(R.mipmap.ic_recs_03, R.string.notifications_request_recommendation_from_someone);
            case NotificationsManager.NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_FROM_ME:
                return new Pair<>(R.mipmap.ic_recs_03, R.string.notifications_request_recommendation_from_someone);
            case NotificationsManager.NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_TO_MY_PROFILE:
                return new Pair<>(R.mipmap.ic_recs_03, R.string.notifications_request_recommendation_my_profile);
            case NotificationsManager.NOTIFICACION_TIPO_RECOMMENDATION_REJECTED_TO_ME:
                return new Pair<>(R.mipmap.ic_recs_03, R.string.notifications_request_recommendation_my_profile);
            case NotificationsManager.NOTIFICACION_TIPO_RECOMMENDATION_ACCEPTED_FROM_ME:
                return new Pair<>(R.mipmap.ic_recs_03, R.string.notifications_request_recommendation_my_profile);
            case NotificationsManager.NOTIFICACION_TIPO_RECOMMENDATION_ACCEPTED_TO_ME:
                return new Pair<>(R.mipmap.ic_recs_03, R.string.notifications_request_recommendation_accept);
            case NotificationsManager.NOTIFICACION_TIPO_SHARE_MY_POST:
                return new Pair<>(R.mipmap.ic_social_share, R.string.notifications_request_share_my_post);
            case NotificationsManager.NOTIFICACION_TIPO_SHARE_MY_PROFILE:
                return new Pair<>(R.mipmap.ic_social_share, R.string.notifications_request_share_my_profile);
            default:
                return null;
        }
    }

}
