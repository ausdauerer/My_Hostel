package com.example.hostel2;

import android.os.AsyncTask;
import android.util.Log;
import android.view.contentcapture.DataRemovalRequest;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public MutableLiveData<ArrayList<AttendanceLog>> getAttendanceDataList(){
        ArrayList<AttendanceLog> atdlog=new ArrayList<AttendanceLog>();
        atdlog.add(new AttendanceLog("15-05-2021","Absent","Hackathon"));
        atdlog.add(new AttendanceLog("16-05-2021","Absent","Hackathon"));
        atdlog.add(new AttendanceLog("17-05-2021","Absent","Hackathon"));
        atdlog.add(new AttendanceLog("18-05-2021","Present",""));
        atdlog.add(new AttendanceLog("19-05-2021","Present",""));
        atdlog.add(new AttendanceLog("20-05-2021","Present",""));
        atdlog.add(new AttendanceLog("21-05-2021","Present",""));
        atdlog.add(new AttendanceLog("22-05-2021","Absent","On Vacation for Meeting Parents"));
        atdlog.add(new AttendanceLog("23-05-2021","Absent","On Vacation for Meeting Parents"));
        atdlog.add(new AttendanceLog("24-05-2021","Absent","On Vacation for Meeting Parents"));
        atdlog.add(new AttendanceLog("25-05-2021","Absent","On Vacation for Meeting Parents"));
        atdlog.add(new AttendanceLog("26-05-2021","Present",""));
        atdlog.add(new AttendanceLog("27-05-2021","Present",""));
        atdlog.add(new AttendanceLog("28-05-2021","Present",""));
        atdlog.add(new AttendanceLog("29-05-2021","Present",""));
        MutableLiveData<ArrayList<AttendanceLog>> mpr=new MutableLiveData<ArrayList<AttendanceLog>>();
        mpr.setValue(atdlog);
        return(mpr);
    }

    public void addLaundaryJob(LaundaryJob j){
        laundaryDataList.add(j);
        //Update in server
    }
}
