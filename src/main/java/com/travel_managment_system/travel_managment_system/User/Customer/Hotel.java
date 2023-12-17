package com.travel_managment_system.travel_managment_system.User.Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    private String HotelName;
    private String Hotellocation;
    public String HotelImage;
    private String RoomType;
  public static   ArrayList<Hotel>Hotels=new ArrayList<>();
    public Hotel()
    {}

       public Hotel(String hotelName , String hotellocation,String HotelImage){
           this.HotelName=hotelName;
           this.Hotellocation=hotellocation;
           this.HotelImage=HotelImage;
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
    public String getRoomType() {
        return RoomType;
    }
    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public void setHotelImage(String hotelImage) {
        HotelImage = hotelImage;
    }

    public String getHotelImage() {
        return HotelImage;
    }
}
