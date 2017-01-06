package com.uwimonacs.computingsociety.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * @author sultanofcardio
 * This class represents a Computing Society project (such as this one) in the system.
 * TODO: Document
 */
@Table(name="Project")
public class Project extends Model {

    @Column(name="project_id")
    private int project_id;

    @Column(name="user_ids")
    private List<Integer> user_ids;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="link")
    private String link;

    public Project() {
    }

    public Project(int project_id, List<Integer> user_ids, String name, String description, String link) {
        this.project_id = project_id;
        this.user_ids = user_ids;
        this.name = name;
        this.description = description;
        this.link = link;
    }

    public int getProject_id() {
        return project_id;
    }

    public Project setProject_id(int project_id) {
        this.project_id = project_id;
        return this;
    }

    public List<Integer> getUser_ids() {
        return user_ids;
    }

    public Project setUser_ids(List<Integer> user_ids) {
        this.user_ids = user_ids;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Project setLink(String link) {
        this.link = link;
        return this;
    }
}
