package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 6/29/16.
 */
public class TLImageRoundBorder extends FrameLayout {

    //Vars

    //Properties
    private String imageUrl;

    //Views
    @BindView(R.id.imageBackground)
    TLImageView mImageBackground;

    @BindView(R.id.image)
    TLImageView mImage;


    public TLImageRoundBorder(Context context) {
        this(context, null);
    }

    public TLImageRoundBorder(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TLImageRoundBorder(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLImageRoundBorder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    protected void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_image, this);
        ButterKnife.bind(this);
    }

    //Public methods

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        mImage.setImageFromUrl(imageUrl);
    }

    public void setImageResource(int imageResource) {
        mImage.setImageResource(imageResource);
    }
}
