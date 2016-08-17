package com.cronosgroup.tinkerlink.view.customviews.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;

import com.cronosgroup.tinkerlink.R;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by jorgesanmartin on 8/5/16.
 */
public class TLCardStack<C extends TLCardBase> extends FrameLayout {

    public static int ANIMATION_DURATION = 160;
    public static int DELAY_TO_UPDATE = 90;

    public interface SwipeListener<C extends TLCardBase> {

        void cardSwipedLeft(int position);

        void cardSwipedRight(int position);

        void cardsDepleted();

        void cardPressed(C view, int position);

        void cardOnLongPressed(C view, int position);


    }

    public enum RenderType {
        ABOVE(0),
        BELOW(1);

        private final int renderMode;

        RenderType(int renderMode) {
            this.renderMode = renderMode;
        }

        public int getRenderMode() {
            return renderMode;
        }

        public static RenderType fromId(int id) {
            if (id == BELOW.getRenderMode()) {
                return BELOW;
            }
            return ABOVE;
        }
    }

    private int mNumberOfCards;
    private float mCardSpacing;
    private RenderType mRenderType;
    private float mOpacityEnd;
    private boolean hardwareAccelerationEnabled = true;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int paddingBottom;
    private int leftImageResource;
    private int rightImageResource;
    private SwipeListener swipeListener;
    private Adapter mAdapter;

    private DataSetObserver observer;
    private int nextAdapterCard = 0;
    private boolean restoreInstanceState = false;
    private TLCardSwipeHandler listener;
    private final LinkedList<C> mCachedItemViews = new LinkedList<C>();

    public TLCardStack(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attributeSet,
                    R.styleable.TLCardStack,
                    0, 0);
            try {
                mNumberOfCards = a.getInt(R.styleable.TLCardStack_max_items_visible, 3);
                mCardSpacing = a.getDimension(R.styleable.TLCardStack_card_spacing, 15f);
                mRenderType = RenderType.fromId(a.getInt(R.styleable.TLCardStack_render_mode, RenderType.BELOW.getRenderMode()));
                mOpacityEnd = a.getFloat(R.styleable.TLCardStack_opacity_end, 0.33f);
            } finally {
                a.recycle();
            }
        }

        paddingBottom = getPaddingBottom();
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingTop = getPaddingTop();

        //set clipping of view parent to false so cards render outside their view boundary
        setClipToPadding(false);
        setClipChildren(false);
        setWillNotDraw(false);

        //render the cards and card cardcontainer above or below everything
        if (mRenderType == RenderType.ABOVE) {
            ViewCompat.setTranslationZ(this, Float.MAX_VALUE);
        }
        if (mRenderType == RenderType.BELOW) {
            ViewCompat.setTranslationZ(this, Float.MIN_VALUE);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        // if we don't have an adapter, we don't need to do anything
        if (mAdapter == null || mAdapter.getCount() == 0) {
            nextAdapterCard = 0;
            removeAllViewsInLayout();
            return;
        }

        //pull in views from the adapter at the position the top of the deck is set to
        //stop when you get to for cards
        // the end of the adapter
        int childCount = getChildCount();
        for (int i = childCount; i < mNumberOfCards; ++i) {
            addNextCard();
        }

        //position the new children we just added and set up the top card with a listener etc
        for (int i = 0; i < getChildCount(); ++i) {
            positionItem(i);
        }
    }

    private void removeTopCard() {
        //top card is now the last in view children
        int childOffset = getChildCount() - mNumberOfCards + 1;
        boolean isLastPage = nextAdapterCard == mAdapter.getCount();
        final View child = getChildAt(getChildCount() - (isLastPage ? 1 : childOffset));
        if (child != null) {
            child.setOnTouchListener(null);
            listener = null;
            //this will also check to see if cards are depleted
            new RemoveViewOnAnimCompleted().execute(child);
        }
    }

    /**
     * Checks if there is a cached view that can be used
     *
     * @return A cached view or, if none was found, null
     */
    private View getCachedView() {
        if (mCachedItemViews.size() > mNumberOfCards) {
            View view = mCachedItemViews.removeFirst();
            view.setX(0);
            view.setRotation(0);
            return view;
        }
        return null;
    }

    private void addNextCard() {
        if (nextAdapterCard < mAdapter.getCount()) {

            C card = (C) mAdapter.getView(nextAdapterCard, getCachedView(), this);
            mCachedItemViews.add(card);

            if (hardwareAccelerationEnabled) {
                //set backed by an off-screen buffer
                card.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }

            addAndMeasureChild(card);
            nextAdapterCard++;
        }
        setupTopCard();
    }

    private void setupTopCard() {

        boolean isLastPage = nextAdapterCard == mAdapter.getCount();
        final int childOffset = getChildCount() - mNumberOfCards + 1;
        final C child = (C) getChildAt(getChildCount() - (isLastPage ? 1 : childOffset));
        final int initialX = paddingLeft;
        final int initialY = paddingTop;

        if (child != null) {

            listener = new TLCardSwipeHandler(child, new TLCardSwipeHandler.SwipeHandlerListener() {
                @Override
                public void cardSwipedLeft() {
                    int positionInAdapter = getCurrentItem();
                    removeTopCard();
                    if (swipeListener != null) {
                        swipeListener.cardSwipedLeft(positionInAdapter);
                    }
                }

                @Override
                public void cardSwipedRight() {
                    int positionInAdapter = getCurrentItem();
                    removeTopCard();
                    if (swipeListener != null) {
                        swipeListener.cardSwipedRight(positionInAdapter);
                    }
                }

                @Override
                public void cardOffScreen() {
                }

                @Override
                public void cardPressed() {
                    swipeListener.cardPressed(child, getCurrentItem());
                }

                @Override
                public void cardOnLongPressed() {
                    swipeListener.cardOnLongPressed(child, getCurrentItem());

                }
            }, initialX, initialY, mOpacityEnd);


            //if we specified these image resources, get the views and pass them to the swipe listener
            //for the sake of animating them
            View rightView = null;
            View leftView = null;
            if (!(rightImageResource == 0)) {
                rightView = child.findViewById(rightImageResource);
            }
            if (!(leftImageResource == 0)) {
                leftView = child.findViewById(leftImageResource);
            }
            listener.setLeftView(leftView);
            listener.setRightView(rightView);

            child.setOnTouchListener(listener);
        }
    }


    /**
     * Adds a view as a child view and takes care of measuring it
     *
     * @param child The view to add
     */
    private void addAndMeasureChild(View child) {
        ViewGroup.LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        }

        //ensure new card is under the deck at the beginning
        child.setY(paddingTop);

        //every time we add and measure a child refresh the children on screen and order them
        ArrayList<View> children = new ArrayList<>();
        children.add(child);
        for (int i = 0; i < getChildCount(); ++i) {
            children.add(getChildAt(i));
        }

        removeAllViews();

        for (View view : children) {
            addViewInLayout(view, -1, params, true);
            int itemWidth = getWidth() - (paddingLeft + paddingRight);
            int itemHeight = getHeight() - (paddingTop + paddingBottom);
            view.measure(MeasureSpec.EXACTLY | itemWidth, MeasureSpec.EXACTLY | itemHeight); //MeasureSpec.UNSPECIFIED

            //ensure that if there's a left and right image set their alpha to 0 initially
            //alpha animation is handled in the swipe listener
            if (leftImageResource != 0) {
                child.findViewById(leftImageResource).setAlpha(0);
            }
            if (rightImageResource != 0) {
                child.findViewById(rightImageResource).setAlpha(0);
            }
        }
        setZTranslations();
    }


    /**
     * Set transition on z axis on all child views
     */

    private void setZTranslations() {
        int count = getChildCount();
        for (int i = 0; i < count; ++i) {
            ViewCompat.setTranslationZ(getChildAt(i), i * 10);
        }
    }

    /**
     * Positions the children at the "correct" positions
     */
    private void positionItem(int index) {

        View child = getChildAt(index);

        final int width = child.getMeasuredWidth();
        final int height = child.getMeasuredHeight();
        final int left = (getWidth() - width) / 2;
        child.layout(left, paddingTop, left + width, paddingTop + height);
        //layout each child slightly above the previous child (we start with the bottom)
        int childCount = getChildCount();
        float offset = (int) (((childCount - 1) * mCardSpacing) - (index * mCardSpacing));

        child.animate()
                .setDuration(restoreInstanceState ? 0 : ANIMATION_DURATION)
                .y(paddingTop - offset);

        restoreInstanceState = false;
    }


    /**
     * Remove view with animation
     */

    private class RemoveViewOnAnimCompleted extends AsyncTask<View, Void, View> {

        @Override
        protected View doInBackground(View... params) {
            android.os.SystemClock.sleep(ANIMATION_DURATION);
            return params[0];
        }

        @Override
        protected void onPostExecute(View view) {
            super.onPostExecute(view);
            removeView(view);

            //if there are no more children left after top card removal let the callback know
            if (getChildCount() <= 0 && swipeListener != null) {
                swipeListener.cardsDepleted();
            }
        }
    }


    /**
     * Public methods
     */

    /**
     * @return
     */

    public int getCurrentItem() {
        return nextAdapterCard - getChildCount();
    }

    /**
     * @param adapter
     */
    public void setAdapter(Adapter adapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(observer);
        }
        mAdapter = adapter;
        // if we're not restoring previous instance state
        if (!restoreInstanceState) {
            nextAdapterCard = 0;
        }

        observer = new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                //handle data set changes
                int childCount = getChildCount();
                //only perform action if there are less cards on screen than mNumberOfCards
                if (childCount < mNumberOfCards) {
                    for (int i = childCount; i < mNumberOfCards; ++i) {
                        addNextCard();
                    }
                    //position the items correctly on screen
                    for (int i = 0; i < getChildCount(); ++i) {
                        positionItem(i);
                    }
                }
            }

            @Override
            public void onInvalidated() {
                //reset state, remove views and request layout
                nextAdapterCard = 0;
                removeAllViews();
                requestLayout();
            }
        };

        adapter.registerDataSetObserver(observer);
        removeAllViewsInLayout();
        requestLayout();
    }

    /**
     * @param swipeListener
     */

    public void setSwipeListener(SwipeListener swipeListener) {
        this.swipeListener = swipeListener;
    }

    /**
     * @param duration
     */

    public void swipeTopCardLeft(int duration) {
        int childCount = getChildCount();
        if (childCount > 0 && getChildCount() < (mNumberOfCards + 1)) {
            listener.animateOffScreenLeft(duration);
            int positionInAdapter = getCurrentItem();
            removeTopCard();
            if (swipeListener != null) {
                swipeListener.cardSwipedLeft(positionInAdapter);
            }
        }
    }

    /**
     * @param duration
     */

    public void swipeTopCardRight(int duration) {
        int childCount = getChildCount();
        if (childCount > 0 && getChildCount() < (mNumberOfCards + 1)) {
            listener.animateOffScreenRight(duration);
            int positionInAdapter = getCurrentItem();
            removeTopCard();
            if (swipeListener != null) {
                swipeListener.cardSwipedRight(positionInAdapter);
            }
        }
    }

    /**
     * @param imageResource
     */
    public void setLeftImage(int imageResource) {
        leftImageResource = imageResource;
    }

    /**
     * @param imageResource
     */

    public void setRightImage(int imageResource) {
        rightImageResource = imageResource;
    }

    /**
     * Move to selected view
     *
     * @param position
     */
    public void setSelection(int position) {
        if (position < mAdapter.getCount()) {
            this.nextAdapterCard = position;
            getHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    removeAllViews();
                }
            }, DELAY_TO_UPDATE);
        }
    }

    /**
     * Return exception feature not suppported
     *
     * @return
     */
    public View getSelectedView() {
        throw new UnsupportedOperationException("Not supported");
    }

    /**
     * Set Hardware Acceleration Enabled.
     *
     * @param accel
     */
    public void setHardwareAccelerationEnabled(Boolean accel) {
        this.hardwareAccelerationEnabled = accel;
    }
}
