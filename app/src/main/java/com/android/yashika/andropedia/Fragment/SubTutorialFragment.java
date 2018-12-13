package com.android.yashika.andropedia.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.yashika.andropedia.Adapter.SubtutorialFragmentAdapter;
import com.android.yashika.andropedia.Model.Tutorials;
import com.android.yashika.andropedia.R;

import java.util.ArrayList;


public class SubTutorialFragment extends Fragment {

    RecyclerView recyclerView;
    SubtutorialFragmentAdapter adapter;
    static ArrayList<Tutorials> dataList;
    int position;
    public SubTutorialFragment() {
        // Required empty public constructor
    }
    public static SubTutorialFragment newInstance(int position, ArrayList<Tutorials> list){
        SubTutorialFragment fragment = new SubTutorialFragment();
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",list);
        args.putInt("KEY_POSITION",position);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.dataList = (ArrayList<Tutorials>) getArguments().getSerializable("ARRAYLIST");
            this.position = getArguments().getInt("KEY_POSITION");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_tutorial, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.subtutorial_recycler_view);
        adapter = new SubtutorialFragmentAdapter(getActivity(),R.layout.list_item_subtutorial,dataList.get(position).getSubTutorials());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }


}
