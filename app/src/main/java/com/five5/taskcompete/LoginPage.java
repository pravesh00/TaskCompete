package com.five5.taskcompete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage extends AppCompatActivity {
    TextView reg;
    Button loginButton;
    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    DatabaseReference ref;
    EditText emailLogin , passLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        reg=(TextView)findViewById(R.id.txtRegister);
        emailLogin=(EditText)findViewById(R.id.txtLoginEmail);
        passLogin=(EditText)findViewById(R.id.txtLoginPass);
        mAuth= FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance();
        //FirebaseUser user=mAuth.getCurrentUser();
        //if(user!=null){
           // startActivity(new Intent(LoginPage.this, navigator_home.class));

        //}
        ref=mDatabase.getReference().child("Users");
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this,Register_user.class));
            }
        });
        loginButton=(Button) findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }

    public void login() {

        String txtEmail=emailLogin.getText().toString();
        String txtPass=emailLogin.getText().toString();
        



            mAuth.signInWithEmailAndPassword(txtEmail, txtPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()) {
                       Toast.makeText(getApplicationContext(), "Login Succesfull", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(LoginPage.this, navigator_home.class));

                    } else {
                       Toast.makeText(getApplicationContext(), "Login not Succesfull", Toast.LENGTH_SHORT).show();

                    }
                }


            });
        }



}