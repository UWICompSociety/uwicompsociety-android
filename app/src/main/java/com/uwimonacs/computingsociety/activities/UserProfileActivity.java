package com.uwimonacs.computingsociety.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.util.ScreenUtils;

/**
 * Created by jawil on 12/1/2017.
 */

public class UserProfileActivity extends AppCompatActivity {
    private TextView name, email, username, github_username;
    private CardView blogs, discussions, projects;
    private ActionBar actionBar;
    private Toolbar toolbar;
    private FloatingActionButton floatingActionButton;
    private ImageView avatar;
    private ImageView facebook, snapchat, github, linked, insta, twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        initViews();

        setUpViews();
    }

    private void initViews(){
        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        username = (TextView)findViewById(R.id.username);
        github_username = (TextView)findViewById(R.id.github_username);
        blogs = (CardView) findViewById(R.id.view_blogs);
        discussions = (CardView) findViewById(R.id.view_discussions);
        projects = (CardView) findViewById(R.id.view_projects);

        avatar = (ImageView) findViewById(R.id.avatar);
        facebook = (ImageView)findViewById(R.id.facebook_icon);
        snapchat = (ImageView)findViewById(R.id.snapchat_icon);
        github = (ImageView)findViewById(R.id.github_icon);
        linked = (ImageView)findViewById(R.id.linkedin_icon);
        insta = (ImageView)findViewById(R.id.instagram_icon);
        twitter = (ImageView)findViewById(R.id.twitter_icon);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();

        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
    }

    private void setUpViews(){
        name.setText("John Doe");
        email.setText("jDoe@examole.com");
        username.setText("JDizzle");
        github_username.setText("JH_Doe");
        actionBar.setDisplayHomeAsUpEnabled(true);

        setUpListners();
    }

    private void setUpListners(){

        View.OnClickListener onClick = new View.OnClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.fab:
                        ScreenUtils.makeSharedElementTransition(UserProfileActivity.this,
                                EditProfileActivity.class, null, false, avatar);
                        break;
                    case R.id.view_blogs:
                        startActivity(new Intent(UserProfileActivity.this, BlogActivity.class));
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

        CardView [] cardViews = {blogs, projects, discussions};
        ImageView [] imgListeners = {facebook, snapchat, insta, github, twitter, linked};

        floatingActionButton.setOnClickListener(onClick);

        for(CardView cardView : cardViews){
            cardView.setOnClickListener(onClick);
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
