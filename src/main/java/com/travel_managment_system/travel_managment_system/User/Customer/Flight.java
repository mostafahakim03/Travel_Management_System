package com.travel_managment_system.travel_managment_system.User.Customer;

public class Flight {
    private String FlightCompanyName;
    public static final int numberOfSeats = 50;
    public int [] arrNumberOfSeats = new int[50];
    public void FillarrSeats(){
        for(int i =1; i<51;i++) {
            arrNumberOfSeats[i] = i;
        }
    }

    public String getFlightCompanyName() {
        return FlightCompanyName;
    }

    public void setFlightCompanyName(String flightCompanyName) {
        FlightCompanyName = flightCompanyName;
    }
}
