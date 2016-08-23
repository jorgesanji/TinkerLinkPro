package com.cronosgroup.tinkerlink.model.business.logic.base;

import rx.Scheduler;

/**
 * Created by jorgesanmartin on 23/8/16.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
