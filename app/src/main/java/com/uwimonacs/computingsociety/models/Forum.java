package com.uwimonacs.computingsociety.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jourdaDunkley on 1/6/2017.
 */
@Table(name="Forum")
public class Forum extends Model {

    @Column(name="forum_id")
    private int forum_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="topic")
    private String topic;

    @Column(name="date")
    private String date;

    @Column(name="message")
    private String message;

    @Column(name="num_comments")
    private int num_comments;

    @Column(name="num_likes")
    private int num_likes;

    @Column(name="num_dislikes")
    private int num_dislikes;

    public Forum(){}
    public Forum(int forum_id, int user_id, String topic, String date, String message, int num_comments,
                 int num_likes, int num_dislikes){
        this.forum_id = forum_id;
        this.user_id = user_id;
        this.topic = topic;
        this.date = date;
        this.message = message;
        this.num_comments = num_comments;
        this.num_likes = num_likes;
        this.num_dislikes = num_dislikes;
    }

    public int getForum_id() {
        return forum_id;
    }

    public Forum setForum_id(int forum_id) {
        this.forum_id = forum_id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public Forum setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public Forum setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Forum setDate(String date) {
        this.date = date;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Forum setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public Forum setNum_comments(int num_comments) {
        this.num_comments = num_comments;
        return this;
    }

    public int getNum_likes() {
        return num_likes;
    }

    public Forum setNum_likes(int num_likes) {
        this.num_likes = num_likes;
        return this;
    }

    public int getNum_dislikes() {
        return num_dislikes;
    }

    public Forum setNum_dislikes(int num_dislikes) {
        this.num_dislikes = num_dislikes;
        return this;
    }
}
