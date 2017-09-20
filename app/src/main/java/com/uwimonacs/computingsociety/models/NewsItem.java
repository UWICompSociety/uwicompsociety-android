package com.uwimonacs.computingsociety.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;


/**
 * @author sultanofcardio
 * This class represents a news item in the system. News items will be posted by admin users.
 * TODO: Document
 */
@Table(name="NewsItem")
public class NewsItem extends Model {


    @Column(name="news_id")
    private int news_id;

    @Column(name="user_id")
    private int user_id;

    @Column(name="title")
    private String title;

    @Column(name="summary")
    private String summary;

    @Column(name="date")
    private String date;

    @Column(name="body")
    private String body;

    @Column(name="image_url")
    private String image_url;

    @Column(name="num_comments")
    private int num_comments;

    @Column(name="num_likes")
    private int num_likes;

    @Column(name="num_dislikes")
    private int num_dislikes;

    public NewsItem() {
        super();
    }

    public NewsItem(int news_id, int user_id, String title, String summary, String date,
                    String body, String image_url, int num_comments) {
        this.news_id = news_id;
        this.user_id = user_id;
        this.title = title;
        this.summary = summary;
        this.date = date;
        this.body = body;
        this.image_url = image_url;
        this.num_comments = num_comments;
    }

    public int getNews_id() {
        return news_id;
    }

    public NewsItem setNews_id(int news_id) {
        this.news_id = news_id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public NewsItem setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NewsItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public NewsItem setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDate() {
        return date;
    }

    public NewsItem setDate(String date) {
        this.date = date;
        return this;
    }

    public String getBody() {
        return body;
    }

    public NewsItem setBody(String body) {
        this.body = body;
        return this;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public NewsItem setNum_comments(int num_comments) {
        this.num_comments = num_comments;
        return this;
    }

    public String getImage_url() {
        return image_url;
    }

    public NewsItem setImage_url(String image_url) {
        this.image_url = image_url;
        return this;
    }

    public int getNum_likes() {
        return num_likes;
    }

    public void setNum_likes(int num_likes) {
        this.num_likes = num_likes;
    }

    public int getNum_dislikes() {
        return num_dislikes;
    }

    public void setNum_dislikes(int num_dislikes) {
        this.num_dislikes = num_dislikes;
    }

    public String getImageUrl() {
        return image_url;
    }

    public String getMessage() {
        return body;
    }
}
