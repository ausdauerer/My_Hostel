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

public class LaundaryHomeListViewAdapter extends ArrayAdapter<LaundaryJob> {

    public LaundaryHomeListViewAdapter(Context context, ArrayList<LaundaryJob> arrayList){
        super(context,0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView=convertView;
        if(convertView==null){
            currentView= LayoutInflater.from(getContext()).inflate(R.layout.laundary_home_list_view_item,parent,false);
        }
        LaundaryJob job=getItem(position);
        ((TextView)currentView.findViewById(R.id.laundary_home_list_view_laundary_id)).setText(String.valueOf(job.job_id));
        ((TextView)currentView.findViewById(R.id.laundary_home_list_view_status)).setText(job.status);
        ((TextView)currentView.findViewById(R.id.laundary_home_list_view_submission_date)).setText(job.submission_date);
        return currentView;
    }
}
