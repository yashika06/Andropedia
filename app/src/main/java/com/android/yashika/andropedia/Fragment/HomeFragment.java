package com.android.yashika.andropedia.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.android.yashika.andropedia.R;


public class HomeFragment extends Fragment {
    MaterialViewPager materialViewPager;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_home, container, false);
        materialViewPager = (MaterialViewPager) view.findViewById(R.id.materialViewPager);
        Toolbar toolbar = materialViewPager.getToolbar();
        if (toolbar != null) {
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
            ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle(" ");
        }
        materialViewPager.getViewPager().setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return TutorialsFragment.newInstance();
                    case 1:
                        return InterviewQuesFragment.newInstance();
                    case 2:
                        return QuizFragment.newInstance();
                    default:
                        return TutorialsFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "Tutorials";
                    case 1:
                        return "Interview Ques";
                    case 2:
                        return "Quiz ";
                    default:
                        return "Tutorials";
                }
            }

        });

        materialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page){
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(R.color.text_color,getResources().getDrawable(R.drawable.books,getActivity().getTheme()));
                    case 1:
                        return HeaderDesign.fromColorResAndDrawable(R.color.text_color,getResources().getDrawable(R.drawable.question,getActivity().getTheme()));
                    case 2:
                        return HeaderDesign.fromColorResAndDrawable(R.color.text_color,getResources().getDrawable(R.drawable.demo,getActivity().getTheme()));
                }
                return null;
            }
        });

        materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount());
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());

        return view;
    }

}
