package com.example.hostel2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

public class AttendanceHomeListViewAdapter extends ArrayAdapter<AttendanceLog> {

    public AttendanceHomeListViewAdapter(Context context, ArrayList<AttendanceLog> arrayList){
        super(context,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView=convertView;
        if(convertView==null){
            currentView= LayoutInflater.from(getContext()).inflate(R.layout.attendance_home_list_view_item,parent,false);
        }
        AttendanceLog atlog=getItem(position);
        ((TextView)currentView.findViewById(R.id.attendance_home_list_view_date)).setText(atlog.date);
        ((TextView)currentView.findViewById(R.id.attendance_home_list_view_status)).setText(atlog.status);
        return currentView;
    }
}
