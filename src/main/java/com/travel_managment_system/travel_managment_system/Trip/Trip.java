package com.travel_managment_system.travel_managment_system.Trip;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Trip {
    private static int noOfTrips = 0;
    private static int numbersOfSeats;
    private int trip_id;
    private String tripName;
    private LocalDate startDate;
    private LocalDate endDate;

    private double price;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    private double payment;
    private String tripImage;
    private String tripType;   // family , couple, general
    private String packageType;  // silver , golden , platinum
    private int numbersOfTickets;  // the customer booking
    private String location;

//    //Hotel code
//    String hotelName;
//    String address;
//    int numberOfNights;
//    int numberOfRooms;
//    private ArrayList<String> arrHotelRoomType = new ArrayList<String>();

    public static ArrayList<Trip> trips = new ArrayList<>();

//    tourGuide[] tours = new tourGuide[];

    public Trip(String tripName, int trip_id, String tripType, LocalDate startDate, LocalDate endDate, int Seats,
                double price, double payment, String tripImage, String location) {
        this.tripName = tripName;
        this.trip_id = trip_id;
        this.tripType = tripType;
        this.startDate =startDate;
        this.endDate=endDate;
        this.price = price;
        this.payment = payment;
        this.tripImage = tripImage;
        this.location = location;
        numbersOfSeats = Seats;
        noOfTrips++;

    }


    public static int getNumbersOfSeats() {
        return numbersOfSeats;
    }

    public void FamilyTrip(int numbersOfTickets, String packageType) {
        if (numbersOfTickets >= 3) {
            this.numbersOfTickets = numbersOfTickets;
            this.packageType = packageType;
        } else {
            System.out.println("The least number of tickets is 3 for family trip");
        }
    }

    public void coupleTrip(int numbersOfTickets, String packageType, int age) {
        if (age >= 18 && numbersOfTickets % 2 == 0) {
            this.numbersOfTickets = numbersOfTickets;
            this.packageType = packageType;
        } else {
            System.out.println("You must be above 18 to sign in this trip or you must be couples");
        }
    }

    public void generalTrip(int numbersOfTickets, String packageType) {
        this.numbersOfTickets = numbersOfTickets;
        this.packageType = packageType;
    }

    public String packageMessage(String packageType) {
        if (packageType.equals("silver")) {
            return "The trip contains only the transportation and half-board";
        } else if (packageType.equals("golden")) {
            return "The trip contains the transportation and full-board";
        } else if (packageType.equals("platinum")) {
            return "The trip contains the transportation, full-board and activities";
        } else return "Wrong packageType";
    }

    public int getNumbersOfTickets() {
        return numbersOfTickets;
    }

    public void setNumbersOfTickets(int numbersOfTickets) {
        this.numbersOfTickets = numbersOfTickets;
    }


    public static int getNoOfTrips() {
        return noOfTrips;
    }

    public static void setNoOfTrips(int noOfTrips) {
        Trip.noOfTrips = noOfTrips;
    }

    public static void setNumbersOfSeats(int numbersOfSeats) {
        Trip.numbersOfSeats = numbersOfSeats;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getTripImage() {
        return tripImage;
    }

    public void setTripImage(String tripImage) {
        this.tripImage = tripImage;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public void fillArr() {
//        arrHotelRoomType.add("Single");
//        arrHotelRoomType.add("Douple");
//        arrHotelRoomType.add("Triple");
//    }
}