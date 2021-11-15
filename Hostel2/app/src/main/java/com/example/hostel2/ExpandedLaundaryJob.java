package com.example.hostel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class ExpandedLaundaryJob extends Fragment {

    View v;
    public ExpandedLaundaryJob() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Toast.makeText(getActivity(),"The Id sent was "+getArguments().getInt("laundary_id"),Toast.LENGTH_LONG).show();
        v=inflater.inflate(R.layout.fragment_expanded_laundary_job, container, false);
        return v;
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle data=getArguments();
        ((TextView) v.findViewById(R.id.expanded_laundary_status)).setText(data.getString("status"));
        ((TextView) v.findViewById(R.id.expanded_laundary_submission_date)).setText(data.getString("submission_date"));
        ((TextView) v.findViewById(R.id.expanded_laundary_delivery_date)).setText(data.getString("delivery_date"));
        ((TextView) v.findViewById(R.id.expanded_laundary_no_of_clothes)).setText(String.valueOf(data.getInt("no_of_clothes")));
        ((TextView) v.findViewById(R.id.expanded_laundary_job_id)).setText(String.valueOf(data.getInt("laundary_id")));
        ((TextView) v.findViewById(R.id.expanded_laundary_laundary_name)).setText(data.getString("laundary_name"));
    }
}