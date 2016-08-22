package com.cronosgroup.tinkerlink.model.dataacess.database.manager;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.process.DeleteModelListTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
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
}
