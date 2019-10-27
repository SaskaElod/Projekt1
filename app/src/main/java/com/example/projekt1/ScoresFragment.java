package com.example.projekt1;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoresFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private DatabaseFull db;

    public ScoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // recyclerView=recyclerView.findViewById(R.id.my_recylerView);
      //  recyclerView.setHasFixedSize(true);

        //recyclerView.setLayoutManager(layoutManager);


        return inflater.inflate(R.layout.fragment_scores, container, false);
    }

}
