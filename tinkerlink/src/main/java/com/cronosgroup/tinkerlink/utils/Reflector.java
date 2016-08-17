package com.cronosgroup.tinkerlink.utils;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;

import java.lang.reflect.Method;

/**
 * Created by jorgesanmartin on 8/11/16.
 */
public class Reflector {

    //http://stackoverflow.com/questions/5038158/main-activity-is-not-garbage-collected-after-destruction-because-it-is-reference
    public static void fixInputMethodManager(Activity activity) {
        final Object imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        final Reflector.TypedObject windowToken
                = new Reflector.TypedObject(activity.getWindow().getDecorView().getWindowToken(), IBinder.class);
        Reflector.invokeMethodExceptionSafe(imm, "windowDismissed", windowToken);
        final Reflector.TypedObject view
                = new Reflector.TypedObject(null, View.class);
        Reflector.invokeMethodExceptionSafe(imm, "startGettingWindowFocus", view);
    }

    public static final class TypedObject {
        private final Object object;
        private final Class type;

        public TypedObject(final Object object, final Class type) {
            this.object = object;
            this.type = type;
        }

        Object getObject() {
            return object;
        }

        Class getType() {
            return type;
        }
    }

    public static void invokeMethodExceptionSafe(final Object methodOwner, final String method, final TypedObject... arguments) {
        if (null == methodOwner) {
            return;
        }

        try {
            final Class<?>[] types = null == arguments ? new Class[0] : new Class[arguments.length];
            final Object[] objects = null == arguments ? new Object[0] : new Object[arguments.length];

            if (null != arguments) {
                for (int i = 0, limit = types.length; i < limit; i++) {
                    types[i] = arguments[i].getType();
                    objects[i] = arguments[i].getObject();
                }
            }

            final Method declaredMethod = methodOwner.getClass().getDeclaredMethod(method, types);

            declaredMethod.setAccessible(true);
            declaredMethod.invoke(methodOwner, objects);
        } catch (final Throwable ignored) {
        }
    }
}