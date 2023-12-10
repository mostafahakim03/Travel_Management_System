package com.travel_managment_system.travel_managment_system.User.Customer;

public class CAr {
        private String Carname;
        private int Carmodel;

       public CAr(String carname , int carmodel){
           this.Carname=carname;
           this.Carmodel=carmodel;
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

}

