package com.example.hostel2;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel{
    private MutableLiveData<ArrayList<LaundaryJob>> mLaundaryJobs;
    private MutableLiveData<Profile> mUserProfile;
    private DataRepository mRepo;

    public void initializeData(){
        if(mLaundaryJobs!=null){
            return;
        }
        mRepo=DataRepository.getInstance();
        mLaundaryJobs=mRepo.getLaundaryDataList();
        mUserProfile=mRepo.getUserProfile();
    }

    public void refreshData(){
        mLaundaryJobs.setValue(mRepo.getLaundaryDataList().getValue());
    }

    public LiveData<ArrayList<LaundaryJob>> getLaundaryJobs(){
        return(mLaundaryJobs);
    }

    public LiveData<Profile> getProfile(){
        return(mUserProfile);
    }

}
