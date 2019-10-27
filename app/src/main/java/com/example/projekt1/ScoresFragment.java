package com.example.projekt1;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ScoresFragment extends Fragment {

    String score,name;
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

    private TextView username;
    private TextView question;
    private TextView answer;
    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        score=getArguments().getString("vote");
        name=getArguments().getString("username");
        //Log.d("aaaaaaaaaa",score);
        //Log.d("bbbbbbbbb",name);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recylerView);
        username = (TextView)view.findViewById(R.id.username);
        question = (TextView)view.findViewById(R.id.question);
        answer = (TextView)view.findViewById(R.id.answer);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mListadapter);

        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
    {
        private ArrayList<Quest> dataList;

        public ListAdapter(ArrayList<Quest> data)
        {
            this.dataList = data;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView textViewText;
            TextView textViewComment;
            TextView textViewDate;

            public ViewHolder(View itemView)
            {
                super(itemView);
                this.textViewText = (TextView) itemView.findViewById(R.id.username);
                this.textViewComment = (TextView) itemView.findViewById(R.id.question);
                this.textViewDate = (TextView) itemView.findViewById(R.id.answer);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_scores, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
        {
            holder.textViewText.setText(dataList.get(position).getText());
            holder.textViewComment.setText(dataList.get(position).getQuestion());
            holder.textViewDate.setText(dataList.get(position).getAnswer());

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(), "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return dataList.size();
        }
    }



}
