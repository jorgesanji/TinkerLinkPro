package com.cronosgroup.tinkerlink.view.dragdrop.engine;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.View;

/**
 * Created by jorgesanmartin on 28/7/16.
 */
public class DDLongListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View view) {

        // create it from the object's tag
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

        view.startDrag(data, //data to be dragged
                shadowBuilder, //drag shadow
                view, //local data about the drag and drop operation
                0   //no needed flags
        );

        view.setVisibility(View.INVISIBLE);
        return false;
    }
}
