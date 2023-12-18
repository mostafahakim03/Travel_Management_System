package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
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

public class CMyTrips implements Loadfxml {
    @FXML
    private HBox Nav_Box;

    public AnchorPane CMyTrips;
    public VBox tripsVBox;

    @FXML
    private void initialize()  throws IOException{
        tripsVBox.getChildren().clear();
        try {
            displayTrips();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));

    }
    public void displayTrips() throws FileNotFoundException {

        for(Ticket ticket: Customer.selectedCustomer.tickets){
        for (Trip trip : Trip.trips) {
                if(trip.getTrip_id()==ticket.trip_id){
                VBox tripBox = createTripVBox(trip,ticket);
                tripsVBox.getChildren().add(tripBox);
                }
            }

        }

    }
    private VBox createTripVBox(Trip trip,Ticket ticket) throws FileNotFoundException {
        VBox tripBox = new VBox();
        VBox detailsBox = new VBox();
        VBox finalBox = new VBox();

        HBox stylingBox = new HBox();

        FileInputStream imageInput = new FileInputStream(trip.getTripImage());
        Image image = new Image(imageInput);
        ImageView tripImage = new ImageView(image);


        String PriceText = Double.toString(ticket.ticket_price);

        Label tripName = new Label(trip.getTripName());
        Label tripPrice = new Label("from \n" + PriceText + "EGP");

        Label tripID = new Label("ID: " + trip.getTrip_id());
        Label tripType = new Label("Trip's type: " + trip.getTripType());
        Label tripSD = new Label("Start Date: " + trip.getStartDate());
        Label tripED = new Label("End Date: " + trip.getEndDate());
        Label tripTransportation = new Label("Transportation: "+trip.getTransportation());
        Button viewTrip = new Button("View trip");
        viewTrip.setOnAction(event -> {
            try {
                for (Trip trips: Customer.selectedCustomer.myTrips) {
                    if(trip.getTrip_id()== trips.getTrip_id()){
                        Trip.selectedTrip=trips;
                        Ticket.selectedTicket=ticket;
                    }
                }
                TicketController ticketController=new TicketController();
                ticketController.initialize();
                lodafxmlfile("TicketScene.fxml");
                CMyTrips.getScene().getWindow().hide();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        styleVBox(tripImage, viewTrip, tripBox, tripName, stylingBox, finalBox, detailsBox, tripPrice);

        finalBox.getChildren().addAll(tripPrice,viewTrip);
        stylingBox.getChildren().addAll(tripImage, detailsBox, finalBox);
        detailsBox.getChildren().addAll(tripName, tripID, tripType, tripSD, tripED,tripTransportation);
        tripBox.getChildren().addAll(stylingBox);

        return tripBox;
    }


    public static void styleVBox(ImageView tripImage, Button viewTrip, VBox tripBox, Label tripName,
                                 HBox stylingBox, VBox finalBox, VBox detailsBox, Label tripPrice) {

        tripImage.setFitHeight(150);
        tripImage.setFitWidth(250);

        stylingBox.setSpacing(50);
        finalBox.setSpacing(20);
        detailsBox.setSpacing(10);
        finalBox.setAlignment(Pos.BOTTOM_CENTER);
        detailsBox.setAlignment(Pos.BOTTOM_LEFT);

        tripName.setStyle("-fx-font-weight:bold; -fx-font-size:20px");
        viewTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#ffae00; -fx-border-width:2px; -fx-border-color:#ffae00;");

        viewTrip.setOnMouseEntered(e -> viewTrip.setStyle("-fx-background-color: #ffae00; -fx-text-fill: white; -fx-border-width:2px; -fx-border-color:#ffae00; "));
        viewTrip.setOnMouseExited(e -> viewTrip.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#ffae00; -fx-border-width:2px; -fx-border-color:#ffae00;"));

        tripBox.setStyle("-fx-padding:20px 0px 20px 0px; -fx-border-style: solid; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: ffae00;");
        tripPrice.setStyle("-fx-font-weight:bold;");

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
            CMyTrips.getScene().getWindow().hide();
        }
    }

public void HomeClicked(ActionEvent event) throws IOException {
    System.out.println("Going home!");
    Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
    CMyTrips.getScene().getWindow().hide();
}

    public void CProfileClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cprofile.fxml"));
        //profile profile=new profile();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        CMyTrips.getScene().getWindow().hide();
        //profile.initialize();

    }
    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
        CMyTrips.getScene().getWindow().hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
