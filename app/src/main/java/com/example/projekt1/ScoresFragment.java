package com.example.projekt1;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {

    private DatabaseFull db;
    String score,name;
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

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
        score=getArguments().getString("vote");
        name=getArguments().getString("username");
        db=new DatabaseFull(getContext());
        //Log.d("aaaaaaaaaa",score);
        //Log.d("bbbbbbbbb",name);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scores, container, false);
    }

}
