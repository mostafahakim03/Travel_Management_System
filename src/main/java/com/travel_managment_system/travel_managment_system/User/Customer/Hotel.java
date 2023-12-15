package com.travel_managment_system.travel_managment_system.User.Customer;
public class Hotel {
    private String HotelName;
    private String Hotellocation;
    private String RoomType;
    public Hotel(){}
    public Hotel(String hotelName , String hotellocation){
        this.HotelName=hotelName;
        this.Hotellocation=hotellocation;
    }
    public String getHotelName() {
        return HotelName;
    }
    public String getHotellocation(){
        return Hotellocation;
    }

}
