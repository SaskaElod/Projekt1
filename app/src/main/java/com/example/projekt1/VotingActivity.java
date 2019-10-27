package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Button;

import static android.app.PendingIntent.getActivity;
import static android.view.View.GONE;

public class VotingActivity extends AppCompatActivity {

    DatabaseFull myDB;
    Button votebutton;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    String vote,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        recyclerView=findViewById(R.id.vote_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        adapter = new Adapter(this,data);
        recyclerView.setAdapter(adapter);
        name=getIntent().getExtras().getString("username");
        //Log.d("aaaa",name);
        votebutton=findViewById(R.id.vote_button);
        adapter.setClickListener(new Adapter.ItemClickListener() {
            @Override
            public void onItemClick(String text) {
                vote=text;
            }
        });
        votebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votebutton.setVisibility(GONE);
                FragmentManager fm=getSupportFragmentManager();
                ScoresFragment fragment=ScoresFragment.newInstance(vote,name);
                fm.beginTransaction().replace(R.id.container,fragment).commit();
            }
        });
    }

    public void addData(){
        votebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                votebutton.setVisibility(GONE);

            }
        });
    }


}
