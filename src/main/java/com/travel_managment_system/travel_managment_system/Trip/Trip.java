package com.travel_managment_system.travel_managment_system.Trip;

public class Trip {
    private String start_date, end_date;
    private int trip_id;
    private String tripType;   // family , couple, general
    private String packageType;  // silver , golden , platinum
    private static int numbersOfSeats;

    private int numbersOfTickets;  // the customer booking

//    tourGuide[] tours = new tourGuide[];

    public Trip(int trip_id, String tripType, String start_date, String end_date, int numbersOfSeats){

//        if(tripType == "family" && numbersOfTickets >= 3) {
//            FamilyTrip(2, "silver");
//        }
//        else if (tripType == "couple" && this.age >= 18 && numbersOfTickets % 2 == 0) {
//            coupleTrip(2,"silver");
//        } else if (tripType == "general") {
//            generalTrip(2,"silver");
//        }
    }
    public void FamilyTrip(int numbersOfTickets, String packageType){

        if(numbersOfTickets >= 3){
            this.numbersOfTickets = numbersOfTickets;
            this.packageType = packageType;
        }
        else System.out.println("The least number of tickets is 3 for family trip");
    }
    public void coupleTrip(int numbersOfTickets, String packageType , int age){
        if(age >= 18 && numbersOfTickets % 2 == 0){
            this.numbersOfTickets = numbersOfTickets;
            this.packageType = packageType;
        }
        else
            System.out.println("You must be above 18 to sign in this trip or you must be couples");
    }
    public void generalTrip(int numbersOfTickets, String packageType){
        this.numbersOfTickets = numbersOfTickets;
        this.packageType = packageType;
    }

    public String packageMessage(String packageType){
        if (packageType.equals("silver")) {
            return "The trip contains only the transportation and half-board";
        } else if (packageType.equals("golden")) {
            return "The trip contains the transportation and full-board" ;
        } else if (packageType.equals("platinum") ) {
            return "The trip contains the transportation, full-board and activities";
        }
        else return "Wrong packageType";
    }


    public static void setNumbersOfSeats(int numbersOfSeats) {
        Trip.numbersOfSeats = numbersOfSeats;
    }
    public void setNumbersOfTickets(int numbersOfTickets) {
        this.numbersOfTickets = numbersOfTickets;
    }
    public static int getNumbersOfSeats() {
        return numbersOfSeats;
    }
    public int getNumbersOfTickets() {
        return numbersOfTickets;
    }
}
