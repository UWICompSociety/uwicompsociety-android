package com.uwimonacs.computingsociety.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.adapters.ProjectListAdapter;
import com.uwimonacs.computingsociety.models.Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jawil on 9/1/2017.
 */

public class ProjectListFragment extends Fragment {

    private ProjectListAdapter projectListAdapter;
    private RecyclerView projectListView;
    private View view;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
        view = inflater.inflate(R.layout.project_list, container, false);

        init();

        setUpViews();

        return view;
    }

    private void init() {
        projectListView = (RecyclerView)view.findViewById(R.id.project_recycler);
        projectListAdapter = new ProjectListAdapter(getContext(), new ArrayList<Project>());
    }

    private void setUpViews(){
        projectListView.setAdapter(projectListAdapter);
        projectListView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
