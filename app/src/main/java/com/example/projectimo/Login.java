package com.example.projectimo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText mFullName, mEmail, mPassword,mPhone;
    Button mLogin;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    public String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail=findViewById(R.id.eMail);
        mPassword=findViewById(R.id.password);
        mLogin=findViewById(R.id.loginBtn);
        fAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        if (user != null)
        {
            String e = user.getEmail();
            name = user.getDisplayName();
            Bundle bundle = new Bundle();
            bundle.putString("message", e );

        }

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }



        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                if(password.length()<6){
                    mPassword.setError("Must be >= 6 characters");
                    return;
                }
                progressBar.setVisibility(view.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "User Login", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(Login.this,"Error:", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(view.INVISIBLE);
                        }
                    }
                });
            }
        });

    }


}
   /* Bundle bundle = new Bundle();
String myMessage = "Stackoverflow is cool!";
    bundle.putString("message", myMessage );
    FragmentClass fragInfo = new FragmentClass();
    fragInfo.setArguments(bundle);
    transaction.replace(R.id.fragment_single, fragInfo);
    transaction.commit();*/