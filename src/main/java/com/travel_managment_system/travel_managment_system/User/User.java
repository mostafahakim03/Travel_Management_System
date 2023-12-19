package com.travel_managment_system.travel_managment_system.User;

import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String name;
    protected String username;
    protected String pass;
    protected String phone;

    protected String age;
    public static boolean isTourGuide = false;


    public String check_signup() {
        if (name.isEmpty() || username.isEmpty() || pass.isEmpty() || phone.isEmpty() || age.isEmpty()) {
            return "Please Fill All Fields ";
        }
        boolean user = true;
        for (int i = 0; i < TourGuide.TourguideAcc.size(); i++) {
            if (username.equals(TourGuide.TourguideAcc.get(i).getUsername())) {
                user = false;
                break;
            }
        }
        for (int i = 0; i < Customer.CoustomerAcc.size(); i++) {
            if (username.equals(Customer.CoustomerAcc.get(i).getUsername())) {
                user = false;
                break;
            }
        }
        if (!user) {
            return "User Name is already exists";
        }
        if (phone.length() != 11) return "Phone Number Must be 11 Numbers ";
        boolean test_phone = true;
        for (int i = 0; i < 11; i++) {
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9') {
                test_phone = false;
                break;
            }
        }
        if (!test_phone) return "Phone must include only number digits";
        int ValidAge;
        try {
            ValidAge = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            ValidAge = -1;
        }
        if (ValidAge == -1 || ValidAge < 16 || ValidAge > 99) {
            return "Enter a valid Age";
        }

        return "done";

    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPass() {
        return pass;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
    //public abstract void display();

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public  static FadeTransition fade_Screen(double start, double end, AnchorPane parent){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(5000));
        fadeTransition.setNode(parent);
        fadeTransition.setFromValue(start);
        fadeTransition.setToValue(end);
        fadeTransition.play();
        return fadeTransition;

    }
}
