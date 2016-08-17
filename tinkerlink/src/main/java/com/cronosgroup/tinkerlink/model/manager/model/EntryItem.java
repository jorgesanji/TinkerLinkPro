package com.cronosgroup.tinkerlink.model.manager.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.cronosgroup.core.view.sectionable.Item;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;

/**
 * Created by jorgesanmartin on 30/5/16.
 */
public class EntryItem implements Item {

    private RestContact contacto;

    public EntryItem(RestContact contacto) {
        super();
        this.contacto = contacto;
    }

    @Override
    public boolean isSection() {
        return false;
    }

    @Override
    public String getTitle() {
        return contacto.getUser().getName();
    }

    @Override
    public String getIcon() {
        return contacto.getUser().getPhoto();
    }

    public Bitmap getBitmapIcon() {
        File file = ImageLoader.getInstance().getDiskCache().get(getIcon());
        return (file != null) ? BitmapFactory.decodeFile(file.getPath()) : null;
    }

    public RestContact getContacto() {
        return contacto;
    }

    public void setContacto(RestContact contacto) {
        this.contacto = contacto;
    }
}
