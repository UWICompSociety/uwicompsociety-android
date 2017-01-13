package com.uwimonacs.computingsociety.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.uwimonacs.computingsociety.R;

/**
 * Created by Doneil Scotland on 09/01/2017.
 */

public class CreateAccountActivity extends AppCompatActivity {
    private View root, haveAnAccount;
    private EditText email, username, password, passwordConfirm;
    private LinearLayout button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        initViews();

        setUpViews();
    }

    public void initViews(){
        root = findViewById(R.id.root);
        haveAnAccount = findViewById(R.id.have_an_account);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.password_confirm);
        button = (LinearLayout) findViewById(R.id.sign_in_button);
    }

    public void setUpViews(){
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View button) {
                processInformation();
            }
        });

        passwordConfirm.setImeActionLabel("Create", KeyEvent.KEYCODE_ENTER);

        passwordConfirm.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_NULL || i == EditorInfo.IME_ACTION_DONE){
                    processInformation();
                    return true;
                } else
                    return false;
            }
        });

        haveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                startActivity(myIntent);
                finish();
            }
        });
    }

    public void processInformation(){
        String email_var = email.getText().toString();
        String username_var = username.getText().toString();
        String password_var = password.getText().toString();
        String password_confirm = passwordConfirm.getText().toString();

        if(TextUtils.isEmpty(email_var))
            Snackbar.make(root, "Email is required", Snackbar.LENGTH_LONG).show();
        else if(TextUtils.isEmpty(username_var))
            Snackbar.make(root, "Username is required", Snackbar.LENGTH_LONG).show();
        else if(TextUtils.isEmpty(password_var))
            Snackbar.make(root, "Password is required", Snackbar.LENGTH_LONG).show();
        else if(!password_confirm.equals(password_var))
            Snackbar.make(root, "Passwords don't match", Snackbar.LENGTH_LONG).show();
        else {
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);

            // Finish the activity so pressing the back button doesn't come back here
            finish();
        }
    }
}