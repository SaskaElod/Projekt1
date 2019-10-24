package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Button;

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
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        adapter = new Adapter(this,data);
        recyclerView.setAdapter(adapter);
        votebutton=findViewById(R.id.vote_button);
        votebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
