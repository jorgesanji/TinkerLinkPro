package com.cronosgroup.tinkerlink.view.tutorial.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.cronosgroup.tinkerlink.view.tutorial.adapter.pages.TutorialPage;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jorgesanmartin on 20/10/15.
 */
public class TutorialAdapter extends PagerAdapter {

    private Context mContext;
    private List<TutoriaItem> tutoriaItems = new ArrayList<>();

    public TutorialAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return tutoriaItems.size();
    }

    @Override
    public Object instantiateItem(View collection, int position) {
        TutoriaItem item = tutoriaItems.get(position);

        TutorialPage page = new TutorialPage(mContext);
        page.setCarBackground(item.getBackgroundHeader());
        page.setImageHeader(item.getImageHeader());
        page.setNameHeader(item.getNameHeader());
        page.setTypeTinkerHeader(item.getTypeHeader());
        page.setJobHeader(item.getJobHeader());
        page.setTitle(item.getTitle());
        page.setSubTitle(item.getSubTitle());
        page.setDescription(item.getDescription());

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

    public List<TutoriaItem> getTutoriaItems() {
        return tutoriaItems;
    }

    public void setTutoriaItems(List<TutoriaItem> tutoriaItems) {
        this.tutoriaItems = tutoriaItems;
    }
}
