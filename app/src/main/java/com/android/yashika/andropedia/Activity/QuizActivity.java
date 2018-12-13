package com.android.yashika.andropedia.Activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.yashika.andropedia.Adapter.QuizViewpagerAdapter;
import com.android.yashika.andropedia.Fragment.TimerFragment;
import com.android.yashika.andropedia.Model.Questions;
import com.android.yashika.andropedia.QuePrefManager;
import com.android.yashika.andropedia.QuestionDBHelper;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<Questions> questionsArrayList;
    QuizViewpagerAdapter adapter;
    QuePrefManager manager;
    QuestionDBHelper dbHelper;
    int correct_ans =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Quiz");*/
        Fragment fragment=new TimerFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_timer,fragment);
        fragmentTransaction.commit();
        manager=new QuePrefManager(this);
        manager.removeAll();
        questionsArrayList = new ArrayList<>();
        dbHelper = new QuestionDBHelper(QuizActivity.this);
        questionsArrayList = dbHelper.retrieveQuestion();

        //prepareQuestionList();
        viewPager = (ViewPager) findViewById(R.id.ques_viewpager);
        adapter = new QuizViewpagerAdapter(QuizActivity.this,questionsArrayList);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(QuizActivity.this);
        }
        builder.setTitle("Quit Test").setMessage("Are you sure you want to quit the test?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void initPagerView(final int position, View view){
        final Questions questions = questionsArrayList.get(position);
        TextView ques_no,ques_text;
        final TextView op1,op2,op3,op4;
        Button next,prev,finish;
        next = (Button) view.findViewById(R.id.btn_next);
        prev = (Button) view.findViewById(R.id.btn_prev);
        finish = (Button) view.findViewById(R.id.btn_finish);
        ques_no = (TextView) view.findViewById(R.id.question_no);
        ques_text = (TextView) view.findViewById(R.id.ques_text_view);
        op1 = (TextView) view.findViewById(R.id.option_1);
        op2 = (TextView) view.findViewById(R.id.option_2);
        op3 = (TextView) view.findViewById(R.id.option_3);
        op4 = (TextView) view.findViewById(R.id.option_4);
        ques_no.setText("Q.No: "+(position+1));
        ques_text.setText(questions.getQues());
        op1.setText(questions.getOp_1());
        op2.setText(questions.getOp_2());
        op3.setText(questions.getOp_3());
        op4.setText(questions.getOp_4());




        if(manager.getAns(position)!=null){
            String sel_ans = manager.getAns(position);
            if(sel_ans.equals("A")){
                op2.setEnabled(false);
                op3.setEnabled(false);
                op4.setEnabled(false);
                if(questions.getCorrect().equals("A"))
                    op1.setTextColor(Color.GREEN);
                else
                    op1.setTextColor(Color.RED);
            }
            else if(sel_ans.equals("B")){
                op1.setEnabled(false);
                op3.setEnabled(false);
                op4.setEnabled(false);
                if(questions.getCorrect().equals("B"))
                    op2.setTextColor(Color.GREEN);
                else
                    op2.setTextColor(Color.RED);
            }
            else if(sel_ans.equals("C")){
                op1.setEnabled(false);
                op2.setEnabled(false);
                op4.setEnabled(false);
                if(questions.getCorrect().equals("C"))
                    op3.setTextColor(Color.GREEN);
                else
                    op3.setTextColor(Color.RED);
            }
            else if(sel_ans.equals("D")){
                op1.setEnabled(false);
                op3.setEnabled(false);
                op2.setEnabled(false);
                if(questions.getCorrect().equals("D"))
                    op4.setTextColor(Color.GREEN);
                else
                    op4.setTextColor(Color.RED);
            }
        }

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setQuestion(position,"A");
                op2.setEnabled(false);
                op3.setEnabled(false);
                op4.setEnabled(false);

                if(questions.getCorrect().equals("A")){
                    op1.setTextColor(Color.GREEN);
                    correct_ans++;
                }
                else
                    op1.setTextColor(Color.RED);
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setQuestion(position,"B");
                op1.setEnabled(false);
                op3.setEnabled(false);
                op4.setEnabled(false);
                if(questions.getCorrect().equals("B")){
                    op2.setTextColor(Color.GREEN);
                    correct_ans++;
                }
                else
                    op2.setTextColor(Color.RED);
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setQuestion(position,"C");
                op1.setEnabled(false);
                op2.setEnabled(false);
                op4.setEnabled(false);
                if(questions.getCorrect().equals("C")){
                    op3.setTextColor(Color.GREEN);
                    correct_ans++;
                }
                else
                    op3.setTextColor(Color.RED);
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setQuestion(position,"D");
                op1.setEnabled(false);
                op2.setEnabled(false);
                op3.setEnabled(false);
                if(questions.getCorrect().equals("D")){
                    op4.setTextColor(Color.GREEN);
                    correct_ans++;
                }
                else
                    op4.setTextColor(Color.RED);
            }
        });
        if(position == 9){
            next.setVisibility(View.INVISIBLE);
            prev.setVisibility(View.INVISIBLE);
            finish.setVisibility(View.VISIBLE);
        }
        else {
            next.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);
            finish.setVisibility(View.INVISIBLE);
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
            }
        });
        if(position>0) {
            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
                }
            });
        }else {
            prev.setEnabled(false);
        }
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(QuizActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(QuizActivity.this);
                }
                builder.setTitle("Score Card: ")
                        .setMessage("You Scored "+correct_ans+" marks.")
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                                finish();
                            }
                        })
                        .show();
            }
        });
    }
}
