package com.example.hostel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class ExpandedLaundaryJob extends Fragment {

    public ExpandedLaundaryJob() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(),"The Id sent was "+getArguments().getInt("laundary_id"),Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_expanded_laundary_job, container, false);
    }
}