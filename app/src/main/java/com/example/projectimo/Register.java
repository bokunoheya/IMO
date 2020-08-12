package com.example.projectimo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.snapshot.ValueIndex;

import static android.view.View.INVISIBLE;

public class Register extends AppCompatActivity {
    static EditText mFullName;
    EditText mEmail;
    EditText mPassword;
    EditText mPhone;
    static String m;
Button mRegister;
FirebaseAuth fAuth;
ProgressBar progressBar;
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRef = database.getReference("Name");
    DatabaseReference myRef2 = database.getReference("Phone");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName=findViewById(R.id.fullName);
        mEmail=findViewById(R.id.eMail);
        mPassword=findViewById(R.id.password);
        mPhone=findViewById(R.id.phone);
        mRegister=findViewById(R.id.registerBtn);
        fAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mEmail.setError("Password is Required");
                    return;
                }
                if(password.length()<6){
                    mPassword.setError("Must be >= 6 characters");
                    return;
                }
                progressBar.setVisibility(view.VISIBLE);
                myRef.setValue(mFullName.getText().toString().trim());
                myRef2.setValue(mPhone.getText().toString().trim());

                myRef.child("it-tiwrno").child("Name").addValueEventListener(new ValueEventListener() {
                                                                                  @Override
                                                                                  public void onDataChange(DataSnapshot snapshot){
                                                                                      if (snapshot.getValue() != null) {
                                                                                          String n = (String) snapshot.getValue();
                                                                                          m=n;
                                                                                      }
                                                                                  }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Register.this,"Error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(INVISIBLE);
                        }
                    }
                });
            }
        });
    }

    public void Click(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
    }
}