package com.example.projekt1;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class ScoresFragment extends Fragment {

    private DatabaseFull db;
    String score,name;
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Onedata> datas;

    public ScoresFragment() {
        // Required empty public constructor
    }

    public static ScoresFragment newInstance(String text,String name){
        ScoresFragment scoresFragment=new ScoresFragment();
        Bundle data = new Bundle();
        data.putString("vote",text);
        data.putString("username",name);
        scoresFragment.setArguments(data);
        return scoresFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //score=getArguments().getString("vote");
        //name=getArguments().getString("username");
//        Log.d("aaaaaaa",score);
        //recyclerView= getView().findViewById(R.id.recyclerviewscores);
        //recyclerView.findViewById(R.id.recyclerviewscores);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //db=new DatabaseFull(getContext());
       // datas=db.getAllData();
        //adapter=new MyRecyclerViewAdapter(this,datas);
        //Log.d("aaaaaaaaaa",datas);
        //Log.d("bbbbbbbbb",name);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_scores, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerviewscores);
        //db=new DatabaseFull(getContext());
        //datas=db.getAllData();
    }
}
