package com.uwimonacs.computingsociety;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.uwimonacs.computingsociety.models.Blog;
import com.uwimonacs.computingsociety.models.BlogPost;
import com.uwimonacs.computingsociety.models.Comment;
import com.uwimonacs.computingsociety.models.ForumPost;
import com.uwimonacs.computingsociety.models.Member;
import com.uwimonacs.computingsociety.models.NewsItem;
import com.uwimonacs.computingsociety.models.Project;
import com.uwimonacs.computingsociety.models.User;

/**
 * Created by stone on 9/20/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Configuration dbConfiguration = new Configuration.Builder(this)
                .setDatabaseName("compsci.db")
                .setDatabaseVersion(1)
                .addModelClass(NewsItem.class)
                .addModelClass(Blog.class)
                .addModelClass(BlogPost.class)
                .addModelClass(Comment.class)
                .addModelClass(ForumPost.class)
                .addModelClass(Member.class)
                .addModelClass(Project.class)
                .addModelClass(User.class)
                .create();
        ActiveAndroid.initialize(dbConfiguration);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
