package com.travel_managment_system.travel_managment_system.Files;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;

import java.io.*;
import java.util.ArrayList;

public class Files {
    public static void Read_Tourguide() throws IOException, ClassNotFoundException {
        File file =new File("UpdateTourguides");
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));
        TourGuide.TourguideAcc=(ArrayList<TourGuide>) in.readObject();

    }
    public static void Write_Tourguide() throws IOException {
        File file =new File("UpdateTourguides");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(TourGuide.TourguideAcc);
    }
}
