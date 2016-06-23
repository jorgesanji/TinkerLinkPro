package com.cronosgroup.tinkerlink.model.dataacess.database.entities;

import com.cronosgroup.tinkerlink.model.dataacess.database.TLDataBase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jorgesanmartin on 24/10/15.
 */
@Table(databaseName = TLDataBase.NAME)
public class TLMessage extends BaseModel implements Serializable {

    public static final String COLUMN_CONVERSATION = "id_conversation";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";

    @PrimaryKey
    @Column(name = COLUMN_ID)
    public String id;

    @Column
    public String message;

    @Column(name = COLUMN_DATE)
    public Date date;

    @Column
    public boolean me;

    @Column
    public boolean readed;

    @Column
    public boolean sended;

    @Column
    @ForeignKey(references = {@ForeignKeyReference(columnName = COLUMN_CONVERSATION, columnType = String.class, foreignColumnName = TLConversation.COLUMN_ID)}, saveForeignKeyModel = false)
    ForeignKeyContainer<TLConversation> conversationForeignKeyContainer;

    public TLMessage() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public boolean isSended() {
        return sended;
    }

    public void setSended(boolean sended) {
        this.sended = sended;
    }

    public void setConversation(TLConversation conversation) {
        this.conversationForeignKeyContainer = new ForeignKeyContainer<>(TLConversation.class);
        conversationForeignKeyContainer.put(TLConversation$Table.ID, conversation.id);
    }
}
