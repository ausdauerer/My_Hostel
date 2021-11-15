package com.example.hostel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class laundaryHomeFragment extends Fragment {
    public laundaryHomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_laundary_home, container, false);
        ArrayList<LaundaryJob> laund = new ArrayList<LaundaryJob>();
        laund.add(new LaundaryJob(15874,51258,"2021-03-01",null,"Laundary A","Pending",5));
        laund.add(new LaundaryJob(15369,98541,"2021-01-14",null,"Laundary A","Processing",1));
        laund.add(new LaundaryJob(13987,14587,"2021-05-01",null,"Laundary B","Completed",3));
        laund.add(new LaundaryJob(14785,87462,"2021-08-03","2021-08-05","Laundary A","Delivered",6));
        laund.add(new LaundaryJob(15879,98541,"2021-01-15","2021-01-18","Laundary C","Delivered",7));
        laund.add(new LaundaryJob(15874,51258,"2021-03-01",null,"Laundary A","Pending",5));
        laund.add(new LaundaryJob(15369,98541,"2021-01-14",null,"Laundary A","Processing",1));
        laund.add(new LaundaryJob(13987,14587,"2021-05-01",null,"Laundary B","Completed",3));
        laund.add(new LaundaryJob(14785,87462,"2021-08-03","2021-08-05","Laundary A","Delivered",6));
        laund.add(new LaundaryJob(15879,98541,"2021-01-15","2021-01-18","Laundary C","Delivered",7));
        RecyclerView rv=(RecyclerView) v.findViewById(R.id.laundary_home_recycler_view);
        LaundaryHomeRecyclerViewAdapter adapter=new LaundaryHomeRecyclerViewAdapter(getActivity(),laund);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        v.findViewById(R.id.laundary_home_add_job_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_laundaryHomeFragment_to_addLaundaryJobFragment);
            }
        });
        return v;
    }
}