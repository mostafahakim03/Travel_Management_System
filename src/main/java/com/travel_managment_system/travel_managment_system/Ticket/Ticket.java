package com.travel_managment_system.travel_managment_system.Ticket;

import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import com.travel_managment_system.travel_managment_system.User.Customer.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    public static Ticket selectedTicket=new Ticket();
    public int TicketID=0;

    public static int numberOfTickets=0;
    //public int numberOfReservedTickets; //counts down in the booking process.
    public int trip_id;
    public double ticket_price;
    public LocalDate booking_date;
    public ArrayList <Integer> seatNumber=new ArrayList<>();
    public CAr car;



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
