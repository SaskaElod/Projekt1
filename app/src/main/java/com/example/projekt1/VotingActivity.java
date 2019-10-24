package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Adapter;
import android.widget.Button;

import static android.view.View.GONE;

public class VotingActivity extends AppCompatActivity {

    Button votebutton;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        recyclerView=findViewById(R.id.vote_recyclerView);

        votebutton=findViewById(R.id.vote_button);
        votebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votebutton.setVisibility(GONE);
                FragmentManager fm=getSupportFragmentManager();
                ScoresFragment fragment=new ScoresFragment();
                fm.beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
    }
}
