package com.uwimonacs.computingsociety.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.adapters.NewsListAdapter;
import com.uwimonacs.computingsociety.models.NewsItem;

import java.util.ArrayList;

/**
 * Created by jawil on 13/1/2017.
 */

public class NewsListFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private NewsListAdapter newsListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_news_feed, container, false);

        initViews();

        setUpViews();

        return view;
    }

    public void initViews(){
        recyclerView = (RecyclerView) view.findViewById(R.id.news_recycler);
        newsListAdapter = new NewsListAdapter(new ArrayList<NewsItem>(), getContext());
    }

    public void setUpViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsListAdapter);
    }
}
