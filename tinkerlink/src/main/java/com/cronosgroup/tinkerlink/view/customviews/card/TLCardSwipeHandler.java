package com.cronosgroup.tinkerlink.view.customviews.card;

import android.animation.Animator;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.OvershootInterpolator;

/**
 * Created by jorgesanmartin on 8/5/16.
 */
public class TLCardSwipeHandler implements View.OnTouchListener {

    public interface SwipeHandlerListener {
        void cardSwipedLeft();

        void cardSwipedRight();

        void cardOffScreen();

        void cardPressed();

        void cardOnLongPressed();
    }

    public static int VIBRATION_VALUE = 300;

    private float initialX;
    private float initialY;
    private float parentWidth;
    private Context mContext;
    private ViewGroup parent;
    private TLCardView card;
    private SwipeHandlerListener listener;

    private boolean mDeactivated;
    private boolean mViewClicked = true;
    private int mActivePointerId;
    private float initialXPress;
    private float initialYPress;

    private Handler mHandler = new Handler(Looper.myLooper());
    private Runnable mLongPressRunnable = new Runnable() {
        public void run() {
            validateOnClickLongPressed();
        }
    };

    private Animator.AnimatorListener mAnimationListener = new Animator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            listener.cardOffScreen();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    };

    public TLCardSwipeHandler(Context context, ViewGroup parent, TLCardView card, final SwipeHandlerListener listener, float initialX, float initialY) {
        this.card = card;
        this.initialX = initialX;
        this.initialY = initialY;
        this.listener = listener;
        this.parent = parent;
        this.mContext = context;
        this.parentWidth = parent.getWidth();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        if (mDeactivated) {
            return false;
        }

        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:

                mViewClicked = true;
                initialXPress = event.getX();
                initialYPress = event.getY();
                mActivePointerId = event.getPointerId(0);
                // Handler onClickLongPressed
                startLongPressCheck();
                //Clean view for animations
                view.clearAnimation();

                break;
            case MotionEvent.ACTION_MOVE:

                // Verify invalid pointer
                final int pointerIndex = event.findPointerIndex(mActivePointerId);
                if (pointerIndex < 0 || pointerIndex > 0) {
                    break;
                }

                //throw away the move in this case as it seems to be wrong
                if ((int) initialXPress == 0 && (int) initialYPress == 0) {
                    break;
                }

                //calculate distance
                final float dx = event.getX(pointerIndex) - initialXPress;
                final float dy = event.getY(pointerIndex) - initialYPress;

                //Consider the motion is not a click
                if (Math.abs(dx + dy) > 5) {
                    mViewClicked = false;
                }

                // Move and rotation
                final float posX = card.getView().getX() + dx;
                card.getView().setX(posX);
                card.getView().setRotation(posX * 0.1f);

                break;
            case MotionEvent.ACTION_UP:

                if (mViewClicked) {
                    resetCardPosition();
                    listener.cardPressed();
                } else {
                    //check to see if card has moved beyond the left or right bounds or reset
                    checkCardForEvent();
                }
                resetState();

                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Verify motion longpress on current card
     */

    private void validateOnClickLongPressed() {
        if (mViewClicked) {
            mViewClicked = false;

            Vibrator vibrator = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(VIBRATION_VALUE);
            }

            resetCardPosition();

            card.showCardType();
            View viewToShow = card.getViewForDrag();
            if (viewToShow == null) {
                viewToShow = card.getView();
                if (viewToShow == null) {
                    return;
                }
            }

            final View overView = viewToShow;

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    // create it from the object's tag
                    ClipData.Item item = new ClipData.Item((CharSequence) overView.getTag());

                    String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                    ClipData data = new ClipData(overView.getTag().toString(), mimeTypes, item);

                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(overView);

                    overView.startDrag(data, //data to be dragged
                            shadowBuilder, //drag shadow
                            overView, //local data about the drag and drop operation
                            0   //no needed flags
                    );

                    overView.setVisibility(View.INVISIBLE);
                    card.hideCardType();

                    listener.cardOnLongPressed();
                }
            });
        }
    }

    /**
     * Posts (and creates if necessary) a runnable that will when executed call
     * the long click listener
     */
    private void startLongPressCheck() {
        // then post it with a delay
        mHandler.postDelayed(mLongPressRunnable, ViewConfiguration.getLongPressTimeout());
    }

    /**
     * Resets and recycles all things that need to when we end a touch gesture
     */
    private void resetState() {
        // remove any existing check for longpress
        mHandler.removeCallbacks(mLongPressRunnable);
        // reset touch state
        mViewClicked = false;
    }

    /**
     * Check valid card position if it is near to left or right
     */
    private void checkCardForEvent() {
        if (cardBeyondLeftBorder()) {
            animateOffScreenLeft(TLCardStack.ANIMATION_DURATION).setListener(mAnimationListener);
            listener.cardSwipedLeft();
            mDeactivated = true;
        } else if (cardBeyondRightBorder()) {
            animateOffScreenRight(TLCardStack.ANIMATION_DURATION).setListener(mAnimationListener);
            listener.cardSwipedRight();
            mDeactivated = true;
        } else {
            resetCardPosition();
        }
    }

    private boolean cardBeyondLeftBorder() {
        //check if cards middle is beyond the left quarter of the screen
        return (card.getView().getX() + (card.getView().getWidth() / 2) < (parentWidth / 4.f));
    }

    private boolean cardBeyondRightBorder() {
        //check if card middle is beyond the right quarter of the screen
        return (card.getView().getX() + (card.getView().getWidth() / 2) > ((parentWidth / 4.f) * 3));
    }

    private ViewPropertyAnimator resetCardPosition() {

        return card.getView().animate()
                .setDuration(TLCardStack.ANIMATION_DURATION)
                .setInterpolator(new OvershootInterpolator(1.5f))
                .x(initialX)
                .y(initialY)
                .rotation(0);
    }

    public ViewPropertyAnimator animateOffScreenLeft(int duration) {
        return card.getView().animate()
                .setDuration(duration)
                .x(-(parentWidth))
                .y(0)
                .rotation(-30);
    }

    public ViewPropertyAnimator animateOffScreenRight(int duration) {
        return card.getView().animate()
                .setDuration(duration)
                .x(parentWidth * 2)
                .y(0)
                .rotation(30);
    }
}
