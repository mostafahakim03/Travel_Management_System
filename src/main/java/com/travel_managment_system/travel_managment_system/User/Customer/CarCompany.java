package com.travel_managment_system.travel_managment_system.User.Customer;
import java.util.ArrayList;

public class CarCompany {
    private String Companyname;
    public static ArrayList<CarCompany> CarCompany = new ArrayList<CarCompany>();
    public ArrayList<com.travel_managment_system.travel_managment_system.User.Customer.Car> Car= new ArrayList<com.travel_managment_system.travel_managment_system.User.Customer.Car>();
    public void AddCAr(com.travel_managment_system.travel_managment_system.User.Customer.Car car1){
        Car.add(car1);
    }

}
