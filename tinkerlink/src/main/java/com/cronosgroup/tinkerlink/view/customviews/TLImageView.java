package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.ImageType;
import com.cronosgroup.tinkerlink.utils.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by jorgesanmartin on 11/10/15.
 */
public class TLImageView extends ImageView {

    public static final String TAG = TLImageView.class.getName();

    private boolean rounded = false;
    private boolean hasBorder = false;
    private int placeHolderErrorImage;
    private int placerHolderEmptyUri;
    private ImageType imageType;
    private ImageLoadingListener listener;

    /**
     * @param context
     */
    public TLImageView(Context context) {
        super(context);
        init(null);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    protected void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLImageView);
                setRounded(attributes.getBoolean(R.styleable.TLImageView_imageRounded, false));
                setHasBorder(attributes.getBoolean(R.styleable.TLImageView_imageWithBorder, false));
                setImageType(ImageType.getImageTypeFromType(attributes.getInt(R.styleable.TLImageView_imageType, ImageType.DEFAULT.getType())));
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    private void loadImageFromUrl(String url, ImageLoadingListener listener) {
        cancelLoad();

        if (url != null) {
            this.listener = listener;
            updatePlaceHolders();
            DisplayImageOptions.Builder options = new DisplayImageOptions.Builder();
            options.cacheOnDisk(true);
            if (getPlacerHolderEmptyUri() != -1) {
                options.showImageForEmptyUri(getPlacerHolderEmptyUri());
            }

            if (getPlaceHolderErrorImage() != -1) {
                options.showImageOnFail(getPlaceHolderErrorImage());
            }

            if (isRounded()) {
                options.displayer(new CircleBitmapDisplayer(getContext(),
                        false, hasBorder()));
            }

            ImageLoader.getInstance().displayImage(url, this, (options != null) ? options.build() : null, listener);
        } else {
            setImageDrawable(null);
        }
    }

    private void updatePlaceHolders() {
        if (getImageType() != null) {
            setPlacerHolderEmptyUri(getImageType().getEmptyUriResource());
            setPlaceHolderErrorImage(getImageType().getErrorResource());
        }
    }

    //Publics methods

    public boolean hasBorder() {
        return hasBorder;
    }

    public void setHasBorder(boolean hasBorder) {
        this.hasBorder = hasBorder;
    }

    public ImageLoadingListener getListener() {
        return listener;
    }

    public void setListener(ImageLoadingListener listener) {
        this.listener = listener;
    }

    public int getPlaceHolderErrorImage() {
        return placeHolderErrorImage;
    }

    public void setPlaceHolderErrorImage(int placeHolderErrorImage) {
        this.placeHolderErrorImage = placeHolderErrorImage;
    }

    public int getPlacerHolderEmptyUri() {
        return placerHolderEmptyUri;
    }

    public void setPlacerHolderEmptyUri(int placerHolderEmptyUri) {
        this.placerHolderEmptyUri = placerHolderEmptyUri;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    public void setImageFromUrl(String url, int placeHolder, int errorHolder, ImageLoadingListener listener) {
        this.imageType = null;
        setPlaceHolderErrorImage(errorHolder);
        setPlacerHolderEmptyUri(placeHolder);
        loadImageFromUrl(url, listener);
    }

    public void setImageFromUrl(String url) {
        loadImageFromUrl(url, null);
    }

    public void setImageFromUrl(String url, ImageLoadingListener listener) {
        loadImageFromUrl(url, listener);
    }

    public void setImageFromUrl(String url, ImageType imageType) {
        setImageType(imageType);
        loadImageFromUrl(url, null);
    }

    public boolean isRounded() {
        return rounded;
    }

    public void setRounded(boolean rounded) {
        this.rounded = rounded;
    }

    public void cancelLoad() {
        ImageLoader.getInstance().cancelDisplayTask(this);
        this.setImageBitmap(null);
    }


}
