package com.android.yashika.andropedia.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.android.yashika.andropedia.Adapter.SubTutorialPagerAdapter;
import com.android.yashika.andropedia.Model.Tutorials;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;

public class SubTutorialActivity extends AppCompatActivity {

    MaterialViewPager materialViewPager;
    ArrayList<Tutorials> tutorialses;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_tutorial);
        materialViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager_subtutorial);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE");
        position=intent.getIntExtra("POSITION",0);
        tutorialses = (ArrayList<Tutorials>) bundle.getSerializable("ARRAYLIST");
        Toolbar toolbar = materialViewPager.getToolbar();
        if (toolbar!=null){
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(" ");
        }

        materialViewPager.getViewPager().setAdapter(new SubTutorialPagerAdapter(getSupportFragmentManager(),tutorialses));
        materialViewPager.getViewPager().setCurrentItem(position);
        materialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                return HeaderDesign.fromColorResAndDrawable(R.color.text_color,getResources().getDrawable(R.drawable.books,getTheme()));
            }
        });
        materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount());
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());

    }
}
