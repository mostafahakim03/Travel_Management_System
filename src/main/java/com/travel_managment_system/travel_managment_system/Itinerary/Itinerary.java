package com.travel_managment_system.travel_managment_system.Itinerary;

public class Itinerary {
    private Activities[] activities = new Activities[3];
    public Itinerary() {
        activities[0] = new Activities("Abu Simble","8 AM", "6 PM", "",60);
        activities[1] = new Activities("Vally of kings","9 AM", "7 PM", "",61);
        activities[2] = new Activities("Template of karnak","10 AM", "11 PM", "",62);
    }
    public Activities[] getActivities() {
        return activities;
    }
    public void setActivities(Activities[] activities) {
        this.activities = activities;
    }
}
