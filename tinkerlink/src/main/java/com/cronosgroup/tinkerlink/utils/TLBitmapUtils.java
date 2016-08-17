package com.cronosgroup.tinkerlink.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.cronosgroup.core.utils.BitmapUtils;

/**
 * Created by jorgesanmartin on 7/13/16.
 */
public class TLBitmapUtils extends BitmapUtils {

    public static final int DEFAULT_BORDER = 10;

    public static Bitmap bitmapWithBorder(Bitmap bitmap, int border) {
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        int bitmapSquareWidth = Math.min(bitmapWidth, bitmapHeight);
        int newBitmapSquareWidth = bitmapSquareWidth + border;

        Bitmap roundedBitmap = Bitmap.createBitmap(newBitmapSquareWidth, newBitmapSquareWidth, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(roundedBitmap);
        canvas.drawColor(Color.TRANSPARENT);

        int x = border + bitmapSquareWidth - bitmapWidth;
        int y = border + bitmapSquareWidth - bitmapHeight;

        canvas.drawBitmap(bitmap, x, y, null);

        Paint borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(border / 4);
        borderPaint.setColor(Color.WHITE);

        canvas.drawCircle(canvas.getWidth() / 2, canvas.getWidth() / 2, newBitmapSquareWidth / 2, borderPaint);

        return roundedBitmap;
    }

    public static Bitmap bitmapWithBorder(Bitmap bitmap) {
        return bitmapWithBorder(bitmap, DEFAULT_BORDER);
    }
}
