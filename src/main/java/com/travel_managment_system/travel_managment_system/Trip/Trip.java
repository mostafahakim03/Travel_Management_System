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

    private double price;
    private double payment;
    private String tripImage;
    private String tripType;   // family , couple, general
    private String packageType;  // silver , golden , platinum
    private int numbersOfTickets;  // the customer booking
    private String location;
    private String Transportation; //bus, flight
    private int numberOfAvailableSeats = 50;

    public static Trip selectedTrip;
    private Itinerary itinerary;

    public ArrayList<Ticket> tickets = new ArrayList<>();

    public Bus bus = new Bus();
    public Flight flight = new Flight();
    private Hotel hotel = new Hotel();

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public static ArrayList<Trip> trips = new ArrayList<>();

    private final ArrayList<TourGuide> AssignedTourGuides = new ArrayList<>();

    private boolean isTouGuideComplete = false;

    public String getTransportation() {
        return Transportation;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public Trip() {

    }

    public Trip(String tripName, int trip_id, String tripType, LocalDate startDate, LocalDate endDate,
                double price, double payment, String tripImage, String location, String Transportation) {
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


    public boolean isTourGuideComplete() {
        return isTouGuideComplete;
    }

    public ArrayList<TourGuide> getAssignedTourGuides() {
        return AssignedTourGuides;
    }

    public void FillAssignedTourGuides(TourGuide guide) {
        AssignedTourGuides.add(guide);
    }

    public void setTouGuideComplete(boolean tourGuideComplete) {
        isTouGuideComplete = tourGuideComplete;
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
}

