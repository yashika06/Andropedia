package com.android.yashika.andropedia.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.yashika.andropedia.Activity.InterviewAnsActivity;
import com.android.yashika.andropedia.Model.Interview_ques;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;

/**
 * Created by Yashika on 19-07-2017.
 */

public class InterviewAnsViewpagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Interview_ques> datalist;

    public InterviewAnsViewpagerAdapter(Context context, ArrayList<Interview_ques> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.interview_viewpager_items,container,false);

        ((InterviewAnsActivity)context).initPagerView(position,view);
        ((ViewPager) container).addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
