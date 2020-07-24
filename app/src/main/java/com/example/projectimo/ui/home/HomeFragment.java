package com.example.projectimo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.projectimo.R;

public class HomeFragment extends Fragment {
    Button imageButton, button2, button3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        imageButton= root.findViewById(R.id.button);
        imageButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.blankFragment, null));
        button2= root.findViewById(R.id.button2);
        button2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.type1, null));
        button3= root.findViewById(R.id.button3);
        button3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.type2, null));
        return root;
    }
}