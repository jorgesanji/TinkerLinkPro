package com.cronosgroup.tinkerlink.model.dataacess.database.manager;

import android.util.Pair;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLConversation;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLMessage;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLMessage$Table;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMensaje;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.process.DeleteModelListTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by jorgesanmartin on 12/23/15.
 */
public class ChatManager {

    private static final int LIMIT_PAGE = 25;

    private final UserManager manager;

    public ChatManager() {
        super();
        manager = new UserManager();
    }

    private List<TLMessage> getMessagesFromConversationWithOffSetAndLimit(String idConversation, int offset, int limit) {
        List<TLMessage> messages = new Select().from(TLMessage.class).where(Condition.column(TLMessage.COLUMN_CONVERSATION).eq(idConversation)).limit(limit).offset(offset).orderBy(false, TLMessage.COLUMN_DATE).queryList();
        Collections.reverse(messages);
        return messages;
    }

    private boolean existMesssage(String idMessage) {
        return getMessageWithID(idMessage) != null;
    }

    private TLMessage getMessageWithID(String id) {
        return new Select().from(TLMessage.class).where(Condition.column(TLMessage$Table.ID).eq(id)).querySingle();
    }

    private Pair<TLConversation, TLMessage> saveMessage(RestContacto contacto, RestMensaje message, TLMessage messagedb, boolean isMe) {

        RestContacto restContacto = contacto;
        if (restContacto == null) {
            restContacto = message.getUser();
        }

        RestUser user = restContacto.getUser();

        TLConversation conversation = getConversation(message.getIdChat());

        TLUser userdb = null;
        if (conversation == null) {
            conversation = new TLConversation();
            conversation.setId(message.getIdChat());
            conversation.setDate(new Date());
            conversation.save();

            userdb = manager.getUserWithIdUser(user.getId());
            if (userdb == null) {
                userdb = new TLUser();
                userdb.setIdUser(user.getId());
                userdb.setConversation(conversation);
                userdb.save();
            }
            conversation.setUser(userdb);
            conversation.save();

        } else {
            userdb = conversation.getUser();
        }

        if (userdb != null) {
            userdb.setPhoto(user.getPhoto());
            userdb.setName(user.getName());
            userdb.setBirthday(user.getBirthday());
            userdb.setEmail(user.getEmail());
            userdb.setStatus(restContacto.getStatus());
            userdb.save();

            if (messagedb == null) {
                messagedb = getMessageWithID(message.getId());
                if (messagedb == null) {
                    messagedb = new TLMessage();
                }
            }

            messagedb.setId(message.getId());
            messagedb.setReaded(isMe ? true : message.getLeido());
            messagedb.setMessage(message.getMensaje());
            messagedb.setDate(message.getDate());
            messagedb.setConversation(conversation);
            messagedb.setSended(true);
            messagedb.setMe(isMe);
            messagedb.save();

            return new Pair<>(conversation, messagedb);

        }

        return null;
    }

    /*
    *
    * Public methods
    *
    * */

    public TLConversation getConversation(String idConversation) {
        return new Select()
                .from(TLConversation.class)
                .where(Condition.column(TLConversation.COLUMN_ID).eq(idConversation)).querySingle();
    }

    public TLConversation getConversationWithIdUser(String idUser) {
        return new Select()
                .from(TLConversation.class)
                .where(Condition.column(TLConversation.COLUMN_IDUSER).eq(idUser)).querySingle();
    }

    public Pair<TLConversation, TLMessage> saveSenderMessage(RestMensaje mensaje, TLMessage messagedb) {
        return saveMessage(null, mensaje, messagedb, true);
    }


    public Pair<TLConversation, TLMessage> saveSenderMessage(RestContacto restContacto, RestMensaje mensaje, TLMessage messagedb) {
        return saveMessage(restContacto, mensaje, messagedb, true);
    }

    public Pair<TLConversation, TLMessage> saveReceiverMessage(RestMensaje mensaje) {
        return saveMessage(null, mensaje, null, false);
    }

    public List<TLMessage> getMessagesFromConversationIdAndPage(String idConversation, int page) {
        List<TLMessage> messages = getMessagesFromConversationWithOffSetAndLimit(idConversation, LIMIT_PAGE * page, LIMIT_PAGE);
        return messages;
    }

    public long getUnReadMessagesCount() {
        return new Select().from(TLMessage.class)
                .where(Condition.column(TLMessage$Table.READED).eq(false)).queryList().size();
    }

    public List<TLMessage> getUnReadMessagesWithIdChat(String idChat) {
        return new Select().from(TLMessage.class)
                .where(Condition.column(TLMessage$Table.READED).eq(false)).and(Condition.column(TLMessage.COLUMN_CONVERSATION).eq(idChat)).queryList();

    }

    public List<TLConversation> getAllConversations() {
        List<TLConversation> conversations = new Select()
                .from(TLConversation.class).where().orderBy(false, TLConversation.COLUMN_DATE).queryList();
        return conversations;
    }

    public List<TLMessage> getAllMessages() {
        List<TLMessage> messageList = new Select()
                .from(TLMessage.class).where().queryList();
        return messageList;
    }

    public void deleteAll() {
        TransactionManager.getInstance().addTransaction(new DeleteModelListTransaction<>(ProcessModelInfo.<TLConversation>withModels().models(getAllConversations())));
    }
}
