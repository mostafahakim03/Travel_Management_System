package com.travel_managment_system.travel_managment_system.Ticket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    public static Ticket selectedTicket;
    public int TicketID=0;

    public static int numberOfTickets=0;
    //public int numberOfReservedTickets; //counts down in the booking process.
    public int trip_id;
    public double ticket_price;
    public LocalDate booking_date;
    public ArrayList <Integer> seatNumber=new ArrayList<>();


    public Ticket(int trip_id){
        this.booking_date = LocalDate.now();
        numberOfTickets++;
        TicketID=numberOfTickets;
        this.trip_id = trip_id;
    }


    public double returnPrice(int noOFTrips) {
        if (noOFTrips % 2 == 0 && noOFTrips != 0) {
            this.ticket_price = this.ticket_price - (this.ticket_price * 0.15);
        }
        return ticket_price;
    }
}
