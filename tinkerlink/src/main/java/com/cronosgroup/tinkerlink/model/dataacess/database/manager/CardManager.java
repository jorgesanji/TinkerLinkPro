package com.cronosgroup.tinkerlink.model.dataacess.database.manager;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard$Table;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.process.DeleteModelListTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

/**
 * Created by jorgesanmartin on 24/10/15.
 */
public class CardManager {

    public CardManager() {
    }

    public void deleteAll() {
        List<TLCard> cards = new Select().from(TLCard.class)
                .where().queryList();
        TransactionManager.getInstance().addTransaction(new DeleteModelListTransaction<>(ProcessModelInfo.<TLCard>withModels().models(cards)));
    }

    public List<TLCard> getAll() {
        List<TLCard> cards = new Select().from(TLCard.class)
                .where().queryList();
        return cards;
    }

    public TLCard getCard(String idCard) {
        return new Select().from(TLCard.class)
                .where(Condition.column(TLCard$Table.ID_CARD).eq(idCard)).querySingle();
    }

}
