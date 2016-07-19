package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.DimenUtils;

/**
 * Created by jorgesanmartin on 7/12/16.
 */
public class TLNetworkConnectionView extends View {

    // Vars
    private static final int DEFAULT_START_POSX = 5;
    private static final int DEFAULT_DISTANCE = 30;
    private static final int DEFAULT_ANGLE = 90;
    private static final int DEFAULT_SWEEPANGLE = 90;
    private static final float DEFAULT_STROKE_WIDTH = 10f;
    private static final float DEFAULT_BOTTOM_MARGIN = 0f;

    private Paint mPaint = new Paint();

    // Properties

    private int lineColor = Color.BLACK;
    private float strokeWidth = DEFAULT_STROKE_WIDTH;
    private float bottomMarginToDraw = DEFAULT_BOTTOM_MARGIN;
    private boolean connectionEnable = true;
    private float mPosxStart;
    private float mDistance;

    public TLNetworkConnectionView(Context context) {
        this(context, null);
    }

    public TLNetworkConnectionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLNetworkConnectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLNetworkConnectionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLNetworkConnectionView);
                setStrokeWidth(attributes.getFloat(R.styleable.TLNetworkConnectionView_strokeWidth, DEFAULT_STROKE_WIDTH));
                setLineColor(attributes.getColor(R.styleable.TLNetworkConnectionView_colorLine, Color.BLACK));
                setBottomMarginToDraw(attributes.getDimension(R.styleable.TLNetworkConnectionView_bottomMarginToDraw, DEFAULT_BOTTOM_MARGIN));
                setConnectionEnable(attributes.getBoolean(R.styleable.TLNetworkConnectionView_connectionEnable, true));
            } catch (Exception ex) {
                Log.e("", ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }

        mPosxStart = DimenUtils.getPixelsFromDp(getContext(), DEFAULT_START_POSX);
        mDistance = DimenUtils.getPixelsFromDp(getContext(), (DEFAULT_DISTANCE));

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw vertical line
        canvas.drawLine(mPosxStart, 0, mPosxStart, getHeight(), mPaint);
        if (isConnectionEnable()) {
            // Draw Arc line
            RectF rectF = new RectF(mPosxStart, getHeight() - mDistance - getBottomMarginToDraw(), getWidth() - mDistance - mPosxStart, getHeight() - getBottomMarginToDraw());
            canvas.drawArc(rectF, DEFAULT_ANGLE, DEFAULT_SWEEPANGLE, false, mPaint);
            // Draw horizontal line
            canvas.drawLine(mDistance + mPosxStart, getHeight() - getBottomMarginToDraw() - (int) Math.floor((getStrokeWidth() / 2)) + 2, getWidth(), getHeight() - getBottomMarginToDraw(), mPaint);
        }
    }

    // Public properties methods

    public float getBottomMarginToDraw() {
        return bottomMarginToDraw;
    }

    public void setBottomMarginToDraw(float bottomMarginToDraw) {
        this.bottomMarginToDraw = bottomMarginToDraw;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        mPaint.setColor(getLineColor());
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
        mPaint.setStrokeWidth(getStrokeWidth());
    }

    public boolean isConnectionEnable() {
        return connectionEnable;
    }

    public void setConnectionEnable(boolean connectionEnable) {
        this.connectionEnable = connectionEnable;
        invalidate();
    }
}
