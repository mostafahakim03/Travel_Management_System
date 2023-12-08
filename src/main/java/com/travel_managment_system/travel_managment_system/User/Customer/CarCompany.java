package com.travel_managment_system.travel_managment_system.User.Customer;

import java.util.ArrayList;

public class CarCompany {
    private String Companyname;

    public class Car{
        private String Carname;
        private int Carmodel;



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

        public ArrayList<CarCompany> CarCompany = new ArrayList<CarCompany>();
        public  ArrayList<Car> Car= new ArrayList<Car>();

        public void in(){
//           CarCompany.add();
        }
        public String getCompanyname() {
            return Companyname;
        }
    }

    public void setCompanyname(String companyname) {
        Companyname = companyname;
    }
}
