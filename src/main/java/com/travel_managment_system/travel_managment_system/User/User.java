package com.travel_managment_system.travel_managment_system.User;

public abstract class User {
    protected String name;
    protected String username;
    protected String pass;
    protected String phone;

    protected int age;

   public String  check_signup() {
        if (name.isEmpty() || username.isEmpty() || pass.isEmpty() || phone.isEmpty() || age > 0) {
            return "Please Fill All Fields ";
        }
        if (phone.length() != 11) return "Phone Number Must be 11 Numbers ";
        Boolean test_phone = true;
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9') ;
            test_phone = false;
            break;
        }
        if (!test_phone) return "Phone must include only number";
        if (age < 10 || age > 99) {
            return "Enter a valid Age";}
            return "done";

        }


    //public abstract void display();
}
