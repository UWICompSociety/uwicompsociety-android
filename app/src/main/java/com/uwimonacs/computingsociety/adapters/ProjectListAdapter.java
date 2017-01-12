package com.uwimonacs.computingsociety.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.models.Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jawil on 9/1/2017.
 */

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectHolder>{

    private List<Project> projects;
    private Context context;

    public ProjectListAdapter(Context context, List<Project> projects){
        this.projects = projects;
        this.context = context;

        initProjects();
    }

    @Override
    public ProjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProjectHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ProjectHolder holder, int position) {
        Project project = projects.get(position);

        holder.name.setText(project.getName());
        holder.description.setText(project.getDescription());
        holder.link.setText(project.getLink());

    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ProjectHolder extends RecyclerView.ViewHolder {
        TextView name, description, link;

        public ProjectHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.project_title);
            description = (TextView)itemView.findViewById(R.id.project_description);
            link = (TextView)itemView.findViewById(R.id.read_more);
        }
    }

    public void update(List<Project> projects){
        this.projects = projects;
        notifyDataSetChanged();
    }

    protected void initProjects(){
        List<Project> projects = new ArrayList<Project>();

        int [] project_ids = {001,002,003};
        String [] project_names = {"OurVLE Mobile", "FSAT Map", "Computing Society Web"};
        String [] project_descriptions = {context.getString(R.string.lorem_ipsum_text),
                context.getString(R.string.lorem_ipsum_text),
                context.getString(R.string.lorem_ipsum_text)};

        String [] project_links = {context.getString(R.string.read_more),
                context.getString(R.string.read_more),
                context.getString(R.string.read_more)};

        List<Integer> user_ids = new ArrayList<>(Arrays.asList(Integer.parseInt("111"),
                Integer.parseInt("112"),
                Integer.parseInt("113")));

        for(int i=0;i<3;i++){
            Project project = new Project(project_ids[i],user_ids,project_names[i],project_descriptions[i],project_links[i]);
            projects.add(project);
        }

        this.projects = projects;
    }
}
