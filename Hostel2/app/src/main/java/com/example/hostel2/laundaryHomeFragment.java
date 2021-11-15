package com.example.hostel2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class laundaryHomeFragment extends Fragment {
    private View view;
    private MainActivityViewModel model;
    private SwipeRefreshLayout swipeContainer;
    private LaundaryHomeRecyclerViewAdapter adapter;
    private RecyclerView rv;
    public laundaryHomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_laundary_home, container, false);
        swipeContainer=view.findViewById(R.id.laundary_home_swipe_refresh_fragment);
        rv=(RecyclerView) view.findViewById(R.id.laundary_home_recycler_view);
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
        initRecyclerView();
        model.getLaundaryJobs().observe(requireActivity(), new Observer<ArrayList<LaundaryJob>>() {
            @Override
            public void onChanged(ArrayList<LaundaryJob> laundaryJobs) {
                adapter.notifyDataSetChanged();
            }
        });

        view.findViewById(R.id.laundary_home_add_job_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_laundaryHomeFragment_to_addLaundaryJobFragment);
            }
        });
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                model.refreshData();
                swipeContainer.setRefreshing(false);
            }
        });
    }
    public void initRecyclerView(){
        adapter=new LaundaryHomeRecyclerViewAdapter(getActivity(),model.getLaundaryJobs().getValue());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}