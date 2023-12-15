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

}
