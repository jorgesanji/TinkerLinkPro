package com.cronosgroup.tinkerlink.event;

/**
 * Created by jorgesanmartin on 7/25/16.
 */
public class UpdateInfoCardEvent {
    private final int page;

    public UpdateInfoCardEvent(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }
}
