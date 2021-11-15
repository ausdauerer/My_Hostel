package com.example.hostel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MyProfileFragment extends Fragment {

    private View view;
    private Profile profile;
    private MainActivityViewModel model;
    public MyProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_my_profile, container, false);
        initializeNavigation();
        initializeData();
        return view;
    }
    public void initializeNavigation(){
        ((Button) view.findViewById(R.id.edit_profile_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_myProfileFragment_to_editProfileFragment);
            }
        });
    }
    public void initializeData(){
        model= new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        Profile p=model.getProfile().getValue();
        ((TextView)view.findViewById(R.id.profile_fragment_name)).setText(p.name);
        ((TextView)view.findViewById(R.id.profile_fragment_email)).setText(p.email);
        ((TextView)view.findViewById(R.id.profile_fragment_phone)).setText(p.phone);
        ((TextView)view.findViewById(R.id.profile_fragment_address)).setText(p.address);
    }
}