package com.travel_managment_system.travel_managment_system.User.TourGuide;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.User;

import java.io.Serializable;
import java.util.ArrayList;

public class TourGuide extends User implements Serializable {
    protected boolean Availibility = true;
    protected String GuideID;
    protected Double Salary;
    public static ArrayList<Integer> newidAcc = new ArrayList<Integer>();
    public static ArrayList<TourGuide> TourguideAcc = new ArrayList<>();
    public static TourGuide selectedTourGuide;
    private final ArrayList<Trip> AssignedTrips = new ArrayList<>();

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
                return "Invalid ID";
            }
            if (TourGuide.newidAcc.contains(id)) {
                TourGuide.newidAcc.remove((Integer) id);
                return "done";
            } else return "Invalid ID";
        }
        return test;
    }

    public String check_signup(Boolean T) {
        return super.check_signup();
    }

    public Double getSalary() {
        return Salary;
    }

    public String getGuideID() {
        return GuideID;
    }

    public boolean isAvailibility() {
        return Availibility;
    }

    public void setAvailibility(boolean availibility) {
        Availibility = availibility;
    }

    public void setGuideID(String guideID) {
        GuideID = guideID;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public ArrayList<Trip> getAssignedTrips() {
        return AssignedTrips;
    }

    public void FillAssignedTrips(Trip assignedTrips) {
        AssignedTrips.add(assignedTrips);
    }


}


