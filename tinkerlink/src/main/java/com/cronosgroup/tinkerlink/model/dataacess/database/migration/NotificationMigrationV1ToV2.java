package com.cronosgroup.tinkerlink.model.dataacess.database.migration;

import com.cronosgroup.tinkerlink.model.dataacess.database.TLDataBase;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLNotification;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;

/**
 * Created by jorgesanmartin on 3/24/16.
 */
@Migration(version = TLDataBase.VERSION, databaseName = TLDataBase.NAME)
public class NotificationMigrationV1ToV2 extends AlterTableMigration<TLNotification> {

    public NotificationMigrationV1ToV2() {
        super(TLNotification.class);
    }

    @Override
    public void onPreMigrate() {
        addColumn(Boolean.class, TLNotification.COLUMN_DONE);
    }
}
