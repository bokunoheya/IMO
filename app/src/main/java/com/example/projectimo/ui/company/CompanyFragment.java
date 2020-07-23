package com.example.projectimo.ui.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.projectimo.R;

public class CompanyFragment extends Fragment {

    private CompanyViewModel companyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        companyViewModel =
                ViewModelProviders.of(this).get(CompanyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_company, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        companyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}