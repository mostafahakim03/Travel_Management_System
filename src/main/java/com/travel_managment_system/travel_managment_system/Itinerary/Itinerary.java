package com.travel_managment_system.travel_managment_system.Itinerary;

import com.travel_managment_system.travel_managment_system.Cprofile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Itinerary {
    private Activities[] activities = new Activities[3];
    public Itinerary() {
        activities[0] = new Activities("Abu Simble","8 AM", "6 PM", "",60);
        activities[1] = new Activities("bla bla","9 AM", "7 PM", "",60);
        activities[2] = new Activities("bla bla bla","10 AM", "11 PM", "",60);
    }
    public Activities[] getActivities() {
        return activities;
    }
    public void setActivities(Activities[] activities) {
        this.activities = activities;
    }
}
