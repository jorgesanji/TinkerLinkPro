package com.cronosgroup.tinkerlink.view.dragdrop.engine;

import android.view.DragEvent;
import android.view.View;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 28/7/16.
 */
public class DDDragListener implements View.OnDragListener {

    public interface Listener {
        void onViewDropped(View view, View target);

        void onExitView(View view, boolean okDragged);
    }

    private static final int NORMAL_SHAPE = R.drawable.dragdrop_default_shape;
    private static final int TARGET_SHAPE = R.drawable.dragdrop_target_shape;

    private Listener listener;
    private boolean wasDelivered;

    public DDDragListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onDrag(View container, DragEvent event) {

        View view = (View) event.getLocalState();

        // Handles each of the expected events
        switch (event.getAction()) {

            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            //the drag point has entered the bounding box of the View
            case DragEvent.ACTION_DRAG_ENTERED:
                container.setBackgroundResource(TARGET_SHAPE);    //change the dragdrop_default_shape of the view
                break;
            //the user has moved the drag shadow outside the bounding box of the View
            case DragEvent.ACTION_DRAG_EXITED:
                container.setBackgroundResource(NORMAL_SHAPE);    //change the dragdrop_default_shape of the view back to normal
                break;
            //drag shadow has been released,the drag point is within the bounding box of the View
            case DragEvent.ACTION_DROP:
                // if the view is the any view allowed, we accept the drag item
                if (listener != null) {
                    listener.onViewDropped(container, view);
                }

                wasDelivered = true;
                break;

            //the drag and drop operation has concluded.
            case DragEvent.ACTION_DRAG_ENDED:
                //go back to normal dragdrop_default_shape
                container.setBackgroundResource(NORMAL_SHAPE);
                if (listener != null) {
                    listener.onExitView(view, wasDelivered);
                }
                wasDelivered = false;
            default:
                break;
        }
        return true;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public Listener getListener() {
        return listener;
    }
}
