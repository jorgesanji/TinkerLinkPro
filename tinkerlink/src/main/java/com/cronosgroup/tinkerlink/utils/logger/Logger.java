package com.cronosgroup.tinkerlink.utils.logger;

import timber.log.Timber;

/**
 * Created by jorgesanmartin on 2/5/16.
 */
public class Logger extends Timber.Tree{

    private static final String CRASHLYTICS_KEY_PRIORITY = "priority";
    private static final String CRASHLYTICS_KEY_TAG = "tag";
    private static final String CRASHLYTICS_KEY_MESSAGE = "message";

    public Logger() {
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {

    }
}
