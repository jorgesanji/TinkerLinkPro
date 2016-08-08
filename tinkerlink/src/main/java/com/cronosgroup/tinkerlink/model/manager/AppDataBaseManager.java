package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cronosgroup.tinkerlink.model.dataacess.database.TLDataBase;
import com.raizlabs.android.dbflow.DatabaseHelperListener;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by jorgesanmartin on 2/4/16.
 */
public class AppDataBaseManager {

    public static void initDataBase(Context context) {
        FlowManager.init(context);
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
        FlowManager.setDatabaseListener(TLDataBase.NAME, new DatabaseHelperListener() {
            @Override
            public void onOpen(SQLiteDatabase database) {

            }

            @Override
            public void onCreate(SQLiteDatabase database) {

            }

            @Override
            public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

            }
        });
    }

    public static void destroy() {
        FlowManager.destroy();
    }
}
