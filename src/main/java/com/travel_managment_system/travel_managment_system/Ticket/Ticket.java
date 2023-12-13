package com.travel_managment_system.travel_managment_system.Ticket;

import com.travel_managment_system.travel_managment_system.User.Customer.Flight;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    public static Ticket selectedTicket=new Ticket();
    public int TicketID=0;
    public String user_name;
    public static int numberOfTickets=0;
    public int numberOfReservedTickets;
    public int trip_id;
    public double ticket_price;
    public Date booking_date;
    public String ticket_type; //platinum , golden , silver
    //    public  String board_Type ;//full or half board
    public ArrayList <Integer> seatNumber=new ArrayList<>();

    public Ticket(){

    }

    public Ticket(String user_name, int seat_num, int trip_id, double ticket_price, Date booking_date, String ticket_type, String board_Type) {
        this.user_name = user_name;
        this.trip_id = trip_id;
        this.ticket_price = ticket_price;
        this.booking_date = booking_date;
//        this.ticket_type = ticket_type;
        numberOfTickets++;
        TicketID=numberOfTickets;
//        this.seat_num=seat_num;
//        this.board_Type=board_Type;
//        System.arraycopy(activities, 0, this.activities, 0, 4);

    }

    public double returnPrice(int noOFTrips) {
        if (noOFTrips % 2 == 0 && noOFTrips != 0) {
            this.ticket_price = this.ticket_price - (this.ticket_price * 0.15);
        }
        return ticket_price;
    }
}

//    public void setTicket_price(double ticket_price) {
//        this.ticket_price = ticket_price;
//    }
//    public Date getBooking_date (){
//        return booking_date ;
//    }
//    public void setBookingDate(Date booking_date){
//        this.booking_date = booking_date;
//    }
//    public String getTicket_type(){
//        return ticket_type;
//    }
//    public void setTicket_type(String ticket_type){
//        this.ticket_type=ticket_type;
//    }
//public int getTicket_id() {
//    return ticket_id;
//}
//    public void setTicket_id(int ticket_id) {
//        this.ticket_id = ticket_id;
//    }
//    public String getUser_name() {
//        return user_name;
//    }
//
//    public void setUser_name(String user_name) {
//        this.user_name = user_name;
//    }

//    public int getSeat_num() {
//        return seat_num;
//    }
//
//    public void setSeat_num(int seat_num) {
//        this.seat_num = seat_num;
//    }
//    public double getTicket_price() {
//        return ticket_price;
//    }

//    public String  getBoard_Type(){
//        return board_Type;
//    }
//public int getTrip_id() {
//    return trip_id;
//}
//    public void setTrip_id(int trip_id) {
//        this.trip_id = trip_id;
//    }
//
