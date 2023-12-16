package com.travel_managment_system.travel_managment_system.User.Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class Flight implements Serializable {
    public ArrayList<Integer> Seats = new ArrayList<>();

    private String FlightCompanyName;
    public Boolean [] isReserved=new Boolean[50];
    public void FillarrSeats(){
        for(int i =0; i<50;i++) {
            Seats.add(i+1);
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
