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
public class TLCardStack<C extends TLCardView> extends FrameLayout {

    public static int ANIMATION_DURATION = 160;
    public static int DELAY_TO_UPDATE = 90;

    public interface SwipeListener<C extends TLCardView> {

        void cardSwipedLeft(int position);

        void cardSwipedRight(int position);

        void cardsDepleted();

        void cardPressed(C card, int position);

        void cardOnLongPressed(C card, int position);
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
    private boolean hardwareAccelerationEnabled = true;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int paddingBottom;
    private SwipeListener listener;
    private Adapter mAdapter;

    private DataSetObserver observer;
    private int nextAdapterCard = 0;
    private boolean restoreInstanceState = false;
    private TLCardSwipeHandler handlerSwipe;
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

        //get views from adapter
        int childCount = getChildCount();
        for (int i = childCount; i < mNumberOfCards; ++i) {
            addNextCard();
        }

        //setup the position the new view
        for (int i = 0; i < getChildCount(); ++i) {
            positionItem(i);
        }
    }

    /**
     * Remove card on Top
     */
    private void removeTopCard() {
        //top card is now the last in view children
        int childOffset = getChildCount() - mNumberOfCards + 1;
        boolean isLastPage = nextAdapterCard == mAdapter.getCount();
        final View child = getChildAt(getChildCount() - (isLastPage ? 1 : childOffset));
        if (child != null) {
            child.setOnTouchListener(null);
            handlerSwipe = null;
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
            C card = mCachedItemViews.removeFirst();
            card.getView().setX(0);
            card.getView().setRotation(0);
            return card.getView();
        }
        return null;
    }


    /**
     * Add new card from adapter
     */
    private void addNextCard() {
        if (nextAdapterCard < mAdapter.getCount()) {

            C card = (C) mAdapter.getView(nextAdapterCard, getCachedView(), this);
            mCachedItemViews.add(card);

            if (hardwareAccelerationEnabled) {
                //set backed by an off-screen buffer
                card.getView().setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }

            addAndMeasureChild(card.getView());
            nextAdapterCard++;
        }
        setupTopCard();
    }

    /**
     * Setup swipe handlerSwipe in top card
     */
    private void setupTopCard() {

        boolean isLastPage = nextAdapterCard == mAdapter.getCount();
        final int childOffset = getChildCount() - mNumberOfCards + 1;
        final C card = (C) getChildAt(getChildCount() - (isLastPage ? 1 : childOffset));
        final int initialX = paddingLeft;
        final int initialY = paddingTop;

        if (card != null) {

            handlerSwipe = new TLCardSwipeHandler(getContext(),this,card, new TLCardSwipeHandler.SwipeHandlerListener() {
                @Override
                public void cardSwipedLeft() {
                    removeTopCard();
                    if (listener != null) {
                        listener.cardSwipedLeft(getCurrentItem());
                    }
                }

                @Override
                public void cardSwipedRight() {
                    removeTopCard();
                    if (listener != null) {
                        listener.cardSwipedRight(getCurrentItem());
                    }
                }

                @Override
                public void cardOffScreen() {
                }

                @Override
                public void cardPressed() {
                    if (listener != null) {
                        listener.cardPressed(card, getCurrentItem());
                    }
                }

                @Override
                public void cardOnLongPressed() {
                    if (listener != null) {
                        listener.cardOnLongPressed(card, getCurrentItem());
                    }

                }
            }, initialX, initialY);

            card.getView().setOnTouchListener(handlerSwipe);
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
        ArrayList<View> childrenViews = new ArrayList<>();
        childrenViews.add(child);
        for (int i = 0; i < getChildCount(); ++i) {
            childrenViews.add(getChildAt(i));
        }

        removeAllViews();

        int index = 0;
        for (View view : childrenViews) {
            addViewInLayout(view, -1, params, true);
            int itemWidth = getWidth() - (paddingLeft + paddingRight);
            int itemHeight = getHeight() - (paddingTop + paddingBottom);
            view.measure(MeasureSpec.EXACTLY | itemWidth, MeasureSpec.EXACTLY | itemHeight);
            // Set z translation in each view
            ViewCompat.setTranslationZ(view, index * 10);
            index++;
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
            if (getChildCount() <= 0 && listener != null) {
                listener.cardsDepleted();
            }
        }
    }

    /**
     * Set data observer for support changes in the adapter
     */
    private void setDataObserver() {
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

        mAdapter.registerDataSetObserver(observer);
        removeAllViewsInLayout();
        requestLayout();
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
        setDataObserver();
    }

    /**
     * @param listener
     */

    public void setListener(SwipeListener listener) {
        this.listener = listener;
    }

    /**
     * @param duration
     */

    public void swipeTopCardLeft(int duration) {
        int childCount = getChildCount();
        if (childCount > 0 && getChildCount() < (mNumberOfCards + 1)) {
            if (handlerSwipe != null) {
                handlerSwipe.animateOffScreenLeft(duration);
            }
            int positionInAdapter = getCurrentItem();
            removeTopCard();
            if (listener != null) {
                listener.cardSwipedLeft(positionInAdapter);
            }
        }
    }

    /**
     * @param duration
     */

    public void swipeTopCardRight(int duration) {
        int childCount = getChildCount();
        if (childCount > 0 && getChildCount() < (mNumberOfCards + 1)) {
            if (handlerSwipe != null) {
                handlerSwipe.animateOffScreenRight(duration);
            }
            int positionInAdapter = getCurrentItem();
            removeTopCard();
            if (listener != null) {
                listener.cardSwipedRight(positionInAdapter);
            }
        }
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
