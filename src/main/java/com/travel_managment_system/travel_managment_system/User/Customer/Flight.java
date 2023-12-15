package com.travel_managment_system.travel_managment_system.User.Customer;

public class Flight {
    private String FlightCompanyName;
    public int [] arrNumberOfSeats = new int[50];
    public Boolean [] isReserved=new Boolean[50];
    public void FillarrSeats(){
        for(int i =0; i<50;i++) {
            arrNumberOfSeats[i] = i+1;
            isReserved[i]=false;
        }
    }
}
