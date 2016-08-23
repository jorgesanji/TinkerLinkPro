package com.cronosgroup.tinkerlink.model.dataacess.database.manager;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLNotification;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLNotification$Table;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNotificacion;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.process.DeleteModelListTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 10/1/16.
 */
public class NotificationsManager {

    // CONTACT

    public static final int NOTIFICACION_CONTACT_REQUESTED_TO_ME = 2;
    public static final int NOTIFICACION_CONTACT_REQUESTED_FROM_ME = 3;

    public static final int NOTIFICACION_CONTACT_ACCEPTED_TO_ME = 1;
    public static final int NOTIFICACION_CONTACT_ACCEPTED_FROM_ME = 6;

    public static final int NOTIFICACION_CONTACT_REJECTED_TO_ME = 5;
    public static final int NOTIFICACION_CONTACT_REJECTED_FROM_ME = 4;

    public static final int NOTIFICACION_CONTACT_DELETED_FROM_ME = 8;
    public static final int NOTIFICACION_CONTACT_DELETED_TO_ME = 7;

    //RECOMMENDATIONSSTYLE

    public static final int NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_FROM_ME = 9;
    public static final int NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_TO_MY_PROFILE = 10;


    public static final int NOTIFICACION_TIPO_RECOMMENDATION_ACCEPTED_FROM_ME = 11;
    public static final int NOTIFICACION_TIPO_RECOMMENDATION_REJECTED_FROM_ME = 13;

    public static final int NOTIFICACION_TIPO_RECOMMENDATION_ACCEPTED_TO_ME = 12;
    public static final int NOTIFICACION_TIPO_RECOMMENDATION_REJECTED_TO_ME = 14;

    public static final int NOTIFICACION_TIPO_CANCEL_RECOMENDATION = 15;

    public static final int NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_FROM_MY_PROFILE = 21;
    public static final int NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_TO_ME = 22;

    //SHARE

    public static final int NOTIFICACION_TIPO_SHARE_POST_FROM_ME = 16;
    public static final int NOTIFICACION_TIPO_SHARE_MY_POST = 17;
    public static final int NOTIFICACION_TIPO_SHARE_PROFILE_FROM_ME = 18;
    public static final int NOTIFICACION_TIPO_SHARE_MY_PROFILE = 19;

    public static final int NOTIFICACION_TIPO_USUARIO_DUPLICADO = 20;

    public static List<Integer> notificationsAllowed = new ArrayList<Integer>() {
        {
            add(new Integer(NOTIFICACION_CONTACT_REQUESTED_TO_ME));
            add(new Integer(NOTIFICACION_CONTACT_ACCEPTED_TO_ME));
            add(new Integer(NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_TO_ME));
            add(new Integer(NOTIFICACION_TIPO_RECOMMENDATION_REQUESTED_TO_MY_PROFILE));
            add(new Integer(NOTIFICACION_TIPO_RECOMMENDATION_ACCEPTED_TO_ME));
            add(new Integer(NOTIFICACION_TIPO_SHARE_MY_POST));
            add(new Integer(NOTIFICACION_TIPO_SHARE_MY_PROFILE));
        }
    };

    public static List<Integer> notificationsAllowedWithoutAction = new ArrayList<Integer>() {
        {
            add(new Integer(NOTIFICACION_CONTACT_DELETED_TO_ME));
            add(new Integer(NOTIFICACION_TIPO_USUARIO_DUPLICADO));
            add(new Integer(NOTIFICACION_CONTACT_REJECTED_TO_ME));
        }
    };

    private final UserManager manager;

    public NotificationsManager() {
        manager = new UserManager();
    }

    public TLNotification getNotificationById(String idNotification) {
        return new Select().from(TLNotification.class)
                .where(Condition.column(TLNotification$Table.ID).eq(idNotification)).querySingle();
    }

    public List<TLNotification> getAllNotifications() {
        return new Select().from(TLNotification.class)
                .where(Condition.column(TLNotification$Table.TIPO).isNot(NOTIFICACION_CONTACT_REJECTED_TO_ME)).orderBy(false, TLNotification$Table.DATE).queryList();
    }

    public List<TLNotification> getNotificationsUnRead() {
        return new Select().from(TLNotification.class)
                .where(Condition.column(TLNotification$Table.READED).eq(false)).and(Condition.column(TLNotification$Table.TIPO).isNot(NOTIFICACION_CONTACT_REJECTED_TO_ME)).queryList();
    }

    public long getNotificationsUnReadCount() {
        return new Select().from(TLNotification.class)
                .where(Condition.column(TLNotification$Table.READED).eq(false)).and(Condition.column(TLNotification$Table.TIPO).isNot(NOTIFICACION_CONTACT_REJECTED_TO_ME)).queryList().size();
    }

    public TLNotification saveNotification(RestNotificacion restNotificacion) {
        if (notificationsAllowed.contains(restNotificacion.getType())) {

            RestUser user = restNotificacion.getUser().getUser();

            TLNotification notification = getNotificationById(restNotificacion.getId());

            if (notification == null) {
                TLUser userdb = manager.getUserWithIdUser(user.getId());

                if (userdb == null) {
                    userdb = new TLUser();
                    userdb.setIdUser(user.getId());
                    userdb.setPhoto(user.getPhoto());
                    userdb.setName(user.getName());
                    userdb.setBirthday(user.getBirthday());
                    userdb.setEmail(user.getEmail());
                    userdb.save();
                }

                notification = new TLNotification();
                notification.setId(restNotificacion.getId());
                notification.setUserForeignKeyContainer(userdb);

            }

            notification.setDate(restNotificacion.getDate());
            notification.setTipo(restNotificacion.getType());
            notification.setReaded(restNotificacion.getReaded());
            notification.setTexto(restNotificacion.getTexto());
            notification.save();

            return notification;

        }

        return null;
    }

    public void deleteAll() {
        List<TLNotification> notifications = new Select().from(TLNotification.class)
                .where().queryList();
        TransactionManager.getInstance().addTransaction(new DeleteModelListTransaction<>(ProcessModelInfo.<TLNotification>withModels().models(notifications)));
    }
}
