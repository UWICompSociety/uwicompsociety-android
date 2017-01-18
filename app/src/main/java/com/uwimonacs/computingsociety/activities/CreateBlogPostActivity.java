package com.uwimonacs.computingsociety.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
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
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.models.BlogPost;
import com.uwimonacs.computingsociety.util.ScreenUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class CreateBlogPostActivity extends AppCompatActivity {
    private View root;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private ImageView banner, cameraButton;
    private EditText title, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_blog_post);

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
                            CreateBlogPostActivity.super.onBackPressed();
                        }
                    }, null);
        }
        else
            super.onBackPressed();
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==RESULT_OK) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                File file = new File(getFilesDir(), "BlogPosts");
                File photo = new File(new File(getFilesDir(), "BlogPosts"), "photo.jpg");

                file.mkdirs();
                if(!photo.exists())
                    photo.createNewFile();
                FileOutputStream output = new FileOutputStream(photo);
                byte[] buffer = new byte[1024 * 100];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    output.write(Arrays.copyOfRange(buffer, 0, Math.max(0, len)));
                }
                inputStream.close();
                output.close();

                Picasso.with(this).invalidate(photo);
                Picasso.with(this).load(photo).into(banner);
                banner.setAlpha((float) 1);

            } catch (IOException | NullPointerException e) {
                Snackbar.make(root, "An error occurred. Try again later", Snackbar.LENGTH_LONG).show();
            }

        }
    }

    private void initViews(){
        root = findViewById(R.id.activity_create_forum_post);
        banner = (ImageView) findViewById(R.id.banner);
        cameraButton = (ImageView) findViewById(R.id.camera_button);
        title = (EditText) findViewById(R.id.title);
        message = (EditText) findViewById(R.id.message);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setUpViews(){
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

        View.OnClickListener bannerListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/");
                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                startActivityForResult(chooserIntent, 0);
            }
        };

        banner.setOnClickListener(bannerListener);
        cameraButton.setOnClickListener(bannerListener);
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

        BlogPost post = new BlogPost(0, 0, 0, title.getText().toString(),
                "01/01/2017 at 12:00pm", message.getText().toString(), "",
                0, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("post_id", post.getBlog_id());
        ScreenUtils.makeSharedElementTransition(this, BlogPostActivity.class,
                bundle, true, banner, title, message);
    }
}
