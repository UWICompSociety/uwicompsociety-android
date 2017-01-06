package com.uwimonacs.computingsociety.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jourdanDunkley on 1/6/2017.
 */

@Table(name="BlogPost")
public class BlogPost extends Model{

    @Column(name="post_id")
    private int post_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="blog_id")
    private int blog_id;

    @Column(name="title")
    private String title;

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

    public BlogPost(){}
    public BlogPost(int post_id, int user_id, int blog_id, String title, String date, String message,
                    int num_comments, int num_likes, int num_dislikes){
        this.post_id = post_id;
        this.user_id = user_id;
        this.blog_id = blog_id;
        this.title = title;
        this.date = date;
        this.message = message;
        this.num_comments = num_comments;
        this.num_likes = num_likes;
        this.num_dislikes = num_dislikes;
    }

    public int getPost_id() {
        return post_id;
    }

    public BlogPost setPost_id(int post_id) {
        this.post_id = post_id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public BlogPost setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public BlogPost setBlog_id(int blog_id) {
        this.blog_id = blog_id;
        return this;
    }

    public String getDate() {
        return date;
    }

    public BlogPost setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BlogPost setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BlogPost setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public BlogPost setNum_comments(int num_comments) {
        this.num_comments = num_comments;
        return this;
    }

    public int getNum_likes() {
        return num_likes;
    }

    public BlogPost setNum_likes(int num_likes) {
        this.num_likes = num_likes;
        return this;
    }

    public int getNum_dislikes() {
        return num_dislikes;
    }

    public BlogPost setNum_dislikes(int num_dislikes) {
        this.num_dislikes = num_dislikes;
        return this;
    }
}
