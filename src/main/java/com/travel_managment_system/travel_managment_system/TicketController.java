package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class TicketController implements Loadfxml{
    @FXML
    public Label ticketIDLabel;
    @FXML
    public Label tripDateLabel;
    @FXML
    public Label tripLocation;
    @FXML
    public Label userLabel;
    @FXML
    public Label priceLabel;
    @FXML
    public Label tripNameLabel;
    @FXML
    public Button confirmButton;
    @FXML
    public AnchorPane TicketAnchor;
    @FXML
    public Label tripTypeLabel;

    public void initialize(){
        Trip trip = Trip.selectedTrip;
        ticketIDLabel.setText(String.valueOf(trip.getTrip_id()));
        tripNameLabel.setText(trip.getTripName());
        tripDateLabel.setText(trip.getStartDate().toString());
        tripTypeLabel.setText(trip.getTripType());
        priceLabel.setText(String.valueOf(trip.getPrice()));
        tripLocation.setText(trip.getLocation());
    }

    void CProfileClicked(ActionEvent event) throws IOException {

    }
    void HomeClicked(ActionEvent event) throws IOException{

    }
    void logoutButtonClicked(ActionEvent event) throws IOException {

    }
    void myTripsClicked(ActionEvent event) throws IOException{

    }
}
