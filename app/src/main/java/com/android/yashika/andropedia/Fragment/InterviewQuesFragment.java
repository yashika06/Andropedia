package com.android.yashika.andropedia.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.yashika.andropedia.Activity.InterviewQuesActivity;
import com.android.yashika.andropedia.R;



public class InterviewQuesFragment extends Fragment {

    Button view_ques;
    public InterviewQuesFragment() {
        // Required empty public constructor
    }

  public static InterviewQuesFragment newInstance(){
      return new InterviewQuesFragment();
  }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_interview_ques, container, false);
        view_ques = (Button) view.findViewById(R.id.view_ques);
        view_ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InterviewQuesActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
