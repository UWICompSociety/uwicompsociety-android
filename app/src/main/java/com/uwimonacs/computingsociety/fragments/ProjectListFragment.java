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
    private Context context;
    private View view;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
        view = inflater.inflate(R.layout.project_list, container, false);

        init();

        return view;
    }

    private void init() {
        projectListView = (RecyclerView)view.findViewById(R.id.project_recycler);
        projectListAdapter = new ProjectListAdapter(getProjects());
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());

        projectListView.setAdapter(projectListAdapter);
        projectListView.setLayoutManager(manager);
    }

    private void setContext(Context context){
        this.context = context;
    }

    protected List<Project> getProjects(){
        List<Project> projects = new ArrayList<Project>();

        int [] project_ids = {001,002,003};
        String [] project_names = {"OurVLE Mobile", "FSAT Map", "Computing Society Web"};
        String [] project_descriptions = {getText(R.string.lorem_ipsum_text).toString(), getText(R.string.lorem_ipsum_text).toString(), getText(R.string.lorem_ipsum_text).toString()};
        String [] project_links = {getText(R.string.read_more).toString(), getText(R.string.read_more).toString(), getText(R.string.read_more).toString()};
        List<Integer> user_ids = new ArrayList<>(Arrays.asList(Integer.parseInt("111"),Integer.parseInt("112"),Integer.parseInt("113")));

        for(int i=0;i<3;i++){
            Project project = new Project(project_ids[i],user_ids,project_names[i],project_descriptions[i],project_links[i]);
            projects.add(project);
        }

        return projects;
    }
}
