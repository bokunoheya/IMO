package com.example.projectimo;

import android.text.Editable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserData {

    public static String mUsEmail;
    public static String mUsName;
    public static String mUsId;

    public static void Vf(){
        String mUserEmail;
        String mUserName;
        String mUserId;
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
        {
            mUserEmail = user.getEmail(); //Эл. почта пользователя
            mUserName = user.getEmail();
            mUserId = user.getUid();
            mUsEmail=mUserEmail;
            mUsName=mUserName;
            mUsId=mUserId;
        }
    }
}
