package com.cronosgroup.tinkerlink.model.dataacess.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by jorgesanmartin on 24/10/15.
 */

@Database(name = TLDataBase.NAME, version = TLDataBase.VERSION)
public class TLDataBase {

    public static final String NAME = "TinKerLinkDatabase";

    public static final int VERSION = 3;
}
