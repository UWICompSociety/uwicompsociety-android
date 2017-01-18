package com.uwimonacs.computingsociety.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.EditText;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.models.ForumPost;
import com.uwimonacs.computingsociety.util.ScreenUtils;

public class CreateForumPostActivity extends AppCompatActivity {
    private View root, revealCenter;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private EditText title, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_forum_post_2);

        initViews();

        setUpViews();

        setUpActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.post:
                createPost();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if(!TextUtils.isEmpty(title.getText().toString()) ||
                !TextUtils.isEmpty(message.getText().toString())){
            ScreenUtils.showDialog(this, "Discard post", "Your post will be discarded",
                    "Leave", "Stay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            CreateForumPostActivity.super.onBackPressed();
                        }
                    }, null);
        }
        else
            super.onBackPressed();
    }

    private void initViews(){
        root = findViewById(R.id.activity_create_forum_post);
        revealCenter = findViewById(R.id.reveal_center);
        title = (EditText) findViewById(R.id.title);
        message = (EditText) findViewById(R.id.message);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setUpViews(){

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ScreenUtils.circularReveal(revealCenter, root, 500, new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    root.setBackgroundColor(ContextCompat.getColor(
                            CreateForumPostActivity.this, android.R.color.white));

                    CreateForumPostActivity.this.getWindow()
                            .setBackgroundDrawable(new ColorDrawable(ContextCompat
                                    .getColor(CreateForumPostActivity.this, android.R.color.white)));
                }
            });
        } else {
            root.setBackgroundColor(ContextCompat.getColor(
                    CreateForumPostActivity.this, android.R.color.white));

            getWindow()
                    .setBackgroundDrawable(new ColorDrawable(ContextCompat
                            .getColor(CreateForumPostActivity.this, android.R.color.white)));
        }

        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(TextUtils.isEmpty(charSequence))
                    actionBar.setTitle("Make a Post");
                else
                    actionBar.setTitle(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @SuppressWarnings("ConstantConditions")
    private void setUpActionBar(){
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void createPost(){
        if(TextUtils.isEmpty(title.getText().toString())){
            Snackbar.make(root, "A title is required", Snackbar.LENGTH_LONG).show();
            return;
        } else if(TextUtils.isEmpty(message.getText().toString())){
            Snackbar.make(root, "Write some text", Snackbar.LENGTH_LONG).show();
            return;
        }

        ForumPost post = new ForumPost(0, 0, title.getText().toString(),
                "01/01/2017 at 12:00pm", message.getText().toString(),
                0, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("post_id", post.getForum_id());
        ScreenUtils.makeSharedElementTransition(this, ForumPostActivity.class,
                bundle, true, title, message);
    }
}
