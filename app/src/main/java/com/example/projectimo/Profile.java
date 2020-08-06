package com.example.projectimo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.projectimo.UserData.mUsEmail;
import static com.example.projectimo.UserData.mUsId;
import static com.example.projectimo.UserData.mUsName;


public class Profile extends Fragment {

    Button button4;
TextView getText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_profile, container, false);
        getText=root.findViewById(R.id.get_text);
        /*-------------------------------------*/
        UserData.Vf();
        getText.setText(mUsName); //Вывод эл. почты
        /*-------------------------------------*/
        button4=root.findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(),Login.class));
                Toast.makeText(getActivity(),"Exit", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}