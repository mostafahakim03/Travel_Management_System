package com.travel_managment_system.travel_managment_system.Trip;

import com.travel_managment_system.travel_managment_system.Itinerary.Itinerary;
import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.User.Customer.Bus;
import com.travel_managment_system.travel_managment_system.User.Customer.Flight;
import com.travel_managment_system.travel_managment_system.User.Customer.Hotel;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Trip implements Serializable {
    private static int noOfTrips = 0;
    private int trip_id;
    private String tripName;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;  // customer
    private double payment; // tour guide
    private String tripImage;
    private String tripType;   // family , couple, general
    private String packageType;  // silver , golden , platinum
    private String location;
    private String Transportation; //bus, flight
    private int numberOfAvailableSeats = 50;
    private Itinerary itinerary;

    public static Trip selectedTrip;   // trip used during the program


    public static ArrayList<Trip> trips = new ArrayList<>();
    public ArrayList<Ticket> tickets = new ArrayList<>();
    private final ArrayList<TourGuide> AssignedTourGuides = new ArrayList<>();   // trip may have 1 or more tour guides
    private boolean isTouGuideComplete = false;

    public Bus bus = new Bus();
    public Flight flight = new Flight();
    private Hotel hotel = new Hotel();


    public Trip() {
        System.out.println("Trip is created");
    }

    public Trip(String tripName, int trip_id, String tripType, LocalDate startDate, LocalDate endDate, double price, double payment, String tripImage, String location, String Transportation) {
        this.tripName = tripName;
        this.trip_id = trip_id;
        this.tripType = tripType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.payment = payment;
        this.tripImage = tripImage;
        this.location = location;
        this.Transportation = Transportation;
        noOfTrips++;
    }



    public boolean isTourGuideComplete() {
        return isTouGuideComplete;
    }

    // returns AssignedTourGuides arrayList
    public ArrayList<TourGuide> getAssignedTourGuides() {
        return AssignedTourGuides;
    }

    // Assign tour guide to the trip
    public void FillAssignedTourGuides(TourGuide guide) {
        AssignedTourGuides.add(guide);
    }



    public void setTouGuideComplete(boolean tourGuideComplete) {
        isTouGuideComplete = tourGuideComplete;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public String getTripName() {
        return tripName;
    }

    public double getPrice() {
        return price;
    }

    public double getPayment() {
        return payment;
    }

    public String getTripImage() {
        return tripImage;
    }

    public String getTripType() {
        return tripType;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getTransportation() {
        return Transportation;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

}

