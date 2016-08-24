package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class TLNotificationView extends TLBaseView {

    // Vars

    public enum NotificationType {
        RECOMMENDATION(1, R.drawable.background_recommendation),
        SHARETINKER(2, R.drawable.background_tinker),
        SHARLTINKER(3, R.drawable.background_linker),
        LIKE(4, R.drawable.background_recommendation);

        private final int type;
        private final int backgroundResource;

        NotificationType(int type, int backgroundResource) {
            this.type = type;
            this.backgroundResource = backgroundResource;
        }

        public int getType() {
            return type;
        }

        public int getBackgroundResource() {
            return backgroundResource;
        }
    }

    private String title;
    private String description;
    private String time;
    private NotificationType type;

    // Views

    @BindView(R.id.notificationIndicator)
    protected View mNotificationIndicator;

    @BindView(R.id.notificationTitle)
    protected TLTextView mNotificationTitle;

    @BindView(R.id.notificationDescription)
    protected TLTextView mNotificationDescription;

    @BindView(R.id.notificationTime)
    protected TLTextView mNotificationTime;

    public TLNotificationView(Context context) {
        super(context);
    }

    public TLNotificationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLNotificationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLNotificationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return  R.layout.lay_item_notification;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    //Public methods

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public NotificationType getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
        mNotificationTitle.setText(title);
    }

    public void setDescription(String description) {
        this.description = description;
        mNotificationDescription.setText(description);
    }

    public void setTime(String time) {
        this.time = time;
        mNotificationTime.setText(time);
    }

    public void setType(NotificationType type) {
        this.type = type;
        mNotificationIndicator.setBackgroundResource(type.getBackgroundResource());
    }
}
