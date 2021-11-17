package com.example.hostel2;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel{
    private MutableLiveData<ArrayList<LaundaryJob>> mLaundaryJobs;
    private MutableLiveData<ArrayList<AttendanceLog>> mAttendanceList;
    private MutableLiveData<Profile> mUserProfile;
    private DataRepository mRepo;

    public void initializeData(){
        if(mLaundaryJobs!=null){
            return;
        }
        mRepo=DataRepository.getInstance();
        mLaundaryJobs=mRepo.getLaundaryDataList();
        mAttendanceList=mRepo.getAttendanceDataList();
        mUserProfile=mRepo.getUserProfile();
    }

    public void updateProfile(Profile profile){
        mUserProfile.setValue(profile);
        //Do async operation to the server
    }

    public void refreshLaundaryData(){
        mLaundaryJobs.setValue(mRepo.getLaundaryDataList().getValue());
    }

    public void refreshAttendanceData(){
        mAttendanceList.setValue(mRepo.getAttendanceDataList().getValue());
    }

    public LiveData<ArrayList<LaundaryJob>> getLaundaryJobs(){
        return(mLaundaryJobs);
    }

    public LiveData<ArrayList<AttendanceLog>> getAttendanceList() {return(mAttendanceList);}

    public LiveData<Profile> getProfile(){
        return(mUserProfile);
    }

    public void SubmitLaundaryJob(String laundary_name,int number_of_clothes){
        ArrayList<LaundaryJob> jbs=mLaundaryJobs.getValue();
        LaundaryJob newjb=new LaundaryJob(1234,12345,"15-05-2015","null",laundary_name,"Pending",number_of_clothes);
        jbs.add(newjb);
        mLaundaryJobs.setValue(jbs);
        mRepo.addLaundaryJob(newjb);
    }
    public void sortLaundaryListById(){
        ArrayList<LaundaryJob> jbs=mLaundaryJobs.getValue();
        jbs.sort((o1,o2) -> String.valueOf(o1.job_id).compareTo(String.valueOf(o2.job_id)));
        mLaundaryJobs.setValue(jbs);
    }
    public void sortLaundaryListByDate(){
        ArrayList<LaundaryJob> jbs=mLaundaryJobs.getValue();
        jbs.sort((o1,o2) -> String.valueOf(o1.submission_date).compareTo(String.valueOf(o2.submission_date)));
        mLaundaryJobs.setValue(jbs);
    }
}
