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
    @FXML
    private Button HomeButton;

    @FXML
    private AnchorPane Itinerary;

    private Activities[] activities;
    private String location;

    public Itinerary() {
        activities = new Activities[3];
    }

    public Activities[] getActivities() {
        return activities;
    }

    public void setActivities(Activities[] activities) {
        this.activities = activities;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;

    }

    public class Activities {
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
    }



    @FXML
    void CProfileClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cprofile.fxml"));
        Cprofile Cprofile =new Cprofile();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Itinerary.getScene().getWindow().hide();
        Cprofile.initialize2();
    }

    @FXML
    void HomeClicked(ActionEvent event) throws IOException{
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Itinerary.getScene().getWindow().hide();
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK)  {
            //logging out code
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Itinerary.getScene().getWindow().hide();

        }
    }

    @FXML
    void myTripsClicked(ActionEvent event) throws IOException{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
        Itinerary.getScene().getWindow().hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}