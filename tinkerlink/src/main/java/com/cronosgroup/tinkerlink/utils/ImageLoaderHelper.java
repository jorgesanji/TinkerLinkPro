package com.cronosgroup.tinkerlink.utils;

import android.graphics.Bitmap;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by jorgesanmartin on 7/19/16.
 */
public class ImageLoaderHelper {

    public interface IOLoadImageListener {
        void onFinishLoadImage(Bitmap bitmap);

        void onErrorLoadImage();
    }

    public static void getImageFromUrl(int size, String url, final IOLoadImageListener listener) {
        ImageSize targetImageSize = new ImageSize(size, size);
        ImageLoader.getInstance().loadImage(url, targetImageSize, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (listener != null) {
                    listener.onErrorLoadImage();
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (listener != null) {
                    listener.onFinishLoadImage(loadedImage);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (listener != null) {
                    listener.onErrorLoadImage();
                }
            }
        });

    }

}
