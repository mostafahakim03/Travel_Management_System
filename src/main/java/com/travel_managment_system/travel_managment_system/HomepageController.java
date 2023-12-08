package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
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


public class HomepageController {
    @FXML
    public AnchorPane THomepageAnchor;
    @FXML
    public AnchorPane CHomepageAnchor;
    @FXML
    private AnchorPane NotificationPane;

    @FXML
    private VBox tripsVBox;
    @FXML
    private Button HomeButton;
    @FXML
    private Button ShortCutButton;



    public void initialize() throws FileNotFoundException {
        Trip.trips.clear();
        Trip.trips.add(new Trip("Luxor", 1000, "Family", "2023-12-5", "2023-12-29", 20, 3000, 10000, "src/main/java" +
                "/com/travel_managment_system/travel_managment_system/luxorPhoto.jpg","Luxor"));
        Trip.trips.add(new Trip("Alexandria", 1001, "Couple", "2023-12-5", "2023-12-28", 30, 400, 7000, "src/main" +
                "/java/com/travel_managment_system/travel_managment_system/Alexandria.jpeg","Alexandria"));
        displayTrips(Trip.trips); // Update the ListView with available trips
    }

    private void displayTrips(ArrayList<Trip> trips) throws FileNotFoundException {


        for (Trip trip : trips) {

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
        Label tripPrice = new Label("from \n" + PriceText + "EGP");
        Label tripPayment = new Label("from \n" + PaymentText + "EGP");
        Label tripID = new Label("ID: " + trip.getTrip_id());
        Label tripType = new Label("Trip's type: " + trip.getTripType());
        Label tripSD = new Label("Start Date: " + trip.getStart_date());
        Label tripED = new Label("End Date: " + trip.getEnd_date());
        Button viewTrip = new Button("View trip");
        Button assignTrip = new Button("Assign Trip");
        viewTrip.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Trip.fxml"));
                Parent tripDetailsParent = loader.load();
                TripController tripDetailsController = loader.getController();
                tripDetailsController.ViewTripDetails(trip);
                Scene scene = new Scene(tripDetailsParent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                CHomepageAnchor.getScene().getWindow().hide();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        assignTrip.setOnAction(event ->{
            for (TourGuide tourguide: TourGuide.TourguideAcc){
                if(TourGuide.selectedTourGuide.getGuideID().equals(tourguide.getGuideID())){
                    tourguide.FillAssignedTrips(trip);
                    NotificationPane.setVisible(true);
                    ShortCutButton.setDisable(false);
                    break;
                }
            }

        });

        styleVBox(tripImage, viewTrip, assignTrip, tripBox, tripName, stylingBox, finalBox, detailsBox, tripPrice, tripPayment);


        if (TourGuide.isTourGuide) {
            finalBox.getChildren().addAll(tripPayment, assignTrip);
        } else {
            finalBox.getChildren().addAll(tripPrice, viewTrip);
        }


        stylingBox.getChildren().addAll(tripImage, detailsBox, finalBox);
        detailsBox.getChildren().addAll(tripName, tripID, tripType, tripSD, tripED);
        tripBox.getChildren().addAll(stylingBox);

        return tripBox;
    }

    public static void styleVBox(ImageView tripImage, Button viewTrip, Button assignTrip, VBox tripBox, Label tripName,
                                 HBox stylingBox, VBox finalBox, VBox detailsBox, Label tripPrice, Label tripPayment) {

        tripImage.setFitHeight(150);
        tripImage.setFitWidth(250);

        stylingBox.setSpacing(50);
        finalBox.setSpacing(20);
        detailsBox.setSpacing(10);
        finalBox.setAlignment(Pos.BOTTOM_CENTER);
        detailsBox.setAlignment(Pos.BOTTOM_LEFT);

        tripName.setStyle("-fx-font-weight:bold; -fx-font-size:20px");
        viewTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#ffae00; -fx-border-width:2px; -fx-border-color:#ffae00;");
        assignTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#ffae00; -fx-border-width:2px; -fx-border-color:#ffae00;");

        viewTrip.setOnMouseEntered(e -> viewTrip.setStyle("-fx-background-color: #ffae00; -fx-text-fill: white; -fx-border-width:2px; -fx-border-color:#ffae00; "));
        viewTrip.setOnMouseExited(e -> viewTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#ffae00; -fx-border-width:2px; -fx-border-color:#ffae00;"));

        assignTrip.setOnMouseEntered(e -> assignTrip.setStyle("-fx-background-color: #ffae00; -fx-text-fill: white; -fx-border-width:2px; -fx-border-color:#ffae00; "));
        assignTrip.setOnMouseExited(e -> assignTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#ffae00; -fx-border-width:2px; -fx-border-color:#ffae00;"));
        tripBox.setStyle("-fx-padding:20px 0px 20px 0px; -fx-border-style: solid; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: ffae00;");
        tripPrice.setStyle("-fx-font-weight:bold;");
        tripPayment.setStyle("-fx-font-weight:bold;");

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
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            if (TourGuide.isTourGuide) {
                THomepageAnchor.getScene().getWindow().hide();
            } else {
                CHomepageAnchor.getScene().getWindow().hide();
            }
        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        HomeButton.setDisable(true);
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Tprofile.fxml"));
        profile profile=new profile();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        THomepageAnchor.getScene().getWindow().hide();
        profile.initialize();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;

        if(TourGuide.isTourGuide) {
            root = FXMLLoader.load(getClass().getResource("TTrips.fxml"));
            THomepageAnchor.getScene().getWindow().hide();
        }
        else {
            root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
            CHomepageAnchor.getScene().getWindow().hide();
        }
        profile profile=new profile();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        profile.initialize();
    }



}