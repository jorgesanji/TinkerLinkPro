package com.cronosgroup.tinkerlink.event;

/**
 * Created by jorgesanmartin on 4/12/16.
 */
public class SearchEvent {
    private final String textToSearch;

    public SearchEvent(String text) {
        this.textToSearch = text;
    }

    public String getTextToSearch() {
        return textToSearch;
    }
}
