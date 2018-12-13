package com.android.yashika.andropedia.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.yashika.andropedia.Activity.InterviewAnsActivity;
import com.android.yashika.andropedia.Model.Interview_ques;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;

/**
 * Created by Yashika on 19-07-2017.
 */

public class InterviewListAdapter extends RecyclerView.Adapter<InterviewListAdapter.ViewHolder> {
    private Context context;
    private int resource;
    private ArrayList<Interview_ques> interview_quesArrayList;
    public static final String Interview_List = "interview_ques";
    public static final String POSITION = "interview_position";
    public InterviewListAdapter( Context context, int resource, ArrayList<Interview_ques> objects) {
        this.context=context;
        this.resource=resource;
        this.interview_quesArrayList=objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(interview_quesArrayList.get(position).getQues());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InterviewAnsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Interview_List,interview_quesArrayList);
                intent.putExtra("BUNDLE",bundle);
                intent.putExtra(POSITION,position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return interview_quesArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.interview_card_view);
            textView = (TextView) itemView.findViewById(R.id.inter_ques_textview);
        }
    }
}
