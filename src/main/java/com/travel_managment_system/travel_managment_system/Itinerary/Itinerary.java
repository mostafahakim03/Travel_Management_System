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


    private Activities[] activities;


    public Itinerary() {
        activities = new Activities[3];
    }

    public Activities[] getActivities() {
        return activities;
    }

    public void setActivities(Activities[] activities) {
        this.activities = activities;
    }




    public class Activities {
        private String location;
        private String type;
        private String startTime;
        private String endTime;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
        public void setLocation(String location) {
            this.location = location;

        }
        public String getLocation() {
            return location;
        }
    }




}