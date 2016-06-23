package com.cronosgroup.tinkerlink.manager.model;

import com.cronosgroup.core.view.sectionable.Item;

/**
 * Created by jorgesanmartin on 30/5/16.
 */
public class SectionItem implements Item {

    private String title;

    public SectionItem(String title) {
        super();
        this.title = title;
    }

    @Override
    public boolean isSection() {
        return true;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getIcon() {
        return null;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

