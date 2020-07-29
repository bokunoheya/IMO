package com.example.projectimo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Attendance extends Fragment {
    CalendarView calendarView;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_attendance, container, false);
        textView= root.findViewById(R.id.editTextDate);
        calendarView=root.findViewById(R.id.calendarView2);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
      /*      @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                int mYear=year;
                int mMonth=month;
                int mDay=dayOfMonth;
                String selectedDate=new StringBuilder().append(mMonth+1).append("-").append(mDay).append("-").append(mYear).append(" ").toString();

                textView.setText(selectedDate);
            }*/

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int mYear=year;
                int mMonth=month;
                int mDay=dayOfMonth;
                String selectedDate=new StringBuilder().append(mDay).append("-").append(mMonth+1).append("-").append(mYear).toString();

                textView.setText(selectedDate);
            }
        });

        return root;
    }
}