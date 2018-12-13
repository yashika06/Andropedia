package com.android.yashika.andropedia.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.yashika.andropedia.Activity.SubTutorialActivity;
import com.android.yashika.andropedia.Model.SubTutorial;
import com.android.yashika.andropedia.Model.Tutorials;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yashika on 06-07-2017.
 */

public class TutorialFragmentAdapter extends RecyclerView.Adapter<TutorialFragmentAdapter.ViewHolder> {

    private Context context;
    private int resource;
    ArrayList<Tutorials> contents;
    FragmentManager manager;

    public TutorialFragmentAdapter(Context context, int resource, ArrayList<Tutorials> contents, FragmentManager manager) {
        this.context = context;
        this.resource = resource;
        this.contents = contents;
        this.manager = manager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.title.setText(contents.get(position).getTitle());
        List<String> descList = new ArrayList<>();
        Iterator<SubTutorial> iterator = contents.get(position).getSubTutorials().iterator();
        while (iterator.hasNext()){
            descList.add(iterator.next().getTitle());
        }
        String desc_text = TextUtils.join(", ",descList);
        holder.desc.setText(desc_text);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("ARRAYLIST",contents);
                Intent intent = new Intent(context, SubTutorialActivity.class);
                intent.putExtra("POSITION",position);
                intent.putExtra("BUNDLE",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView title;
        TextView desc;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.tutorial_card_view);
            title = (TextView) itemView.findViewById(R.id.tutorial_textview);
            desc = (TextView) itemView.findViewById(R.id.tutorial_desc_textview);
        }
    }
}
