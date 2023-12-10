package com.travel_managment_system.travel_managment_system.User;

public abstract class User {
    protected String name;
    protected String username;
    protected String pass;
    protected String phone;

    protected String age;
    public static boolean isTourGuide=false;


    public String  check_signup() {
        if (name.isEmpty() || username.isEmpty() || pass.isEmpty() || phone.isEmpty() || age.isEmpty()) {
            return "Please Fill All Fields ";
        }
        if (phone.length() != 11) return "Phone Number Must be 11 Numbers ";
        boolean test_phone = true;
        for (int i = 0; i < 11; i++) {
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9') {
            test_phone = false;
            break;}
        }
        if (!test_phone) return "Phone must include only number digits";
        int ValidAge;
        try {
             ValidAge=Integer.parseInt(age);
        }
        catch (NumberFormatException e){
            ValidAge=-1;
        }
        if(ValidAge==-1||ValidAge<10||ValidAge>99)
        { return "Enter a valid Age";}

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
}
