package com.uwimonacs.computingsociety.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.util.ScreenUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class EditProfileActivity extends AppCompatActivity {

    private EditText name, email, username, gitusername, fb_url, twitter_url, ig_url, linkedIn_url, snapchat_url, github_url;
    private ActionBar actionbar;
    private ImageView avatar, cameraButton;
    private String Name, Email, Username, GitUsername, Facebook,
            Twitter, Instagram, LinkedIn, Snapchat, Github;
    private CoordinatorLayout root;
    private Toolbar toolbar;
    private boolean change = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initViews();
        setUpViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit_profile, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(anyChanges()){
            ScreenUtils.showDialog(EditProfileActivity.this, "Unsaved changes",
                    "Your changes will be discarded. Do you wish to proceed?", "Yes", "No",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            EditProfileActivity.super.onBackPressed();
                        }
                    }, null);
        } else
            super.onBackPressed();
    }

    private void initViews() {
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        username = (EditText)findViewById(R.id.username);
        gitusername = (EditText)findViewById(R.id.github_username);
        fb_url = (EditText)findViewById(R.id.facebook_url);
        twitter_url = (EditText)findViewById(R.id.twitter_url);
        ig_url = (EditText)findViewById(R.id.instagram_url);
        linkedIn_url = (EditText)findViewById(R.id.linkedin_url);
        snapchat_url = (EditText)findViewById(R.id.snapchat_url);
        github_url = (EditText)findViewById(R.id.github_url);
        avatar = (ImageView)findViewById(R.id.avatar);
        cameraButton = (ImageView)findViewById(R.id.camera_button);
        root = (CoordinatorLayout)findViewById(R.id.edit);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void setUpViews(){
        setUpActionBar();

        getAllText();

        View.OnClickListener choosePhoto = new View.OnClickListener() {
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

        avatar.setOnClickListener(choosePhoto);
        cameraButton.setOnClickListener(choosePhoto);

    }

    @SuppressWarnings("ConstantConditions")
    private void setUpActionBar(){
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    private void getAllText() {
        Name = name.getText().toString().trim();
        Email = email.getText().toString().trim();
        Username = username.getText().toString().trim();
        GitUsername = gitusername.getText().toString().trim();
        Facebook = fb_url.getText().toString().trim();
        Twitter = twitter_url.getText().toString().trim();
        Instagram = ig_url.getText().toString().trim();
        LinkedIn = linkedIn_url.getText().toString().trim();
        Snapchat = snapchat_url.getText().toString().trim();
        Github = github_url.getText().toString().trim();
    }

    private boolean anyChanges(){
        if(!Name.equals(name.getText().toString().trim()) ||
           !Email.equals(email.getText().toString().trim()) ||
           !Username.equals(username.getText().toString().trim()) ||
           !GitUsername.equals(gitusername.getText().toString().trim()) ||
           !Facebook.equals(fb_url.getText().toString().trim()) ||
           !Twitter.equals(twitter_url.getText().toString().trim()) ||
           !Instagram.equals(ig_url.getText().toString().trim()) ||
           !LinkedIn.equals(linkedIn_url.getText().toString().trim()) ||
           !Snapchat.equals(snapchat_url.getText().toString().trim()) ||
           !Github.equals(github_url.getText().toString().trim()))
                change = true;

        return change;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if (menuItem.getItemId()== android.R.id.home) {
            onBackPressed();
            return true;
        }
        else if (menuItem.getItemId() == R.id.save) {
            Snackbar.make(root, "Changes saved", Snackbar.LENGTH_LONG).show();
            getAllText();
            finish();
            return true;
        }
        else
            return super.onOptionsItemSelected(menuItem);
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==RESULT_OK) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                File file = new File(getFilesDir(), "Profile");
                File photo = new File(new File(getFilesDir(), "Profile"), "photo.jpg");

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
                Picasso.with(this).load(photo).into(avatar);

                change = true;
            } catch (IOException | NullPointerException e) {
                Snackbar.make(root, "An error occurred. Try again later", Snackbar.LENGTH_LONG).show();
            }

        }
    }

}
