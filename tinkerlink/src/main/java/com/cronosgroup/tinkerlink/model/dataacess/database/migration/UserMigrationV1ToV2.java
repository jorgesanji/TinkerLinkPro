package com.cronosgroup.tinkerlink.model.dataacess.database.migration;

import com.cronosgroup.tinkerlink.model.dataacess.database.TLDataBase;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;

/**
 * Created by jorgesanmartin on 3/24/16.
 */
@Migration(version = TLDataBase.VERSION, databaseName = TLDataBase.NAME)
public class UserMigrationV1ToV2 extends AlterTableMigration<TLUser> {

    public UserMigrationV1ToV2() {
        super(TLUser.class);
    }

    @Override
    public void onPreMigrate() {
        addColumn(String.class, TLUser.COLUMN_JOB_DESCRIPTION);
    }
}
