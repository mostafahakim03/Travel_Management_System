package com.travel_managment_system.travel_managment_system.User.Customer;

import java.util.ArrayList;

public class Hotel {
    private String HotelName;
    private String Hotellocation;
    public  ArrayList<String> HotelRoomType = new ArrayList<String>();

    public void FillHotelRoom(){
        HotelRoomType.add("Single");
        HotelRoomType.add("Douple");
        HotelRoomType.add("Triple");
    }

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
