package com.uwimonacs.computingsociety.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * @author sultanofcardio
 * This class represents a user comment in the system. This may be a comment on a news item,
 * in the discussion forum, on a user's blog or another item that allows comments.
 * TODO: Document
 */
@Table(name="Comment")
public class Comment extends Model {

    @Column(name="comment_id")
    private int comment_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="type")
    private int type;

    @Column(name="parent_id")
    private int parent_id;

    @Column(name="message")
    private String message;

    @Column(name="date")
    private String date;

    @Column(name="num_likes")
    private int num_likes;

    @Column(name="num_dislikes")
    private int num_dislikes;

    public Comment() {
    }

    public Comment(int comment_id, int user_id, int type, int parent_id, String message, String date, int num_likes, int num_dislikes) {
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.type = type;
        this.parent_id = parent_id;
        this.message = message;
        this.date = date;
        this.num_likes = num_likes;
        this.num_dislikes = num_dislikes;
    }

    public int getComment_id() {
        return comment_id;
    }

    public Comment setComment_id(int comment_id) {
        this.comment_id = comment_id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public Comment setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public int getType() {
        return type;
    }

    public Comment setType(int type) {
        this.type = type;
        return this;
    }

    public int getParent_id() {
        return parent_id;
    }

    public Comment setParent_id(int parent_id) {
        this.parent_id = parent_id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Comment setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Comment setDate(String date) {
        this.date = date;
        return this;
    }

    public int getNum_likes() {
        return num_likes;
    }

    public Comment setNum_likes(int num_likes) {
        this.num_likes = num_likes;
        return this;
    }

    public int getNum_dislikes() {
        return num_dislikes;
    }

    public Comment setNum_dislikes(int num_dislikes) {
        this.num_dislikes = num_dislikes;
        return this;
    }
}
