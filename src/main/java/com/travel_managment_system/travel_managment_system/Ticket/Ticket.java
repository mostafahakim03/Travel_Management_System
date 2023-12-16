package com.travel_managment_system.travel_managment_system.Ticket;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Ticket implements Serializable {
    public static Ticket selectedTicket=new Ticket();
    public int TicketID=0;

    public static int numberOfTickets=0;

    public int trip_id;
    public double ticket_price;
    public LocalDate booking_date;
    public ArrayList <Integer> seatNumber=new ArrayList<>();
    public CAr car=new CAr();
    public String roomType;
    public String packageType;



    public Ticket(){
        this.booking_date = LocalDate.now();
        numberOfTickets++;
        TicketID=numberOfTickets;
    }
    public double returnPrice(int noOFTrips) {
        if (noOFTrips % 2 == 0 && noOFTrips != 0) {
            this.ticket_price = this.ticket_price - (this.ticket_price * 0.15);
        }
        return ticket_price;
    }
}
