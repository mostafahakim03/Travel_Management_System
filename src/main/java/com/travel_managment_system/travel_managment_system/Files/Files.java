package com.travel_managment_system.travel_managment_system.Files;

import com.travel_managment_system.travel_managment_system.Itinerary.Activities;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.Customer.Hotel;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;

import java.io.*;
import java.util.ArrayList;

public class Files {
    public static void read() throws IOException, ClassNotFoundException {
        readTourguide();
        readCustomer();
        readTrip();
        readNewID();
        readLocation();
        readCars();
        readHotel();
        readActivities();

    }

    public static void write() throws IOException {
        writeTourguide();
        writeCustomer();
        writeTrip();
        writeNewID();
        writeLocation();
        writeCars();
        writeHotel();
        writeActivities();
    }

    public static void writeTourguide() throws IOException {
        File file = new File("Tour_guide");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(TourGuide.TourguideAcc);
    }

    public static void readTourguide() throws IOException, ClassNotFoundException {
        File file = new File("Tour_guide");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        TourGuide.TourguideAcc = (ArrayList<TourGuide>) in.readObject();

    }

    public static void writeCustomer() throws IOException {
        File file = new File("Customer");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(Customer.CoustomerAcc);
    }

    public static void readCustomer() throws IOException, ClassNotFoundException {
        File file = new File("Customer");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Customer.CoustomerAcc = (ArrayList<Customer>) in.readObject();

    }

    public static void writeTrip() throws IOException {
        File file = new File("Trips");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(Trip.trips);
    }

    public static void readTrip() throws IOException, ClassNotFoundException {
        File file = new File("Trips");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Trip.trips = (ArrayList<Trip>) in.readObject();

    }
    public static void writeNewID() throws IOException {
        File file = new File("NewID");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(TourGuide.newidAcc);
    }

    public static void readNewID() throws IOException, ClassNotFoundException {
        File file = new File("NewID");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        TourGuide.newidAcc = (ArrayList<Integer>) in.readObject();

    }
    public static void writeLocation() throws IOException {
        File file = new File("Location");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(Admin.Locations);
    }

    public static void readLocation() throws IOException, ClassNotFoundException {
        File file = new File("Location");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Admin.Locations = (ArrayList<String>) in.readObject();

    }
    public static void writeCars() throws IOException {
        File file = new File("Cars");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(CAr.cars);
    }

    public static void readCars() throws IOException, ClassNotFoundException {
        File file = new File("Cars");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        CAr.cars = (ArrayList<CAr>) in.readObject();

    }
    public static void writeHotel() throws IOException {
        File file = new File("Hotels");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(Hotel.Hotels);
    }

    public static void readHotel() throws IOException, ClassNotFoundException {
        File file = new File("Hotels");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Hotel.Hotels = (ArrayList<Hotel>) in.readObject();

    }

    public static void writeActivities() throws IOException {
        File file = new File("Activities");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(Activities.activities);
    }

    public static void readActivities() throws IOException, ClassNotFoundException {
        File file = new File("Activities");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Activities.activities = (ArrayList<Activities>) in.readObject();

    }




}
