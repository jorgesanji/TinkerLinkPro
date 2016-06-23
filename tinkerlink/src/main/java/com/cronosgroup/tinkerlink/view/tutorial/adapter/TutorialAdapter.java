package com.cronosgroup.tinkerlink.view.tutorial.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.cronosgroup.tinkerlink.view.tutorial.tutorialpage.TutorialItem;
import com.cronosgroup.tinkerlink.view.tutorial.tutorialpage.TutorialPage;

import java.util.List;

/**
 * Created by jorgesanmartin on 20/10/15.
 */
public class TutorialAdapter extends PagerAdapter {

    private Context mContext;
    private List<TutorialItem> items;

    public TutorialAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object instantiateItem(View collection, int position) {
        TutorialItem item = items.get(position);
        TutorialPage page = new TutorialPage(mContext);
        page.setImageBackground(item.getImageTop());
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

    public List<TutorialItem> getItems() {
        return items;
    }

    public void setItems(List<TutorialItem> items) {
        this.items = items;
    }
}
