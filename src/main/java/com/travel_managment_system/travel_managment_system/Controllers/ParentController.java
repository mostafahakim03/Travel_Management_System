package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

abstract public class ParentController {
    public abstract void displayTrips() throws FileNotFoundException; //Display the final vbox when called in the initialize function
    public abstract VBox createTripVBox(Trip trip) throws FileNotFoundException; //creates the vbox's children.
}
