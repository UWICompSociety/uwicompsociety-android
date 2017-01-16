package com.uwimonacs.computingsociety.activities;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.adapters.ForumPostCommentAdapter;
import com.uwimonacs.computingsociety.constants.CommentType;
import com.uwimonacs.computingsociety.models.Comment;
import com.uwimonacs.computingsociety.models.ForumPost;

import java.util.ArrayList;

public class ForumPostActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ForumPostCommentAdapter adapter;
    private NestedScrollView scrollView;
    private TextView title, name, message, date, numLikes, numDislikes;
    private ImageView avatar, btnLike, btnDislike;
    private ForumPost post;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_post);

        initViews();

        setUpViews();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return false;
        }
    }

    private void initViews(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        scrollView = (NestedScrollView) findViewById(R.id.scroll_view);
        title = (TextView) findViewById(R.id.title);
        name = (TextView) findViewById(R.id.name);
        message = (TextView) findViewById(R.id.message);
        date = (TextView) findViewById(R.id.date);
        numLikes = (TextView) findViewById(R.id.num_like);
        numDislikes = (TextView) findViewById(R.id.num_dislike);
        comment = (EditText) findViewById(R.id.comment);
        avatar = (ImageView) findViewById(R.id.avatar);
        btnLike = (ImageView) findViewById(R.id.btn_like);
        btnDislike = (ImageView) findViewById(R.id.btn_dislike);
        post = new ForumPost(0, 0, "I need help with an assignment",
                "01/01/2017 at 12:00pm",
                getString(R.string.lorem_ipsum_text),
                0, 0, 0);
    }

    private void setUpViews(){
        setUpActionBar();

        populateViews();

        setListeners();

        setUpRecyclerView();
    }

    private void setUpActionBar(){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(post.getTopic());
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @SuppressLint("SetTextI18n")
    private void populateViews(){
        title.setText(post.getTopic());
        name.setText("John Doe");
        message.setText(post.getMessage());
        date.setText(post.getDate());
        numLikes.setText("0");
        numDislikes.setText("0");
    }

    private void setListeners(){
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Launch user profile activity
                Snackbar.make(view, "Coming soon", Snackbar.LENGTH_LONG).show();
            }
        });

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Launch user profile activity
                Snackbar.make(view, "Coming soon", Snackbar.LENGTH_LONG).show();
            }
        });

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Fix bug with multiple likes + un-liking
                int likes = post.getNum_likes() + 1;
                post.setNum_likes(likes);
                numLikes.setText(String.valueOf(likes));
            }
        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Fix bug with multiple dislikes + un-disliking
                int dislikes = post.getNum_dislikes() + 1;
                post.setNum_dislikes(dislikes);
                numDislikes.setText(String.valueOf(dislikes));
            }
        });

        handleComment();
    }

    private void setUpRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ForumPostCommentAdapter(this, new ArrayList<Comment>());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    private void handleComment(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = comment.getText().toString();
                if(!TextUtils.isEmpty(reply)){
                    comment.setText("");
                    adapter.add(new Comment(adapter.getItemCount(), 0, CommentType.FORUMPOST_COMMENT,
                            0, reply, "01/01/2017 at 12:00pm", 0, 0));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(View.FOCUS_DOWN);
                        }
                    }, 100);
                }
            }
        });
    }
}
