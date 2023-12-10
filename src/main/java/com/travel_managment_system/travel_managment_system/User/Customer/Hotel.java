package com.travel_managment_system.travel_managment_system.User.Customer;

import java.util.ArrayList;

public class Hotel {
    private String HotelName;
    private String Hotellocation;
       public Hotel(String hotelName , String hotellocation){
           this.HotelName=hotelName;
           this.Hotellocation=hotellocation;
           HotelRoomType.add("Single");
           HotelRoomType.add("Douple");
           HotelRoomType.add("Triple");
       }
    public  ArrayList<String> HotelRoomType = new ArrayList<String>();
    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        this.HotelName = hotelName;
    }
    public String getHotellocation(){

        return Hotellocation;
    }
    public void setHotellocation(String hotellocation){

        this.Hotellocation=hotellocation;
    }
}
