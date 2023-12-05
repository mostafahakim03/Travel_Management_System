package com.travel_managment_system.travel_managment_system;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TripController {
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
    private ChoiceBox<?> packageTypeChoice;

    @FXML
    private Label priceLabel;

    @FXML
    private Label start_dateLabel;

    @FXML
    private Label tripTypeLabel;

    public void ViewTripDetails(Trip trip ){

        TripNameLabel.setText(trip.tripName);
        tripTypeLabel.setText(trip.tripType);
        start_dateLabel.setText(trip.start_date);
        end_dateLabel.setText(trip.end_date);
        priceLabel.setText(String.valueOf(trip.price));
    }

}
