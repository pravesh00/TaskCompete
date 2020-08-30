package com.five5.taskcompete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.five5.taskcompete.Data.User_data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_user extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    DatabaseReference ref;
    Button btnRegister;
    EditText txtName,txtPass,txtEmail,txtConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        mAuth=FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance();
        ref=mDatabase.getReference().child("Users");
        intializeUI();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }

            private void register() {
                final String strEmail=txtEmail.getText().toString();
                ref.child("i").setValue("uiop");
                final String strName=txtName.getText().toString();
                final String strPass=txtPass.getText().toString();
                String strConfirmPass=txtConfirmPass.getText().toString();
                int a=0;
                if(!strPass.equals(strConfirmPass)){
                    Toast.makeText(getApplicationContext(),"Passwords doesn't match",Toast.LENGTH_SHORT).show();
                    a=1;
                }
                if(strEmail.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Check Email",Toast.LENGTH_SHORT).show();
                    a=1;
                }
                if(strName.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Check Name",Toast.LENGTH_SHORT).show();
                    a=1;
                }
                if(strPass.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Check Password",Toast.LENGTH_SHORT).show();
                    a=1;
                }
                if(a==0){
                    mAuth.createUserWithEmailAndPassword(strEmail,strPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Registeration Succesfull",Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Toast.makeText(getApplicationContext(),"User Already exists or Invalid Crediatianls",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private void intializeUI() {
        btnRegister=(Button)findViewById(R.id.btnRegister);
        txtEmail=(EditText)findViewById(R.id.txtEmailRegister);
        txtName=(EditText)findViewById(R.id.txtNameRegister);
        txtPass=(EditText)findViewById(R.id.txtPassRegister);
        txtConfirmPass=(EditText)findViewById(R.id.txtConfirmPassRegister);

    }
}