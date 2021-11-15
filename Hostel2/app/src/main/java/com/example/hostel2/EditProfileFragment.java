package com.example.hostel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class EditProfileFragment extends Fragment {
    TextView nameField;
    TextView emailField;
    TextView phoneField;
    TextView addressField;
    Button submitButton;
    View view;
    MainActivityViewModel model;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_edit_profile, container, false);
        nameField=view.findViewById(R.id.edit_profile_name_field);
        phoneField=view.findViewById(R.id.edit_phone_number_field);
        addressField=view.findViewById(R.id.edit_address_field);
        emailField=view.findViewById(R.id.edit_email_field);
        submitButton=view.findViewById(R.id.update_profile_button);
        model= new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        Profile pp=model.getProfile().getValue();
        nameField.setText(pp.name);
        phoneField.setText(pp.phone);
        addressField.setText(pp.address);
        emailField.setText(pp.email);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile temp=new Profile(nameField.getText().toString(),emailField.getText().toString(),phoneField.getText().toString(),addressField.getText().toString());
                model.updateProfile(temp);
                Toast.makeText(getActivity(),"Successfully updated your profile", Toast.LENGTH_LONG).show();
                Navigation.findNavController(view).navigate(R.id.action_editProfileFragment_to_myProfileFragment);
                Navigation.findNavController(view).popBackStack(R.id.editProfileFragment,true);
            }
        });
        return(view);
    }
}