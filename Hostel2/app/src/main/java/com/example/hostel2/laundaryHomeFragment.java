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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class laundaryHomeFragment extends Fragment {
    private View view;
    private MainActivityViewModel model;
    private SwipeRefreshLayout swipeContainer;
    private LaundaryHomeListViewAdapter adapter;
    private ListView listView;
    private Spinner sortSpinner;
    private ArrayList<String> sortOptions;
    public laundaryHomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_laundary_home, container, false);
        swipeContainer=view.findViewById(R.id.laundary_home_swipe_refresh_fragment);
        listView=(ListView) view.findViewById(R.id.laundary_home_list_view);
        sortSpinner=(Spinner)view.findViewById(R.id.laundary_home_list_view_sort_spinner);
        sortOptions=new ArrayList<String>();
        sortOptions.add("ID");
        sortOptions.add("Date");
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
                model.refreshLaundaryData();
                swipeContainer.setRefreshing(false);
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,sortOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter(adapter);
        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String option=sortOptions.get(position);
                if(option.compareTo("ID")==0){
                    model.sortLaundaryListById();
                }
                if(option.compareTo("Date")==0){
                    model.sortLaundaryListByDate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
    public void initRecyclerView(){
        adapter=new LaundaryHomeListViewAdapter(getActivity(),model.getLaundaryJobs().getValue());
        listView.setAdapter(adapter);
    }
}