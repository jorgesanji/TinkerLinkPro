package com.cronosgroup.tinkerlink.view.dragdrop;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.dragdrop.engine.DDDragListener;
import com.cronosgroup.tinkerlink.view.dragdrop.engine.DDLongListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Main DragDrop view.
 */
public class DragDropScreen extends RelativeLayout {

    public interface Listener {
    }

    private static final String IMAGEVIEW_TAG = "The Android Logo";


    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.topleft)
    protected LinearLayout mTopLeft;

    @BindView(R.id.topright)
    protected LinearLayout mTopRigth;

    @BindView(R.id.bottomleft)
    protected LinearLayout mBottomLeft;

    @BindView(R.id.bottomright)
    protected LinearLayout mBottomRight;

    @BindView(R.id.target)
    protected ImageView mTarget;

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
        mTarget.setTag(IMAGEVIEW_TAG);
        mTarget.setOnLongClickListener(new DDLongListener());
        DDDragListener ddDragListener = new DDDragListener(getContext(), this);
        mTopLeft.setOnDragListener(ddDragListener);
        mTopRigth.setOnDragListener(ddDragListener);
        mBottomLeft.setOnDragListener(ddDragListener);
        mBottomRight.setOnDragListener(ddDragListener);
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