package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Itinerary.Itinerary;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ItineraryController implements Loadfxml {
    @FXML
    private HBox Nav_Box = new HBox();
    @FXML
    public ImageView ActivityImg1;
    @FXML
    public ImageView ActivityImg2;
    @FXML
    public ImageView ActivityImg3;
    @FXML
    public Label ActivityLocationLabel1 = new Label();
    @FXML
    public Label StartTimeLabel1 = new Label();
    @FXML
    public Label EndTimeLabel1 = new Label();
    @FXML
    public Label ActivityLocationLabel2 = new Label();
    @FXML
    public Label StartTimeLabel2 = new Label();
    @FXML
    public Label EndTimeLabel2 = new Label();
    @FXML
    public Label ActivityLocationLabel3 = new Label();
    @FXML
    public Label StartTimeLabel3 = new Label();
    @FXML
    public Label EndTimeLabel3 = new Label();
    @FXML
    public Button NextPageButton;
    @FXML
    private Button HomeButton;
    @FXML
    private AnchorPane Itinerary;

    public void initialize() throws IOException {

        Trip.selectedTrip.setItinerary(new Itinerary());
        Trip trip = Trip.selectedTrip;

//        FileInputStream imageInput1 = new FileInputStream(trip.getItinerary().getActivities()[0].getImg());
//        Image image1 = new Image(imageInput1);
//        ActivityImg1.setImage(image1);
//
//        FileInputStream imageInput2 = new FileInputStream(trip.getItinerary().getActivities()[1].getImg());
//        Image image2 = new Image(imageInput2);
//        ActivityImg1.setImage(image2);
//
//        FileInputStream imageInput3 = new FileInputStream(trip.getItinerary().getActivities()[2].getImg());
//        Image image3 = new Image(imageInput3);
//        ActivityImg1.setImage(image3);

        ActivityLocationLabel1.setText(trip.getItinerary().getActivities()[0].getLocation());
        ActivityLocationLabel2.setText(trip.getItinerary().getActivities()[1].getLocation());
        ActivityLocationLabel3.setText(trip.getItinerary().getActivities()[2].getLocation());

        StartTimeLabel1.setText(trip.getItinerary().getActivities()[0].getStartTime());
        StartTimeLabel2.setText(trip.getItinerary().getActivities()[1].getStartTime());
        StartTimeLabel3.setText(trip.getItinerary().getActivities()[2].getStartTime());

        EndTimeLabel1.setText(trip.getItinerary().getActivities()[0].getEndTime());
        EndTimeLabel2.setText(trip.getItinerary().getActivities()[1].getEndTime());
        EndTimeLabel3.setText(trip.getItinerary().getActivities()[2].getEndTime());

        Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));

    }

    public void NextButtonPressed() throws IOException {

        lodafxmlfile("TicketPayment.fxml");
        Itinerary.getScene().getWindow().hide();

    }

    @FXML
    void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("UCprofile.fxml");
        Itinerary.getScene().getWindow().hide();
        UCProfileController UCProfileController = new UCProfileController();
        UCProfileController.initialize();
    }

    @FXML
    void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        lodafxmlfile("CHomepage.fxml");
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

        if (alert.showAndWait().get() == ButtonType.OK) {
            //logging out code
            lodafxmlfile("Uhello-view.fxml");
            Itinerary.getScene().getWindow().hide();

        }
    }

    @FXML
    void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        Itinerary.getScene().getWindow().hide();
    }

}