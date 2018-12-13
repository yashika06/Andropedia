package com.android.yashika.andropedia.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.yashika.andropedia.Fragment.SubTutorialFragment;
import com.android.yashika.andropedia.Model.Tutorials;

import java.util.ArrayList;

/**
 * Created by Yashika on 08-07-2017.
 */

public class SubTutorialPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Tutorials> tutorialsArrayList;

    public SubTutorialPagerAdapter(FragmentManager fm,ArrayList<Tutorials> tutorialses) {

        super(fm);

        this.tutorialsArrayList=tutorialses;
    }

    @Override
    public Fragment getItem(int position) {
        return SubTutorialFragment.newInstance(position,tutorialsArrayList);
    }

    @Override
    public int getCount() {
        return tutorialsArrayList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tutorialsArrayList.get(position).getTitle();
    }
}
