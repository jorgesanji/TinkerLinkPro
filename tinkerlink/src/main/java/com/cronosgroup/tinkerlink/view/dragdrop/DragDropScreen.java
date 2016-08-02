package com.cronosgroup.tinkerlink.view.dragdrop;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.dragdrop.engine.DDDragListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DragDrop view.
 */
public class DragDropScreen extends RelativeLayout {

    public interface Listener {
        void onWatchNetwork();

        void onWatchProfile();

        void onShare();

        void onSendMessage();

        void onCloseDragView();
    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.topleft)
    protected RelativeLayout mWatchNetworkContainer;

    @BindView(R.id.topright)
    protected RelativeLayout mWatchProfileContainer;

    @BindView(R.id.bottomleft)
    protected RelativeLayout mShareContainer;

    @BindView(R.id.bottomright)
    protected RelativeLayout mSendMessageContainer;

    /**
     * @param context
     */
    public DragDropScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public DragDropScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public DragDropScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DragDropScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_drag_drop, this);
        ButterKnife.bind(this);
        initListeners();
    }

    private void initListeners() {
        DDDragListener ddDragListener = new DDDragListener(new DDDragListener.Listener() {
            @Override
            public void onExitView(View view, boolean okDragged) {
                listener.onCloseDragView();
                if (!okDragged) {
                    view.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onViewDropped(final View container, final View target) {

                if (container == mWatchNetworkContainer) {
                    listener.onWatchNetwork();
                } else if (container == mWatchProfileContainer) {
                    listener.onWatchProfile();
                } else if (container == mShareContainer) {
                    listener.onShare();
                } else if (container == mSendMessageContainer) {
                    listener.onSendMessage();
                }

                target.setVisibility(View.VISIBLE);

            }
        });

        mWatchNetworkContainer.setOnDragListener(ddDragListener);
        mWatchProfileContainer.setOnDragListener(ddDragListener);
        mShareContainer.setOnDragListener(ddDragListener);
        mSendMessageContainer.setOnDragListener(ddDragListener);
    }

    // Actions

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}