package com.travel_managment_system.travel_managment_system.User.Customer;

import java.util.ArrayList;

public class CarCompany {
    private String Companyname;

    public CarCompany(String companyname) {
        this.Companyname = companyname;
    }

    public String getCompanyname() {

        return Companyname;
    }

    public void setCompanyname(String companyname) {

        Companyname = companyname;
    }

    public static ArrayList<CarCompany> CarCompany = new ArrayList<CarCompany>();
    public ArrayList<CAr> Car = new ArrayList<CAr>();

    public void AddCAr(CAr car1) {
        Car.add(car1);
    }


    public void in(CarCompany company1) {

        CarCompany.add(company1);
    }


}
