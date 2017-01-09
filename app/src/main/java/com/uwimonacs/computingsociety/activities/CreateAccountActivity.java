package com.uwimonacs.computingsociety.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import static android.support.design.widget.Snackbar.make;

/**
 * Created by Doneil Scotland on 09/01/2017.
 */

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        //Views are initialised
        final EditText email = this.findViewById(R.id.email);
        final EditText username = this.findViewById(R.id.username);
        final EditText password = this.findViewById(R.id.password);
        final LinearLayout button = findViewById(R.id.create_account_button);

        //Operations are performed on views
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View button) {
                String email_var=email.getText().toString();
                String username_var=username.getText().toString();
                String password_var=password.getText().toString();
                if(email_var.equals("") || username_var.equals("") || password_var.equals("")){
                    String text="One or more fields have been left empty.";
                    make(button,text, Snackbar.LENGTH_INDEFINITE);
                }
                Intent myIntent = new Intent(CreateAccountActivity.this, MainActivity.class);
                CreateAccountActivity.this.startActivity(myIntent);
            }
    });
}
}