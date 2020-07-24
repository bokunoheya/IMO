package com.example.projectimo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Type2 extends Fragment {
    TextView progress, attendance, homework, result;
    int pValue=4; //Успеваемость
    int aValue=3; //Посещяемость
    int hValue=6; //Д/З
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
        return root;
    }
}