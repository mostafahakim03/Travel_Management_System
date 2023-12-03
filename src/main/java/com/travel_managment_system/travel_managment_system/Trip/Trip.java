package com.travel_managment_system.travel_managment_system.Trip;

public class Trip {
    public static int noOfTrips;
    private static int numbersOfSeats;
    private int trip_id;
    private String tripName;
    private String start_date;
    private String end_date;
    private double price;
    private String tripType;   // family , couple, general
    private String packageType;  // silver , golden , platinum
    private int numbersOfTickets;  // the customer booking

//    tourGuide[] tours = new tourGuide[];

    public Trip(String tripName, int trip_id, String tripType, String start_date, String end_date, int Seats, double price) {
        this.tripName = tripName;
        this.trip_id = trip_id;
        this.tripType = tripType;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
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
}