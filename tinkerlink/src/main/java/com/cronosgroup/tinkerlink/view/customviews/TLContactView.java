package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class TLContactView extends LinearLayout {

    public TLContactView(Context context) {
        this(context, null);
    }

    public TLContactView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLContactView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLContactView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
//        shadow();
        inflate(getContext(), R.layout.lay_contact_view, this);
        ButterKnife.bind(this);
    }

//    private void shadow() {
//
//        RoundRectShape rss = new RoundRectShape(new float[] { 12f, 12f, 12f,
//                12f, 12f, 12f, 12f, 12f }, null, null);
//        ShapeDrawable sds = new ShapeDrawable(rss);
//        sds.setShaderFactory(new ShapeDrawable.ShaderFactory() {
//
//            @Override
//            public Shader resize(int width, int height) {
//                LinearGradient lg = new LinearGradient(0, 0, 0, height,
//                        new int[] { Color.parseColor("#e5e5e5"),
//                                Color.parseColor("#e5e5e5"),
//                                Color.parseColor("#e5e5e5"),
//                                Color.parseColor("#e5e5e5") }, new float[] { 0,
//                        0.50f, 0.50f, 1 }, Shader.TileMode.REPEAT);
//                return lg;
//            }
//        });
//
//        RoundRectShape rs = new RoundRectShape(new float[]{12f, 12f, 12f, 12f, 12f, 12f, 12f, 12f}, null, null);
//        ShapeDrawable sd = new ShapeDrawable(rs);
//        ShapeDrawable.ShaderFactory sf = new ShapeDrawable.ShaderFactory() {
//
//            @Override
//            public Shader resize(int width, int height) {
//                LinearGradient lg = new LinearGradient(0, 0, 0, height,
//                        new int[]{
//                                Color.parseColor("#feccb1"),
//                                Color.parseColor("#f17432"),
//                                Color.parseColor("#e86320"),
//                                Color.parseColor("#f96e22")},
//                        new float[]{
//                                0, 0.50f, 0.50f, 1},
//                        Shader.TileMode.REPEAT);
//                return lg;
//            }
//        };
//
//        LayerDrawable ld = new LayerDrawable(new Drawable[] { sds, sd });
//        ld.setLayerInset(0, 5, 5, 0, 0); // inset the shadow so it doesn't start right at the left/top
//        ld.setLayerInset(1, 0, 0, 5, 5); // inset the top drawable so we can leave a bit of space for the shadow to use
//
//        sd.setShaderFactory(sf);
//        setBackgroundDrawable(sd);
//    }
}
