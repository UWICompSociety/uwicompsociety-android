package com.uwimonacs.computingsociety.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.adapters.BlogPostCommentAdapter;
import com.uwimonacs.computingsociety.constants.CommentType;
import com.uwimonacs.computingsociety.models.Blog;
import com.uwimonacs.computingsociety.models.BlogPost;
import com.uwimonacs.computingsociety.models.Comment;

import java.util.ArrayList;

/**
 * Created by Doneil Scotland on 14/01/2017.
 */

@SuppressWarnings("ConstantConditions")
public class NewsItemActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView image, btnLike, btnDislike;
    private TextView title, message, date, numLikes, numDislikes;
    private EditText replyEditText;
    private FloatingActionButton replyButton;
    private RecyclerView comments;
    private NestedScrollView scrollView;
    private BlogPostCommentAdapter adapter;
    private BlogPost post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);

        initViews();

        setUpViews();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initViews(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        image = (ImageView) findViewById(R.id.image1);
        btnLike = (ImageView) findViewById(R.id.btn_like);
        btnDislike = (ImageView) findViewById(R.id.btn_dislike);
        title = (TextView) findViewById(R.id.newstitle);
        message = (TextView) findViewById(R.id.news_message);
        date = (TextView) findViewById(R.id.post_date);
        numLikes = (TextView) findViewById(R.id.num_like);
        numDislikes = (TextView) findViewById(R.id.num_dislike);
        replyEditText = (EditText) findViewById(R.id.reply_edittext);
        replyButton = (FloatingActionButton) findViewById(R.id.reply_button);
        comments = (RecyclerView) findViewById(R.id.comments);
        scrollView = (NestedScrollView) findViewById(R.id.scrollview);
        adapter = new BlogPostCommentAdapter(this, new ArrayList<Comment>());
//        post = BlogPost.getPost(getIntent().getIntExtra("post_id", 0));
        post = sampleBlogPost();
    }

    private void setUpViews(){
        setUpActionBar();

        populateViews();

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

        setUpRecyclerView();
    }

    private void setUpActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Blog blog = Blog.getBlog(post.getBlog_id());
        Blog blog = sampleBlog();
        getSupportActionBar().setTitle(blog.getTopic());
    }

    private void populateViews(){
        Picasso.with(this).load(post.getImageUrl()).into(image);
        title.setText(post.getTitle());
        message.setText(post.getMessage());
        date.setText(post.getDate());
        numLikes.setText(String.valueOf(post.getNum_likes()));
        numDislikes.setText(String.valueOf(post.getNum_dislikes()));
    }

    private void setUpRecyclerView(){
        comments.setLayoutManager(new LinearLayoutManager(this));
        comments.setAdapter(adapter);
        comments.setNestedScrollingEnabled(false);
    }

    private void handleComment(){
        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = replyEditText.getText().toString();
                if(!TextUtils.isEmpty(reply)){
                    replyEditText.setText("");
                    adapter.add(new Comment(adapter.getItemCount(), 0, CommentType.BLOGPOST_COMMENT,
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

    @NonNull
    private BlogPost sampleBlogPost(){
        return new BlogPost(0, 0, 0, "Lorem Ipsum",
                "07/01/2017 at 12:00pm",
                getString(R.string.lorem_ipsum_text_double),
                "http://www.walltor.com/images/wallpaper/lorem-ipsum-3179.jpg",
                0, 5, 0);
    }

    @NonNull
    private Blog sampleBlog(){
        return new Blog(0, 0, "07/01/2017 at 12:00pm",
                "Android development", 1);
    }
}

