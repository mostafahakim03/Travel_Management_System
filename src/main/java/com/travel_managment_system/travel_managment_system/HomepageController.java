package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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


public class HomepageController  {
    @FXML
    public AnchorPane THomepageAnchor;
    @FXML
    public AnchorPane CHomepageAnchor;

    @FXML
    private VBox tripsVBox;





    public void initialize() throws FileNotFoundException {


        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(new Trip("Luxor",1000,"family","2023-12-5","2023-12-29",20,3000,10000,"src/main/java/com/travel_managment_system/travel_managment_system/luxorPhoto.jpg"));
        trips.add(new Trip("Alexandria",1001,"couple","2023-12-5","2023-12-28",30,400,7000,"src/main/java/com/travel_managment_system/travel_managment_system/Alexandria.jpeg"));

        displayTrips(trips); // Update the ListView with available trips
    }
    private void displayTrips(ArrayList<Trip> trips) throws FileNotFoundException {
        for (Trip trip : trips) {
            VBox tripBox = createTripVBox(trip);
            tripsVBox.getChildren().add(tripBox);
        }
    }
    private VBox createTripVBox (Trip trip) throws FileNotFoundException {
        VBox tripBox = new VBox();
        VBox detailsBox=new VBox();
        VBox finalBox=new VBox();

        HBox stylingBox=new HBox();

        FileInputStream imageInput = new FileInputStream(trip.tripImage);
        Image image = new Image(imageInput);
        ImageView tripImage= new ImageView(image);

        String PriceText=Double.toString(trip.price);
        String PaymentText=Double.toString(trip.payment);

        Label tripName=new Label(trip.tripName);
        Label tripPrice=new Label("from \n"+PriceText+"EGP");
        Label tripPayment=new Label("from \n"+PaymentText+"EGP");
        Button viewTrip= new Button("View trip");
        Label tripID=new Label("ID " + trip.trip_id);
        Label tripType=new Label("Trip's type " + trip.tripType);
        Label tripSD=new Label("Start Date: " + trip.start_date);
        Label tripED=new Label("End Date: " + trip.end_date);

         if (THomepageAnchor.isVisible()) {
            finalBox.getChildren().addAll(tripPayment, viewTrip);
        }
        else if (CHomepageAnchor.isVisible()) {
            finalBox.getChildren().addAll(tripPrice, viewTrip);
        }


        stylingBox.getChildren().addAll(tripImage, detailsBox,finalBox);
        detailsBox.getChildren().addAll(tripName, tripID, tripType, tripSD, tripED);
        tripBox.getChildren().addAll(stylingBox);

        return tripBox;
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
            if(THomepageAnchor.getScene()!=null) {
                THomepageAnchor.getScene().getWindow().hide();
            }
            else if(CHomepageAnchor.getScene()!=null) {
                CHomepageAnchor.getScene().getWindow().hide();
            }
        }
    }

    public void THomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("THomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        THomepageAnchor.getScene().getWindow().hide();
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Tprofile.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        THomepageAnchor.getScene().getWindow().hide();

    }


}

