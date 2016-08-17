package com.cronosgroup.tinkerlink.model.business.logic;

import android.graphics.Bitmap;

import com.cronosgroup.core.rest.Callback;
import com.cronosgroup.core.utils.BitmapUtils;
import com.cronosgroup.tinkerlink.model.dataacess.rest.manager.AppRestManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.model.dataacess.rest.services.NewsFeedServices;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.cronosgroup.tinkerlink.utils.DateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jorgesanmartin on 11/6/15.
 */
public class NewsFeedUseCases {

    public static final String KEY_OFFSET = "offset";
    public static final String KEY_TEXTO = "texto";
    public static final String KEY_PHOTOS = "fotos";
    public static final String KEY_ID_USER = "idUser";
    public static final String KEY_ID_USER_CONTACT = "idContact";
    public static final String KEY_ID_POST = "idPost";
    public static final String KEY_LINK = "linkUrl";
    public static final String KEY_LINKTITLE = "linkTitle";
    public static final String KEY_LINKDESCRIPTION = "linkDescription";
    public static final String KEY_LINKIMAGE = "linkImage";


    public static void getPosts(String offset, Callback callback, Object tag) {
//        NewsFeedServices.getPosts(offset, RestPost.class, callback, tag);
    }

    public static void likePost(String idPost, Callback callback, Object tag) {
        NewsFeedServices.likePost(idPost, callback, tag);
    }

    public static void searchNewsFeedPost(String text, String idLast, Callback callback, Object tag) {

        HashMap<String, String> params = new HashMap<String, String>();
        params.put(KEY_OFFSET, idLast);

//        NewsFeedServices.searchNewsFeedPost(text, params, RestPost.class, callback, tag);
    }

    public static void sharePost(String idUser, String idPost, Callback callback, Object tag) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(KEY_ID_POST, idPost);

        String endpoint = idUser + "/" + DateUtils.getCurrentDateTime();

        NewsFeedServices.sharePost(endpoint, params, RestPost.class, callback, tag);
    }

    public static void getRecommendations(String idUser, Callback callback, Object tag) {
        NewsFeedServices.getRecommendations(idUser, RestRecommendation.class, callback, tag);
    }

    public static void sendStatus(final List<Bitmap> images, final String status, final String link, final String title, final String description, final String imageUrl, final Callback callback, final Object tag) {

        AsyncLoader asyncLoader =  new AsyncLoader<String>() {
            @Override
            public String doInBackground() {
                List<String> list = new ArrayList<>();
                for (Bitmap bitmap : images){
                    list.add(BitmapUtils.getBase64StringfromBitmap(bitmap));
                }

                return AppRestManager.getMapperUsed().toJson(list);
            }

            @Override
            public void postProcess(String result) {

                HashMap<String, String> params = new HashMap<>();
                if (images != null) {
                    params.put(KEY_PHOTOS, result);
                }

                if (status != null) {
                    params.put(KEY_TEXTO, status.trim());
                }

                if (link != null) {
                    params.put(KEY_LINK, link);
                }

                if (title != null) {
                    params.put(KEY_LINKTITLE, title);
                }

                if (description != null) {
                    params.put(KEY_LINKDESCRIPTION, description);
                }

                if (imageUrl != null) {
                    params.put(KEY_LINKIMAGE, imageUrl);
                }

//                NewsFeedServices.sendStatus(params, RestPost.class, callback, tag);

            }
        };

        asyncLoader.start();
    }

}
