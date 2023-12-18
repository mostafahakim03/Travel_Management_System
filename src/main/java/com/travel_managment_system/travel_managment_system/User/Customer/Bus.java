package com.travel_managment_system.travel_managment_system.User.Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class Bus implements Serializable {
    public ArrayList<Integer> Seats = new ArrayList<>();

    public void FillarrSeats() {
        for (int i = 0; i < 50; i++) {
            Seats.add(i + 1);
        }
    }

}
