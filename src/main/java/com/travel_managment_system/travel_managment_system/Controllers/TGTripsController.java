package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TGTripsController implements Loadfxml {
    @FXML
    private HBox Nav_Box;
    @FXML
    private Button MyTripsButton;
    @FXML
    private AnchorPane TripsAnchor;
    @FXML
    private VBox tripsVBox;

    public void myTripsClicked(ActionEvent event) throws IOException {
        MyTripsButton.setDisable(true);
    }

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //logging out code
            lodafxmlfile("Uhello-view.fxml");
            TripsAnchor.getScene().getWindow().hide();

        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        lodafxmlfile("TGHomepage.fxml");
        TripsAnchor.getScene().getWindow().hide();
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("UTprofile.fxml");
        TripsAnchor.getScene().getWindow().hide();
        UTProfileController UTProfileController = new UTProfileController();
        UTProfileController.initialize();
    }

    public void salaryClicked(ActionEvent event) throws IOException {
        lodafxmlfile("TGSalary.fxml");
        UTProfileController UTProfileController = new UTProfileController();
        TripsAnchor.getScene().getWindow().hide();
        UTProfileController.initialize();
    }


    @FXML
    private void initialize() throws IOException {
        try {
            displayTrips();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));

    }

    public void displayTrips() throws FileNotFoundException {


        for (Trip trip : TourGuide.selectedTourGuide.getAssignedTrips()) {

            VBox tripBox = createTripVBox(trip);
            tripsVBox.getChildren().add(tripBox);
        }

    }

    private VBox createTripVBox(Trip trip) throws FileNotFoundException {
        VBox tripBox = new VBox();
        VBox detailsBox = new VBox();
        VBox finalBox = new VBox();

        HBox stylingBox = new HBox();

        FileInputStream imageInput = new FileInputStream(trip.getTripImage());
        Image image = new Image(imageInput);
        ImageView tripImage = new ImageView(image);

        String PriceText = Double.toString(trip.getPrice());
        String PaymentText = Double.toString(trip.getPayment());

        Label tripName = new Label(trip.getTripName());
        Label location = new Label(trip.getLocation());
        Label tripPrice = new Label("from \n" + PriceText + "EGP");
        Label tripPayment = new Label("from \n" + PaymentText + "EGP");
        Label tripID = new Label("ID: " + trip.getTrip_id());
        Label tripType = new Label("Trip's type: " + trip.getTripType());
        Label tripSD = new Label("Start Date: " + trip.getStartDate());
        Label tripED = new Label("End Date: " + trip.getEndDate());
        Label tripTransportation = new Label("Transportation: " + trip.getTransportation());

        styleVBox(tripImage, tripBox, tripName, stylingBox, finalBox, detailsBox, tripPrice, tripPayment);

        stylingBox.getChildren().addAll(tripImage, detailsBox, tripPayment);
        detailsBox.getChildren().addAll(tripName, location, tripID, tripType, tripSD, tripED, tripTransportation);
        tripBox.getChildren().addAll(stylingBox);

        return tripBox;
    }

    public static void styleVBox(ImageView tripImage, VBox tripBox, Label tripName, HBox stylingBox, VBox finalBox, VBox detailsBox, Label tripPrice, Label tripPayment) {

        tripImage.setFitHeight(150);
        tripImage.setFitWidth(250);

        stylingBox.setAlignment(Pos.CENTER_LEFT);
        stylingBox.setSpacing(50);
        finalBox.setSpacing(20);
        detailsBox.setSpacing(10);
        finalBox.setAlignment(Pos.BOTTOM_CENTER);
        detailsBox.setAlignment(Pos.BOTTOM_LEFT);

        tripName.setStyle("-fx-font-weight:bold; -fx-font-size:20px");

        tripBox.setStyle("-fx-padding:20px 0px 20px 0px; -fx-border-style: solid; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: ffae00;");
        tripPrice.setStyle("-fx-font-weight:bold;");
        tripPayment.setStyle("-fx-font-weight:bold;");

    }

}
