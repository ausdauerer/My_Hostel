package com.example.hostel2;

public class LaundaryJob{
    int job_id;
    int student_id;
    String submission_date;
    String delivery_date;
    String laundary_name;
    String status;
    int number_of_clothes;

    public LaundaryJob(int job_id,int student_id,String submission_date,String delivery_date,String laundary_name,String status,int number_of_clothes){
        this.job_id=job_id;
        this.student_id=student_id;
        this.submission_date=submission_date;
        this.delivery_date=delivery_date;
        this.laundary_name=laundary_name;
        this.status=status;
        this.number_of_clothes=number_of_clothes;
    }
}
