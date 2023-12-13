package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
//        userLabel.setText();
        priceLabel.setText(String.valueOf(trip.getPrice()));
        tripLocation.setText(trip.getLocation());
    }

    @FXML
    void CProfileClicked(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Cprofile.fxml"));
//        Cprofile Cprofile =new Cprofile();
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//        Itinerary.getScene().getWindow().hide();
//        Cprofile.initialize();
    }
    @FXML
    void HomeClicked(ActionEvent event) throws IOException{
//        System.out.println("Going home!");
//        Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//        Itinerary.getScene().getWindow().hide();
    }
    @FXML
    void logoutButtonClicked(ActionEvent event) throws IOException {
//        System.out.println("Logout pending!");
//        //alert code
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Logout");
//        alert.setHeaderText("You are logging out...");
//        alert.setContentText("Are you sure you want to logout?");

//        if (alert.showAndWait().get() == ButtonType.OK)  {
            //logging out code
//            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
//            Itinerary.getScene().getWindow().hide();

//        }
    }
    @FXML
    void myTripsClicked(ActionEvent event) throws IOException{
//        Parent root;
//        root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
//        Itinerary.getScene().getWindow().hide();
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
    }
}
