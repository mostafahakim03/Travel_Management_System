package com.travel_managment_system.travel_managment_system.Itinerary;

import java.io.Serializable;
import java.util.ArrayList;

public class Activities implements Serializable {
    private String location;
    private String startTime;
    private String endTime;
    private String Img;
    private int Id;
  public static  ArrayList<Activities>Activitties= new ArrayList<>();

    public Activities (String location,String StartTime, String EndTime, String img,int Id){
        this.location = location;
        this.startTime = StartTime;
        this.endTime = EndTime;
        this.Img = img;
        this.Id=Id;
    }

    public String getImg() {
        return Img;
    }
    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return Id;
    }
}
