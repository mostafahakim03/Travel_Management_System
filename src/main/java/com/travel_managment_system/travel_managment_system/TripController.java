package com.travel_managment_system.travel_managment_system;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TripController implements Initializable {
    @FXML
    private Button BookingButton;
    @FXML
    private Label ChoiceLabel;
    @FXML
    private Label NoOfTicketsMessageLabel1;
    @FXML
    private Label PackageMessageLabel;
    @FXML
    private AnchorPane TripHome;
    @FXML
    private Label TripNameLabel;
    @FXML
    private Label end_dateLabel;
    @FXML
    private ImageView imgView;
    @FXML
    private TextField numbersOfTicketsInputs;
    @FXML
    private ChoiceBox<String> packageTypeChoice;
    @FXML
    private Label priceLabel;
    @FXML
    private Label start_dateLabel;
    @FXML
    private Label tripTypeLabel;
    @FXML
    private String[] packages = {"Silver", "Golden" , "Platinum"};

    Trip trip;

    public void ViewTripDetails(Trip trip){
        TripNameLabel.setText(trip.tripName);
        tripTypeLabel.setText(trip.tripType);
        start_dateLabel.setText(trip.start_date);
        end_dateLabel.setText(trip.end_date);
        priceLabel.setText(String.valueOf(trip.price));

//        this.trip.tripName = trip.tripName;
//        this.trip.trip_id = trip.trip_id;
//        this.trip.tripType = trip.tripType;
//        this.trip.start_date = trip.start_date;
//        this.trip.end_date = trip.end_date;
//        this.trip.price = trip.price;
//        this.trip.payment = trip.payment;
//        this.trip.tripImage = trip.tripImage;
////        Trip.numbersOfSeats = trip.Seats;
//        Trip.noOfTrips++;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        packageTypeChoice.getItems().addAll(packages);
        packageTypeChoice.setOnAction(this::getPackage);
    }
    public void getPackage(ActionEvent event){
        trip.packageType = String.valueOf(packageTypeChoice.getValue());
        ChoiceLabel.setText("You chose : " + trip.packageType);
        if (trip.packageType.equals("Silver")) {
            PackageMessageLabel.setText("The trip contains only the transportation and half-board");
        } else if (trip.packageType.equals("Golden")) {
            PackageMessageLabel.setText("The trip contains the transportation and full-board");
        } else if (trip.packageType.equals("Platinum")) {
            PackageMessageLabel.setText("The trip contains the transportation, full-board and activities");
        }
    }
}
