package com.android.yashika.andropedia.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.yashika.andropedia.Adapter.InterviewAnsViewpagerAdapter;
import com.android.yashika.andropedia.Model.Interview_ques;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;

public class InterviewAnsActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<Interview_ques> datalist;
    int curr_position;
    InterviewAnsViewpagerAdapter adapter;
    private static final String Interview_List = "interview_ques";
    public static final String POSITION = "interview_position";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_ans);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Answers");
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE");
        curr_position = intent.getIntExtra(POSITION,0);
        datalist = (ArrayList<Interview_ques>) bundle.getSerializable(Interview_List);
        Toast.makeText(this, "datalist size:" +datalist.size(), Toast.LENGTH_SHORT).show();
        viewPager = (ViewPager) findViewById(R.id.interview_ans_viewpager);
        adapter = new InterviewAnsViewpagerAdapter(InterviewAnsActivity.this,datalist);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(curr_position);
    }


    public void initPagerView(final int position, View view){
        Interview_ques interview_ques= datalist.get(position);
        TextView ques_no,ques,ans;
        Button next,prev;

        ques_no = (TextView) view.findViewById(R.id.interview_ques_no);
        ques = (TextView) view.findViewById(R.id.interview_ques_textview);
        ans = (TextView) view.findViewById(R.id.interview_ans_textview);

        ques_no.setText("Ques No: "+(position+1));
        ques.setText(interview_ques.getQues());
        ans.setText(interview_ques.getAnswer());
        prev = (Button) view.findViewById(R.id.btn_prev_inter);
        next = (Button) view.findViewById(R.id.btn_next_inter);
        if(position>0){
            prev.setVisibility(View.VISIBLE);
            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
                }
            });
        }
        else prev.setVisibility(View.INVISIBLE);

        if (position<datalist.size()-1){
            next.setVisibility(View.VISIBLE);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                }
            });
        }else next.setVisibility(View.INVISIBLE);

    }


}
