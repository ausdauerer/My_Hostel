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
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AttendanceHomeFragment extends Fragment {
    private View view;
    private MainActivityViewModel model;
    private SwipeRefreshLayout swipeContainer;
    private AttendanceHomeListViewAdapter adapter;
    private ListView listView;
    public AttendanceHomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_attendance_home, container, false);
        swipeContainer=view.findViewById(R.id.attendance_home_swipe_refresh_fragment);
        listView=(ListView) view.findViewById(R.id.attendance_home_list_view);
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
        model.getAttendanceList().observe(requireActivity(), new Observer<ArrayList<AttendanceLog>>() {
            @Override
            public void onChanged(ArrayList<AttendanceLog> attendanceList) {
                adapter.notifyDataSetChanged();
            }
        });

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                model.refreshAttendanceData();
                swipeContainer.setRefreshing(false);
            }
        });
    }
    public void initRecyclerView(){
        adapter=new AttendanceHomeListViewAdapter(getActivity(),model.getAttendanceList().getValue());
        listView.setAdapter(adapter);
    }

}