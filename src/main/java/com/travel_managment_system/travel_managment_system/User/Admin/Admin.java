package com.travel_managment_system.travel_managment_system.User.Admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Admin {
    public static ArrayList<String> Locations=new ArrayList<>();
    private static String Username="admin";
    private static String Password="1234";


    public static String getUsername() {
        return Username;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setUsername(String username) {
        Username = username;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public static File cobyFile(File source ) throws IOException {
        File dest=new File("src\\main\\resources\\com\\travel_managment_system\\travel_managment_system\\assets"+File.separator+source.getName());
        if(dest.exists()) System.out.println("yes");
        else {
            System.out.println("no");
            Files.copy(source.toPath(), dest.toPath());
        }

        return dest;
    }
    public static void addLocation(String location){
        if(!(Locations.contains(location))) Locations.add(location);
    }



}
