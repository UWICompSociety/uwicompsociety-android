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
import com.uwimonacs.computingsociety.adapters.BlogAdapter;
import com.uwimonacs.computingsociety.models.BlogPost;

import java.util.ArrayList;

/**
 * @author sultanofcardio
 */

public class BlogFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private BlogAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag_blog_list, container, false);

        initViews();

        setUpViews();

        return view;
    }

    public void initViews(){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        adapter = new BlogAdapter(new ArrayList<BlogPost>(), getContext());
    }

    public void setUpViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

}
