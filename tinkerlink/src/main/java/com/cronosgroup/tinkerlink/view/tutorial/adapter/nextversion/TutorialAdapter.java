package com.cronosgroup.tinkerlink.view.tutorial.adapter.nextversion;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


/**
 * Created by jorgesanmartin on 20/10/15.
 */
public class TutorialAdapter extends PagerAdapter {

    private Context mContext;

    public TutorialAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object instantiateItem(View collection, int position) {
        View page;
        switch (position) {
            case 0:
                page = new WelcomePage(mContext);
                break;
            case 1:
                page = new RecomendationPage(mContext);
                break;
            case 2:
                page = new TinkerPage(mContext);
                break;
            case 3:
                page = new LinkerPage(mContext);
                break;
            default:
                page = new NetworkPage(mContext);
        }

        ((ViewPager) collection).addView(page);
        return page;
    }

    @Override
    public void destroyItem(View collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
