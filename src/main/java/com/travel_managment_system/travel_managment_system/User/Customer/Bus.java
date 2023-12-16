package com.travel_managment_system.travel_managment_system.User.Customer;

import java.io.Serializable;

public class Bus implements Serializable {
    public static final int numberOfSeats = 50;
    private int NumberOfBus;
    public int [] arrNumberOfSeats = new int[50];
    public void FillarrSeats(){
        for(int i =0; i<50;i++) {
            arrNumberOfSeats[i] = i+1;
        }
    }
    public int getNumberOfBus() {
        return NumberOfBus;
    }

    public void setNumberOfBus(int numberOfBus) {
        NumberOfBus = numberOfBus;
    }
}
