package com.uwimonacs.computingsociety.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;

/**
 * Created by jawil on 12/1/2017.
 */

public class UserProfileActivity extends AppCompatActivity {
    private TextView name, email, username, github_username, blogs, discussions, projects;
    private ActionBar actionBar;
    private FloatingActionButton floatingActionButton;
    private ImageView facebook, snapchat, github, linked, insta, twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        initViews();

        setUpViews();
    }

    private void initViews(){
        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        username = (TextView)findViewById(R.id.username);
        github_username = (TextView)findViewById(R.id.github_username);
        blogs = (TextView)findViewById(R.id.view_blogs);
        discussions = (TextView)findViewById(R.id.view_discussions);
        projects = (TextView)findViewById(R.id.view_projects);

        facebook = (ImageView)findViewById(R.id.facebook_icon);
        snapchat = (ImageView)findViewById(R.id.snapchat_icon);
        github = (ImageView)findViewById(R.id.github_icon);
        linked = (ImageView)findViewById(R.id.linkedin_icon);
        insta = (ImageView)findViewById(R.id.instagram_icon);
        twitter = (ImageView)findViewById(R.id.twitter_icon);

        actionBar = getSupportActionBar();

        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);

        facebook = (ImageView)findViewById(R.id.f)
    }

    private void setUpViews(){
        name.setText("John Doe");
        email.setText("jDoe@examole.com");
        username.setText("JDizzle");
        github_username.setText("JH_Doe");
        actionBar.setHomeButtonEnabled(true);

        setUpListners();
    }

    private void setUpListners(){

        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.fab:
                        //TODO: uncomment when EditProfileActivity class is implemented
                        /*Intent intent = new Intent(this, EditProfileActivity.class);
                        startActivity(intent);*/
                        break;
                    case R.id.view_blogs:
                        //TODO: implement blog click listener
                        break;
                    case R.id.view_discussions:
                        //TODO: implement discussions listener
                        break;
                    case R.id.view_projects:
                        //TODO: implement project listener
                        break;
                    case R.id.snapchat_icon:
                        //TODO implement snapchat listener
                        break;
                    case R.id.facebook_icon:
                        //TODO implement facebook listener
                        break;
                    case R.id.twitter_icon:
                        //TODO implement twitter listener
                        break;
                    case R.id.linkedin_icon:
                        //TODO implement linkedin listener
                        break;
                    case R.id.github_icon:
                        //TODO implement github listener
                        break;
                    default:
                        break;
                }
            }
        };

        TextView [] textListners = {blogs, projects, discussions};
        ImageView [] imgListeners = {facebook, snapchat, insta, github, twitter, linked};

        floatingActionButton.setOnClickListener(onClick);

        for(TextView textView : textListners){
            textView.setOnClickListener(onClick);
        }

        for(ImageView imageView : imgListeners){
            imageView.setOnClickListener(onClick);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if (menuItem.getItemId()== android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
