package com.cronosgroup.tinkerlink.view.customviews.card;

import android.animation.Animator;
import android.content.Context;
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

    private float opacityEnd = 0.33f;
    private float initialX;
    private float initialY;

    private int mActivePointerId;
    private float initialXPress;
    private float initialYPress;
    private ViewGroup parent;
    private float parentWidth;
    private int paddingLeft;

    private View card;
    private SwipeHandlerListener listener;
    private boolean deactivated;
    private View rightView;
    private View leftView;
    private boolean mViewClicked = true;
    private Runnable mLongPressRunnable = new Runnable() {
        public void run() {
            if (mViewClicked) {
                mViewClicked = false;
                Vibrator vibrator = (Vibrator) parent.getContext().getSystemService(Context.VIBRATOR_SERVICE);
                if (vibrator.hasVibrator()) {
                    vibrator.vibrate(VIBRATION_VALUE);
                }
                resetCardPosition();
                listener.cardOnLongPressed();
            }
        }
    };

    public TLCardSwipeHandler(View card, final SwipeHandlerListener listener, float initialX, float initialY, float opacityEnd) {
        this.card = card;
        this.initialX = initialX;
        this.initialY = initialY;
        this.listener = listener;
        this.parent = (ViewGroup) card.getParent();
        this.parentWidth = parent.getWidth();
        this.opacityEnd = opacityEnd;
        this.paddingLeft = ((ViewGroup) card.getParent()).getPaddingLeft();
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {

        if (deactivated) {
            return false;
        }

        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:
                mViewClicked = true;

                startLongPressCheck();

                view.clearAnimation();

                mActivePointerId = event.getPointerId(0);

                initialXPress = event.getX();
                initialYPress = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:

                final int pointerIndex = event.findPointerIndex(mActivePointerId);
                if (pointerIndex < 0 || pointerIndex > 0) {
                    break;
                }

                final float xMove = event.getX(pointerIndex);
                final float yMove = event.getY(pointerIndex);

                //calculate distance moved
                final float dx = xMove - initialXPress;
                final float dy = yMove - initialYPress;

                //throw away the move in this case as it seems to be wrong
                if ((int) initialXPress == 0 && (int) initialYPress == 0) {
                    break;
                }

                float posX = card.getX() + dx;
                //Consider the motion a mViewClicked
                if (Math.abs(dx + dy) > 5) {
                    mViewClicked = false;
                }

                // Move and rotation
                card.setX(posX);
                card.setRotation(posX * 0.1f);

                if (rightView != null && leftView != null) {
                    //set alpha of left and right image
                    float alpha = (((posX - paddingLeft) / (parentWidth * opacityEnd)));
                    rightView.setAlpha(alpha);
                    leftView.setAlpha(-alpha);
                }

                break;

            case MotionEvent.ACTION_UP:
                endTouch();
                if (mViewClicked) {
                    listener.cardPressed();
                } else {
                    //check to see if card has moved beyond the left or right bounds or reset
                    checkCardForEvent();
                }

                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Posts (and creates if necessary) a runnable that will when executed call
     * the long click listener
     */
    private void startLongPressCheck() {
        // then post it with a delay
        parent.postDelayed(mLongPressRunnable, ViewConfiguration.getLongPressTimeout());
    }

    /**
     * Resets and recycles all things that need to when we end a touch gesture
     */
    private void endTouch() {
        // remove any existing check for longpress
        parent.removeCallbacks(mLongPressRunnable);

        // reset touch state
        mViewClicked = false;
    }

    private void checkCardForEvent() {

        if (cardBeyondLeftBorder()) {
            animateOffScreenLeft(TLCardStack.ANIMATION_DURATION)
                    .setListener(new Animator.AnimatorListener() {

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
                    });
            listener.cardSwipedLeft();
            deactivated = true;
        } else if (cardBeyondRightBorder()) {
            animateOffScreenRight(TLCardStack.ANIMATION_DURATION)
                    .setListener(new Animator.AnimatorListener() {

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
                    });
            listener.cardSwipedRight();
            deactivated = true;
        } else {
            resetCardPosition();
        }
    }

    private boolean cardBeyondLeftBorder() {
        //check if cards middle is beyond the left quarter of the screen
        return (card.getX() + (card.getWidth() / 2) < (parentWidth / 4.f));
    }

    private boolean cardBeyondRightBorder() {
        //check if card middle is beyond the right quarter of the screen
        return (card.getX() + (card.getWidth() / 2) > ((parentWidth / 4.f) * 3));
    }

    private ViewPropertyAnimator resetCardPosition() {
        if (rightView != null) rightView.setAlpha(0);
        if (leftView != null) leftView.setAlpha(0);
        return card.animate()
                .setDuration(200)
                .setInterpolator(new OvershootInterpolator(1.5f))
                .x(initialX)
                .y(initialY)
                .rotation(0);
    }

    public ViewPropertyAnimator animateOffScreenLeft(int duration) {
        return card.animate()
                .setDuration(duration)
                .x(-(parentWidth))
                .y(0)
                .rotation(-30);
    }


    public ViewPropertyAnimator animateOffScreenRight(int duration) {
        return card.animate()
                .setDuration(duration)
                .x(parentWidth * 2)
                .y(0)
                .rotation(30);
    }

    public void setRightView(View image) {
        this.rightView = image;
    }

    public void setLeftView(View image) {
        this.leftView = image;
    }
}
