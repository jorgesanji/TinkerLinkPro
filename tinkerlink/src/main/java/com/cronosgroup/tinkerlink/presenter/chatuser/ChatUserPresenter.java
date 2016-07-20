package com.cronosgroup.tinkerlink.presenter.chatuser;

import android.graphics.Bitmap;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkImagePickerPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ChatUserPresenter extends TinkerLinkImagePickerPresenter<ChatUserPresenter.View> {

    private final Actions listener;

    @Override
    public View getView() {
        return view;
    }

    /**
     * Contacts listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * Contacts actions.
     */
    public interface Actions {
    }


    /**
     * @param navigationListener
     */
    public ChatUserPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods


    // Image Picker method

    @Override
    public void imageSelected(Bitmap original, Bitmap cropped) {

    }

    @Override
    public void errorPickerImage() {

    }

    @Override
    public void cancelPickerImage() {

    }
}
