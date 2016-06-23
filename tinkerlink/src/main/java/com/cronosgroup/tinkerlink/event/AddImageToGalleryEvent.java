package com.cronosgroup.tinkerlink.event;

/**
 * Created by jorgesanmartin on 1/26/16.
 */
public class AddImageToGalleryEvent {
    private final String photo;

    public AddImageToGalleryEvent(String photo) {
        super();
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }
}
