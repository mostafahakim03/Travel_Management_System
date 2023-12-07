package com.travel_managment_system.travel_managment_system.User.Customer;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import com.travel_managment_system.travel_managment_system.User.User;

import java.util.ArrayList;

public class Customer extends User {
    public int NumberOfTrip;
    public static ArrayList<Customer> CoustomerAcc = new ArrayList<Customer>();
    public void Customer(String customername, String password ,String phone , String Age){
        this.username=customername;
        this.pass=password;
        this.phone=phone;
        this.age=Age;
    }
//    public Boolean CheeckDiscount(int NumberOfTrip , String Triptype ){
//        if (NumberOfTrip%2 ==0 && Triptype.equals("Family")){
//            return true;
//        }
//        else return false;
//    }


    public int getNumberOfTrip() {
        return NumberOfTrip;
    }

    public void setNumberOfTrip(int numberOfTrip) {
        NumberOfTrip = numberOfTrip;
    }
}


