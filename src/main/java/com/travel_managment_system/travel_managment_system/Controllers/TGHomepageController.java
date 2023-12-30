package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import com.travel_managment_system.travel_managment_system.User.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class TGHomepageController extends ParentController implements Loadfxml {
    @FXML
    private HBox Nav_Box = new HBox();
    @FXML
    public AnchorPane THomepageAnchor = new AnchorPane();
    @FXML
    public AnchorPane CHomepageAnchor = new AnchorPane();
    @FXML
    private VBox tripsVBox = new VBox();

    public void thomepage() throws IOException {
        TGHomepageController homepage = new TGHomepageController();
        homepage.displayTrips();
        lodafxmlfile("TGHomepage.fxml");

    }

    public void initialize() throws IOException {
        tripsVBox.getChildren().clear();
        displayTrips(); // Update the VBox with available trips
        Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));

    }

    public void displayTrips() throws FileNotFoundException {

        ArrayList<Trip> filteredTrips; //the updated, filtered ArrayList.
        if (User.isTourGuide) {
            filteredTrips = Trip.trips.stream()
                    .filter(trip -> !trip.isTourGuideComplete()) //filters the trips that have empty places for tour guides.
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            filteredTrips = Trip.trips.stream()
                    .filter(trip -> trip.getNumberOfAvailableSeats() > 0) //filters the trips that have available seats.
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        for (Trip trip : filteredTrips) { //a foreach loop that adds each tripbox that contains a trip inside the tripsVBox

            VBox tripBox = createTripVBox(trip);
            tripsVBox.getChildren().add(tripBox);
        }

    }

    public VBox createTripVBox(Trip trip) throws FileNotFoundException {
        Trip.selectedTrip = trip;
        VBox tripBox = new VBox();  //returned VBox, the one that is added to the tripvbox
        VBox detailsBox = new VBox(); //VBox that contains all important details
        VBox finalBox = new VBox(); //VBox that contains view/assign buttons and the payment/price

        HBox stylingBox = new HBox(); //HBox that aligns the detailsBox and finalBox

        FileInputStream imageInput = new FileInputStream(trip.getTripImage()); //gets the url string.
        Image image = new Image(imageInput); //puts the input inside an image.
        ImageView tripImage = new ImageView(image); //puts the image inside the imageview.

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
        Label tripRemainingSeats = new Label(50 - Trip.selectedTrip.getNumberOfAvailableSeats() + " / 50");
        Label tripRemainingTourGuides = new Label(trip.getAssignedTourGuides().size() + " / 2");
        Button viewTrip = new Button("View trip");
        Button assignTrip = new Button("Assign Trip");
        viewTrip.setOnAction(event -> {
            try {

                int id= Integer.parseInt(tripID.getText().substring(4));
                for (Trip trip1:Trip.trips)
                {
                    if(id==trip1.getTrip_id()){
                        Trip.selectedTrip=trip1;
                        break;
                    }
                }
                lodafxmlfile("Trip.fxml");
                CHomepageAnchor.getScene().getWindow().hide();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        assignTrip.setOnAction(event -> {

            Boolean tripClashes = false;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Trip");
            alert.setHeaderText("Trip cannot be added");


            for (Trip trips : TourGuide.selectedTourGuide.getAssignedTrips()) {
                if ((trip.getStartDate().isAfter(trips.getStartDate()) && trip.getStartDate().isBefore(trips.getEndDate())) || (trip.getEndDate().isAfter(trips.getStartDate()) && trip.getEndDate().isBefore(trips.getEndDate()))) {
                    tripClashes = true;
                    break;
                }
            }
            if (TourGuide.selectedTourGuide.checkExists(TourGuide.selectedTourGuide.getAssignedTrips())) {
                alert.setContentText("You are already assigned to this trip. You can find it in My Trips.");
            alert.showAndWait();
            }
            else if (tripClashes) {
                alert.setContentText("You have time clash between this trip and another.");
             alert.showAndWait();
            } else {
                for (TourGuide tourguide : TourGuide.TourguideAcc) {
                    if (tourguide.getGuideID().equals(TourGuide.selectedTourGuide.getGuideID())) {
                        tourguide.FillAssignedTrips(trip);

                        trip.FillAssignedTourGuides(tourguide);
                        trip.setTouGuideComplete(trip.getAssignedTourGuides().size() == 2);

                                                        alert.setHeaderText("Trip added");
                                                        alert.setContentText("You're now assigned to this trip. You can find it in My Trips.");
                                                        alert.showAndWait();
                              if (alert.showAndWait().get() == ButtonType.OK) {
                            try {
                                lodafxmlfile("TGHomepage.fxml");
                                THomepageAnchor.getScene().getWindow().hide();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        break;
                    }


                }
            }});

            styleVBox(tripImage, viewTrip, assignTrip, tripBox, tripName, stylingBox, finalBox, detailsBox, tripPrice, tripPayment);


            if (TourGuide.isTourGuide) {
                finalBox.getChildren().addAll(tripPayment, tripRemainingTourGuides, assignTrip);
            } else {
                finalBox.getChildren().addAll(tripPrice, tripRemainingSeats, viewTrip);
            }


            stylingBox.getChildren().addAll(tripImage, detailsBox, finalBox);
            detailsBox.getChildren().addAll(tripName, location, tripID, tripType, tripSD, tripED, tripTransportation);
            tripBox.getChildren().addAll(stylingBox);

            return tripBox;

    }

        public static void styleVBox (ImageView tripImage, Button viewTrip, Button assignTrip, VBox tripBox, Label
        tripName,
                HBox stylingBox, VBox finalBox, VBox detailsBox, Label tripPrice, Label tripPayment){

            tripImage.setFitHeight(150);
            tripImage.setFitWidth(250);

            stylingBox.setAlignment(Pos.CENTER_LEFT);
            stylingBox.setSpacing(50);
            finalBox.setSpacing(20);
            detailsBox.setSpacing(10);
            finalBox.setAlignment(Pos.BOTTOM_CENTER);
            detailsBox.setAlignment(Pos.BOTTOM_LEFT);

            tripName.setStyle("-fx-font-weight:bold; -fx-font-size:20px");
            viewTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#fa8b02; -fx-border-width:2px; -fx-border-color:#fa8b02;");
            assignTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#fa8b02; -fx-border-width:2px; -fx-border-color:#fa8b02;");

            viewTrip.setOnMouseEntered(e -> viewTrip.setStyle("-fx-background-color: #fa8b02; -fx-text-fill: white; -fx-border-width:2px; -fx-border-color:#fa8b02; "));
            viewTrip.setOnMouseExited(e -> viewTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#fa8b02; -fx-border-width:2px; -fx-border-color:#fa8b02;"));

            assignTrip.setOnMouseEntered(e -> assignTrip.setStyle("-fx-background-color: #fa8b02; -fx-text-fill: white; -fx-border-width:2px; -fx-border-color:#fa8b02; "));
            assignTrip.setOnMouseExited(e -> assignTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#fa8b02; -fx-border-width:2px; -fx-border-color:#fa8b02;"));
            tripBox.setStyle("-fx-padding:20px 0px 20px 0px; -fx-border-style: solid; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: #fa8b02;");
            tripPrice.setStyle("-fx-font-weight:bold;");
            tripPayment.setStyle("-fx-font-weight:bold;");

        }
    }