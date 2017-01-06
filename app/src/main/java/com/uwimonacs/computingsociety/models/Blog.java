package com.uwimonacs.computingsociety.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jourdanDunkley on 1/6/2017.
 */
@Table(name="Blog")
public class Blog extends Model {

    @Column(name="blog_id")
    private int blog_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="date")
    private String date;

    @Column(name="topic")
    private String topic;

    @Column(name="num_posts")
    private int num_posts;

    public Blog(){}
    public Blog(int blog_id, int user_id, String date, String topic, int num_posts){
        this.blog_id = blog_id;
        this.user_id = user_id;
        this.date = date;
        this.topic = topic;
        this.num_posts = num_posts;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public Blog setBlog_id(int blog_id) {
        this.blog_id = blog_id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public Blog setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Blog setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public Blog setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public int getNum_posts() {
        return num_posts;
    }

    public Blog setNum_posts(int num_posts) {
        this.num_posts = num_posts;
        return this;
    }
}
