package com.cronosgroup.tinkerlink.model.dataacess.database.entities;

import com.cronosgroup.tinkerlink.model.dataacess.database.TLDataBase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jorgesanmartin on 24/10/15.
 */

@ModelContainer
@Table(databaseName = TLDataBase.NAME)
public class TLNotification extends BaseModel implements Serializable {

    public static final String COLUMN_ID_NOTIFICATION = "id_notification";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_DONE = "done";
    public static final String COLUMN_IDUSER = "id_user";

    @PrimaryKey
    @Column(name = COLUMN_ID)
    public String id;

    @Column(name = COLUMN_ID_NOTIFICATION)
    public long idNotifications;

    @Column
    public int tipo;

    @Column(name = COLUMN_DATE)
    public Date date;

    @Column
    public Boolean readed;

    @Column(name = COLUMN_DONE)
    public Boolean done;

    @Column
    public String habilities;

    @Column
    public String texto;

    TLUser user;

    @Column
    @ForeignKey(references = {@ForeignKeyReference(columnName = COLUMN_IDUSER, columnType = String.class, foreignColumnName = TLUser.COLUMN_ID_USER)}, saveForeignKeyModel = false)
    ForeignKeyContainer<TLUser> userForeignKeyContainer;

    public TLNotification() {
        super();
    }

    public TLNotification(long idNotifications, int tipo, Date date, boolean readed, String intervalo, String texto, boolean done) {
        super();
        this.idNotifications = idNotifications;
        this.tipo = tipo;
        this.date = date;
        this.readed = readed;
        this.habilities = intervalo;
        this.texto = texto;
        this.done = done;
    }

    public TLUser getUser() {
        if (user == null) {
            user = new Select()
                    .from(TLUser.class)
                    .where(Condition.column(TLUser.COLUMN_ID_USER).eq(userForeignKeyContainer.getValue(TLUser$Table.ID_USER))).querySingle();
        }
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getIdNotifications() {
        return idNotifications;
    }

    public void setIdNotifications(long idNotifications) {
        this.idNotifications = idNotifications;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public String getHabilities() {
        return habilities;
    }

    public void setHabilities(String habilities) {
        this.habilities = habilities;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isDone() {
        return done != null ? done : false;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setUserForeignKeyContainer(TLUser user) {
        this.userForeignKeyContainer = new ForeignKeyContainer<>(TLUser.class);
        userForeignKeyContainer.put(TLUser$Table.ID_USER, user.idUser);
    }
}
