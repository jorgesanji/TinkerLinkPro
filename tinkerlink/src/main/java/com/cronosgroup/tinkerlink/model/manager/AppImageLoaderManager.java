package com.cronosgroup.tinkerlink.model.manager;

import android.content.Context;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by jorgesanmartin on 1/28/16.
 */
public class AppImageLoaderManager {

    public static final int DEFAULT_WIDTH = 480;
    public static final int DEFAULT_HEIGHT = 800;
    public static final int DEFAULT_MEMORY_CACHE = 2 * 1024 * 1024;
    public static final int DEFAULT_DISK_CACHE = 50 * 1024 * 1024;


    private final Context mContext;

    public AppImageLoaderManager(Context context) {
        this.mContext = context;
    }

    public void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
                .memoryCacheExtraOptions(DEFAULT_WIDTH, DEFAULT_HEIGHT)
                .diskCacheExtraOptions(DEFAULT_WIDTH, DEFAULT_HEIGHT, null)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(DEFAULT_MEMORY_CACHE))
                .memoryCacheSize(DEFAULT_MEMORY_CACHE)
                .diskCacheSize(DEFAULT_DISK_CACHE)
//                .diskCacheFileCount(100)
//                .writeDebugLogs()
                .build();

        ImageLoader.getInstance().init(config);
    }
}
