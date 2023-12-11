package com.travel_managment_system.travel_managment_system.User.Customer;

public class Flight {
    private String FlightCompanyName;
    public static final int numberOfSeats = 50;
    public int [] arrNumberOfSeats = new int[50];
    public Boolean [] isReserved=new Boolean[50];
    public void FillarrSeats(){
        for(int i =0; i<50;i++) {
            arrNumberOfSeats[i] = i+1;
            isReserved[i]=false;
        }
    }

    public String getFlightCompanyName() {
        return FlightCompanyName;
    }

    public void setFlightCompanyName(String flightCompanyName) {
        FlightCompanyName = flightCompanyName;
    }
}
