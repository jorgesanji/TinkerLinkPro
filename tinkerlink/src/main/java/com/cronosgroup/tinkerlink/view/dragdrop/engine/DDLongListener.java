package com.cronosgroup.tinkerlink.view.dragdrop.engine;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.View;

/**
 * Created by jorgesanmartin on 28/7/16.
 */
public class DDLongListener implements View.OnLongClickListener {

    public interface Listener {
        void onLongClickDone();
    }

    private Listener listener;
    private final View viewToShow;

    public DDLongListener(View viewToShow) {
        this.viewToShow = viewToShow;
    }

    @Override
    public boolean onLongClick(View view) {

        // create it from the object's tag
        ClipData.Item item = new ClipData.Item((CharSequence) viewToShow.getTag());

        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(viewToShow.getTag().toString(), mimeTypes, item);

        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(viewToShow);

        viewToShow.startDrag(data, //data to be dragged
                shadowBuilder, //drag shadow
                viewToShow, //local data about the drag and drop operation
                0   //no needed flags
        );

        viewToShow.setVisibility(View.INVISIBLE);

        if (listener != null) {
            listener.onLongClickDone();
        }

        return false;
    }

    public Listener getListener() {
        return listener;
    }

    public DDLongListener setListener(Listener listener) {
        this.listener = listener;
        return this;
    }
}
