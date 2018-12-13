package com.android.yashika.andropedia.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.yashika.andropedia.Activity.QuizActivity;
import com.android.yashika.andropedia.R;


public class QuizFragment extends Fragment {

    Button start_quiz;
    public QuizFragment() {
        // Required empty public constructor
    }

    public static QuizFragment newInstance(){
        return new QuizFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        start_quiz = (Button) view.findViewById(R.id.start_quiz);
        start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),QuizActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
