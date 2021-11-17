package com.example.hostel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class AddLaundaryJobFragment extends Fragment {

    private Spinner name_spinner;
    private Spinner no_of_cl_spinner;
    private View view;
    private MainActivityViewModel model;
    private String[] laundaries={"Laundary A","Laundary B","Laundary C"};
    private String[] no_of_clothes_options={"1","2","3","4","5","6"};
    public AddLaundaryJobFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_add_laundary_job, container, false);
        model= new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        name_spinner=v.findViewById(R.id.add_laundary_laundary_name);
        no_of_cl_spinner=v.findViewById(R.id.add_laundary_number_of_clothes);
        ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,laundaries);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter no_of_cl_arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,no_of_clothes_options);
        no_of_cl_arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        no_of_cl_spinner.setAdapter(no_of_cl_arrayAdapter);
        name_spinner.setAdapter(arrayAdapter);

        (v.findViewById(R.id.add_laundary_job_submit_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.SubmitLaundaryJob(name_spinner.getSelectedItem().toString(),Integer.parseInt(no_of_cl_spinner.getSelectedItem().toString()));
            }
        });
        return v;
    }


}