package com.travel_managment_system.travel_managment_system.Trip;

import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private String address;

    private int numberOfRooms;


    public Hotel( String hotelName, String address, int numberOfNights,int numberOfRooms) {

        this.hotelName = hotelName;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getAddress(){
        return address;
    }


    public int getNumberOfNights() {
        return numberOfRooms;
    }

}
