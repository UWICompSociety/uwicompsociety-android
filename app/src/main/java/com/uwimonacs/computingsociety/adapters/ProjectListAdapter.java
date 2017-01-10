package com.uwimonacs.computingsociety.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.models.Project;

import java.util.List;

/**
 * Created by jawil on 9/1/2017.
 */

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectHolder>{

    List<Project> projects;

    public ProjectListAdapter(List<Project> projects){this.projects = projects;}

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
}
