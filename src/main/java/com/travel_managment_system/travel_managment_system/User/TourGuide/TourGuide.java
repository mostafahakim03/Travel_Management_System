package com.travel_managment_system.travel_managment_system.User.TourGuide;

import com.travel_managment_system.travel_managment_system.User.User;

import java.util.ArrayList;

public class TourGuide extends User {
    protected static int GuideCounter = 0;
    protected boolean Availibility;
    protected String GuideID;
    //protected Trip trips[];
    protected float Salary;
    public static ArrayList<Integer> newidAcc = new ArrayList<Integer>();
    public static boolean isTourGuide=false;
    public static ArrayList<TourGuide> TourguideAcc = new ArrayList<TourGuide>();
    public static TourGuide selectedTourGuide;

    public TourGuide(String name, String username, String pass, String phone, String age, String GuideID) {
        super();
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.phone = phone;
        this.age = age;
        this.GuideID = GuideID;

    }


    public String check_signup() {
        String test = super.check_signup();
        if (test.equals("done")) {
            int id;
            try {
                id = Integer.parseInt(String.valueOf(GuideID));
            } catch (NumberFormatException e) {
                id = -1;
            }
            if (newidAcc.contains(id)) return "done";
            else return "Invalid ID";
        }
        return test;
    }

    public float getSalary() {
        return Salary;
    }

}


