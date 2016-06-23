package com.cronosgroup.tinkerlink.model.dataacess.database.entities;

import com.cronosgroup.tinkerlink.model.dataacess.database.TLDataBase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by jorgesanmartin on 24/10/15.
 */
@ModelContainer
@Table(databaseName = TLDataBase.NAME)
public class TLConversation extends BaseModel implements Serializable {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MESSAGES = "messages";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_IDUSER = "id_user";

    @PrimaryKey
    @Column(name = COLUMN_ID)
    public String id;

    @Column(name = COLUMN_DATE)
    public Date date;

    @Column
    @ForeignKey(references = {@ForeignKeyReference(columnName = COLUMN_IDUSER, columnType = String.class, foreignColumnName = TLUser.COLUMN_ID_USER)}, saveForeignKeyModel = false)
    ForeignKeyContainer<TLUser> userForeignKeyContainer;

    List<TLMessage> messages;
    TLUser user;

    @OneToMany(methods = {OneToMany.Method.SAVE, OneToMany.Method.DELETE}, variableName = COLUMN_MESSAGES)
    public List<TLMessage> getMessages() {
//        if (messages == null || messages.isEmpty()) {
        messages = new Select()
                .from(TLMessage.class)
                .where(Condition.column(TLMessage.COLUMN_CONVERSATION).eq(id)).orderBy(false, TLMessage.COLUMN_DATE).queryList();
//        }

        return messages;
    }

    public TLUser getUser() {
        if (user == null && userForeignKeyContainer != null) {
            user = new Select()
                    .from(TLUser.class)
                    .where(Condition.column(TLUser$Table.ID_USER).eq(userForeignKeyContainer.getValue(TLUser$Table.ID_USER))).querySingle();
        }
        return user;
    }

    public List<TLMessage> getUnReadMessages() {
        return new Select().from(TLMessage.class)
                .where(Condition.column(TLMessage$Table.READED).eq(false)).and(Condition.column(TLMessage.COLUMN_CONVERSATION).eq(id)).orderBy(false, TLMessage.COLUMN_DATE).queryList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(TLUser user) {
        this.userForeignKeyContainer = new ForeignKeyContainer<>(TLUser.class);
        userForeignKeyContainer.put(TLUser$Table.ID_USER, user.idUser);
    }
}
