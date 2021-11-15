package com.example.hostel2;

import android.view.contentcapture.DataRemovalRequest;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class DataRepository {
    private static DataRepository instance;
    ArrayList<LaundaryJob> laundaryDataList=new ArrayList<LaundaryJob>();
    Profile userProfile;

    public static DataRepository getInstance(){
        if(instance==null){
            instance=new DataRepository();
        }
        return(instance);
    }

    public MutableLiveData<ArrayList<LaundaryJob>> getLaundaryDataList(){
        MutableLiveData<ArrayList<LaundaryJob>> data=new MutableLiveData<ArrayList<LaundaryJob>>();
        laundaryDataList.clear();
        laundaryDataList.add(new LaundaryJob(15874,51258,"2021-03-01",null,"Laundary A","Pending",5));
        laundaryDataList.add(new LaundaryJob(15369,98541,"2021-01-14",null,"Laundary A","Processing",1));
        laundaryDataList.add(new LaundaryJob(13987,14587,"2021-05-01",null,"Laundary B","Completed",3));
        laundaryDataList.add(new LaundaryJob(14785,87462,"2021-08-03","2021-08-05","Laundary A","Delivered",6));
        laundaryDataList.add(new LaundaryJob(15879,98541,"2021-01-15","2021-01-18","Laundary C","Delivered",7));
        laundaryDataList.add(new LaundaryJob(15874,51258,"2021-03-01",null,"Laundary A","Pending",5));
        laundaryDataList.add(new LaundaryJob(15369,98541,"2021-01-14",null,"Laundary A","Processing",1));
        laundaryDataList.add(new LaundaryJob(13987,14587,"2021-05-01",null,"Laundary B","Completed",3));
        laundaryDataList.add(new LaundaryJob(14785,87462,"2021-08-03","2021-08-05","Laundary A","Delivered",6));
        laundaryDataList.add(new LaundaryJob(15879,98541,"2021-01-15","2021-01-18","Laundary C","Delivered",7));
        data.setValue(laundaryDataList);
        return(data);
    }
    public MutableLiveData<Profile> getUserProfile(){
        Profile pr=new Profile("Harshavardhan","hnavalli@outlook.com","9886608278","#36 , 3rd Cross , East Sectoe , Nandanavana Layout , Koppa Gate Nisarga Road, Bukkasagara, Jigani, Bangalore-5600105");
        userProfile=pr;
        MutableLiveData<Profile> mpr=new MutableLiveData<Profile>();
        mpr.setValue(pr);
        return(mpr);
    }
}
