package com.example.projectimo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BlankFragment extends Fragment {
    TextView progress, attendance, homework, result;
    Button butAttendance, butProgress, butHomework;
    int pValue=1; //Успеваемость
    int aValue=2; //Посещяемость
    int hValue=3; //Д/З
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_blank, container, false);
        progress=root.findViewById(R.id.progress);
        progress.setText(Integer.toString(pValue));
        attendance=root.findViewById(R.id.attendance);
        attendance.setText(Integer.toString(aValue));
        homework=root.findViewById(R.id.homework);
        homework.setText(Integer.toString(hValue));
        result=root.findViewById(R.id.result);
        result.setText(Integer.toString(pValue+aValue+hValue)); //Итого

        butAttendance= root.findViewById(R.id.butAttendance);
        butAttendance.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.attendance));
        butProgress= root.findViewById(R.id.butProgress);
        butProgress.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.progress));
        return root;
    }
}