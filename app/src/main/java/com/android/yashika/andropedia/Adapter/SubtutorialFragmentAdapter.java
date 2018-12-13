package com.android.yashika.andropedia.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.yashika.andropedia.Activity.TutorialWebviewActivity;
import com.android.yashika.andropedia.Model.SubTutorial;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;

/**
 * Created by Yashika on 07-07-2017.
 */

public class SubtutorialFragmentAdapter extends RecyclerView.Adapter<SubtutorialFragmentAdapter.ViewHolder> {

    private Context context;
    private int resource;
    private ArrayList<SubTutorial> content;

    public SubtutorialFragmentAdapter(Context context, int resource, ArrayList<SubTutorial> content) {
        this.context = context;
        this.resource = resource;
        this.content = content;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textView.setText(content.get(position).getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, TutorialWebviewActivity.class);
                intent.putExtra("SUB_TUTORIAL_FILE",content.get(position).getFilename());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.subtutorial_textview);
            cardView = (CardView) itemView.findViewById(R.id.subtutorial_card_view);
        }
    }
}
