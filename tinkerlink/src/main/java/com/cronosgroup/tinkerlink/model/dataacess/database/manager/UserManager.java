package com.cronosgroup.tinkerlink.model.dataacess.database.manager;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser$Table;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.process.DeleteModelListTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

/**
 * Created by jorgesanmartin on 24/10/15.
 */
public class UserManager {

    public UserManager() {
    }

    public TLUser getUserWithIdUser(String idUser) {
        return new Select().from(TLUser.class)
                .where(Condition.column(TLUser$Table.ID_USER).eq(idUser)).querySingle();
    }

    public TLUser getCurrentUser() {
        return new Select().from(TLUser.class)
                .where(Condition.column(TLUser$Table.LOGED).eq(Boolean.TRUE)).querySingle();
    }

    public TLUser saveUser(RestUser restUser) {
        TLUser user = getCurrentUser();
        if (user != null) {
            user.setLoged(false);
            user.save();
        }

        user = new TLUser();
        user.setLoged(true);
        user.setIdUser(restUser.getId());
        user.setName(restUser.getName());
        user.setBirthday(restUser.getBirthday());
        user.setGender(restUser.getGender());
        user.setPhone(restUser.getPhone());
        user.setPhoto(restUser.getPhoto());
        user.setEmail(restUser.getEmail());
        user.save();

        return user;
    }

    public void deleteAll() {
        List<TLUser> users = new Select().from(TLUser.class)
                .where().queryList();
        TransactionManager.getInstance().addTransaction(new DeleteModelListTransaction<>(ProcessModelInfo.<TLUser>withModels().models(users)));
    }
}
