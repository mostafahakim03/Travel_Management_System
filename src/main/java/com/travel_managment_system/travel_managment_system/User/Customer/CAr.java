package com.travel_managment_system.travel_managment_system.User.Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class CAr implements Serializable {
    private String Carname;
    private int Carmodel;
    private String Image;
    public static ArrayList<CAr> cars = new ArrayList<>();

    public CAr() {

    }

    public CAr(String carname, int carmodel,String image) {
        this.Carname = carname;
        this.Carmodel = carmodel;
        this.Image=image;
    }

    public String getCarname() {
        return Carname;
    }

    public void setCarname(String carname) {
        Carname = carname;
    }

    public int getCarmodel() {
        return Carmodel;
    }

    public void setCarmodel(int carmodel) {
        Carmodel = carmodel;
    }

    public String getImage() {
        return Image;
    }
}

