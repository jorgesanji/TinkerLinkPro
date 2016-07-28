package com.cronosgroup.tinkerlink.view.dragdrop.engine;

import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 28/7/16.
 */
public class DDDragListener implements View.OnDragListener {

    private static  final int NORMAL_SHAPE = R.drawable.shape;
    private static  final int TARGET_SHAPE = R.drawable.shape_droptarget;

    private final Context mContext;
    private final View parent;

    public DDDragListener(Context mContext, View parent) {
        this.mContext = mContext;
        this.parent = parent;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {

        View view = (View) event.getLocalState();

        // Handles each of the expected events
        switch (event.getAction()) {

            //signal for the start of a drag and drop operation.
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            //the drag point has entered the bounding box of the View
            case DragEvent.ACTION_DRAG_ENTERED:
                v.setBackgroundResource(TARGET_SHAPE);    //change the shape of the view
                break;
            //the user has moved the drag shadow outside the bounding box of the View
            case DragEvent.ACTION_DRAG_EXITED:
                v.setBackgroundResource(NORMAL_SHAPE);    //change the shape of the view back to normal
                break;
            //drag shadow has been released,the drag point is within the bounding box of the View
            case DragEvent.ACTION_DROP:
                // if the view is the any view allowed, we accept the drag item
                if (v == parent.findViewById(R.id.topleft)
                        || v == parent.findViewById(R.id.topright)
                        || v == parent.findViewById(R.id.bottomleft)
                        || v == parent.findViewById(R.id.bottomright)
                        ) {

                    ViewGroup viewgroup = (ViewGroup) view.getParent();
                    viewgroup.removeView(view);

                    LinearLayout containView = (LinearLayout) v;
                    containView.addView(view);
                    view.setVisibility(View.VISIBLE);
                } else {
                    view.setVisibility(View.VISIBLE);
                    Toast.makeText(mContext, "You can't drop the image here",
                            Toast.LENGTH_LONG).show();
                    break;
                }
                break;

            //the drag and drop operation has concluded.
            case DragEvent.ACTION_DRAG_ENDED:
                v.setBackgroundResource(NORMAL_SHAPE);    //go back to normal shape
            default:
                break;
        }
        return true;
    }
}
