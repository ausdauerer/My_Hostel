package com.example.hostel2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LaundaryHomeRecyclerViewAdapter extends RecyclerView.Adapter<LaundaryHomeRecyclerViewAdapter.ViewHolder>{

    private Context context;
    private ArrayList<LaundaryJob> arrayList;

    public LaundaryHomeRecyclerViewAdapter(Context context,ArrayList<LaundaryJob> stringList){
        this.context=context;
        this.arrayList=stringList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView submission_date;
        private final TextView laundary_id;
        private final TextView status;
        private final View card;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            card=view;
            submission_date = (TextView) view.findViewById(R.id.laundary_home_card_text_view_submission_date);
            status= (TextView) view.findViewById(R.id.laundary_home_card_text_view_status);
            laundary_id=(TextView) view.findViewById(R.id.laundary_home_card_text_view_laundary_id);
        }
        public TextView getSubmissionDateTextView() {
            return submission_date;
        }
        public TextView getLaundaryIdTextView(){
            return laundary_id;
        }
        public TextView getStatusTextView(){
            return status;
        }
        public View getCardView(){ return card;}
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.laundary_home_recycler_view_card_layout, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        // to set data to textview and imageview of each card layout
        LaundaryJob job = arrayList.get(position);
        TextView submission_date=viewHolder.getSubmissionDateTextView();
        TextView status=viewHolder.getStatusTextView();
        TextView laundary_id=viewHolder.getLaundaryIdTextView();
        View cardView=viewHolder.getCardView();

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data=new Bundle();
                data.putInt("laundary_id",job.job_id);
                data.putString("status",job.status);
                data.putInt("no_of_clothes",job.number_of_clothes);
                data.putString("laundary_name",job.laundary_name);
                data.putString("submission_date",job.submission_date);
                data.putString("delivery_date",job.delivery_date);
                Navigation.findNavController(view).navigate(R.id.action_laundaryHomeFragment_to_expandedLaundaryJob,data);
            }
        });
        submission_date.setText(job.submission_date);
        laundary_id.setText(String.valueOf(job.job_id));
        status.setText(job.status);

        if(job.status.compareTo("Completed") == 0){
            status.setBackgroundColor(ContextCompat.getColor(context, R.color.completed_green));
        }
        else if(job.status.compareTo("Processing") == 0){
            status.setBackgroundColor(ContextCompat.getColor(context, R.color.processing_yellow));
        }
        else{
            status.setBackgroundColor(ContextCompat.getColor(context, R.color.pending_red));
        }
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
