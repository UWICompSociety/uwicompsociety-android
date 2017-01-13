package com.uwimonacs.computingsociety.fragments;

import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.adapters.MembersListAdapter;
import com.uwimonacs.computingsociety.models.Member;
import com.uwimonacs.computingsociety.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jourdanDunkley on 1/9/2017.
 */
public class MembersListFragment extends Fragment {

    private View view;
    private MembersListAdapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.members_list, container, false);
        initViews();
        setUpViews();
        return view;
    }

    public void initViews(){
        recyclerView = (RecyclerView) view.findViewById(R.id.memberRecycler);
        adapter = new MembersListAdapter(new ArrayList<User>(), getContext());
    }

    public void setUpViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}









