package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FlightController implements Initializable ,Loadfxml {


    @FXML
    private AnchorPane FlightAnchor;
    @FXML
    private AnchorPane AddAnchor;
    @FXML
    private Button Nextbtn;
    @FXML
    private ImageView Flightview;

    @FXML
    private ProgressBar progressBar;
//    @FXML
//    private ChoiceBox<Integer> Select_seat;
    @FXML
    private ComboBox<Integer> Select_seat=new ComboBox<>();

    public int FnumberOfSeats;

    @FXML
    private Label alertText;


    public void trip_flightSwitch() throws IOException {
       lodafxmlfile("Flight.fxml");
        FnumberOfSeats= Ticket.selectedTicket.numberOfReservedTickets;
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
            lodafxmlfile("hello-view.fxml");
            FlightAnchor.getScene().getWindow().hide();
        }


    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
       lodafxmlfile("CHomepage.fxml");
        FlightAnchor.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("Cprofile.fxml");
        FlightAnchor.getScene().getWindow().hide();
        //profile.initialize();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
       lodafxmlfile("CMyTrips.fxml");
        FlightAnchor.getScene().getWindow().hide();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Select_seat.getItems().clear();
        Trip.selectedTrip.flight.FillarrSeats();
            Select_seat.getItems().addAll(Trip.selectedTrip.flight.Seats);
        FnumberOfSeats= Ticket.selectedTicket.numberOfReservedTickets;
        progressBar.setStyle("-fx-accent: #FA8B02;");
    }

    public void addSeatNumber(){
        if(Select_seat.getValue()==null)
        {
            alertText.setVisible(true);
        }
        else {
            int chosenSeat=Select_seat.getValue();
            Ticket.selectedTicket.seatNumber.add(Select_seat.getValue());
            Select_seat.getItems().remove((Integer)Select_seat.getValue());
            FnumberOfSeats--;
            if(FnumberOfSeats==0){
                AddAnchor.setVisible(false);
                Nextbtn.setVisible(true);

            }
        }
    }
    public void Next() throws IOException {
      lodafxmlfile("servise.fxml");
        FlightAnchor.getScene().getWindow().hide();

    }
}

