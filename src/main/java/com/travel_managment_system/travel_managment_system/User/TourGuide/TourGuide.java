package com.travel_managment_system.travel_managment_system.User.TourGuide;

import com.travel_managment_system.travel_managment_system.User.User;

public class TourGuide extends User {
    protected static int GuideCounter=0;
    protected boolean Availibility;
    protected int GuideID;
    //protected Trip trips[];
    protected float Salary;

 public TourGuide(String name, String username, String pass, String phone, int age, int GuideID)
 {
     super();
     this.name= name;
     this.username=username;
     this.pass=pass;
     this.phone=phone;
     this.age=age;
     this.GuideID=GuideID;

 }

}

