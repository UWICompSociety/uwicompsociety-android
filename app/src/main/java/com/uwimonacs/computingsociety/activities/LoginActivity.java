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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;


/**
 * Created by Doneil Scotland on 12/01/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private View root1, forgotpass, createacc;
    private EditText email, password;
    private LinearLayout button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        setupViews();
    }

    public void initViews() {
        root1 = findViewById(R.id.root1);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        forgotpass = findViewById(R.id.forgot_password);
        createacc = findViewById(R.id.create_account);
        button = (LinearLayout) findViewById(R.id.sign_in_button);
    }

    public void setupViews() {
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View button) {
                processInformation();
            }
        });
        //Launches Create-Account Activity
        createacc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View createacc){
                Intent i = new Intent(LoginActivity.this, CreateAccountActivity.class);
                startActivity(i);
                finish();
            }
        }
        );
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_NULL || i == EditorInfo.IME_ACTION_DONE){
                    processInformation();
                    return true;
                } else
                    return false;
            }
        });

    }

    public void processInformation() {
        //Gets text from the EditTexts
        String email_var = email.getText().toString();
        String password_var = password.getText().toString();

        //Checks whether or not EditTexts are empty and creates snack-bars where necessary
        if (TextUtils.isEmpty(email_var))
            Snackbar.make(root1, "Email is required", Snackbar.LENGTH_LONG).show();
        else if (TextUtils.isEmpty(password_var))
            Snackbar.make(root1, "Password is required", Snackbar.LENGTH_LONG).show();
        else {
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
            finish();
        }
    }

}