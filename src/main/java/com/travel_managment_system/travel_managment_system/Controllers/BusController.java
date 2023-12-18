package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BusController implements Initializable, Loadfxml {
    @FXML
    private HBox Nav_Box;
    @FXML
    private AnchorPane BusAnchor;
    @FXML
    private AnchorPane AddAnchor;
    @FXML
    private Label BusNumber;
    @FXML
    private Button Nextbtn;
    @FXML
    private Label alertText;
    @FXML
    private ComboBox<Integer> Select_seat = new ComboBox<>();

    public int numberOfSeats;
    public int BnumberOfSeats;


    public void trip_busSwitch() throws IOException {
        lodafxmlfile("Bus.fxml");
        numberOfSeats = Ticket.selectedTicket.numberOfReservedTickets;
    }

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            lodafxmlfile("Uhello-view.fxml");
            BusAnchor.getScene().getWindow().hide();
        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        lodafxmlfile("CHomepage.fxml");
        BusAnchor.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("UCprofile.fxml");
        BusAnchor.getScene().getWindow().hide();
        //profile.initialize();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        BusAnchor.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Select_seat.getItems().clear();
        Trip.selectedTrip.bus.FillarrSeats();
        Select_seat.getItems().addAll(Trip.selectedTrip.bus.Seats);
        BnumberOfSeats = Ticket.selectedTicket.numberOfReservedTickets;
        try {
            Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addSeatNumber() {
        if (Select_seat.getValue() == null) {
            alertText.setVisible(true);
        } else {
            Ticket.selectedTicket.seatNumber.add(Select_seat.getValue());
            Select_seat.getItems().remove(Select_seat.getValue());
            BnumberOfSeats--;
            if (BnumberOfSeats == 0) {
                AddAnchor.setVisible(false);
                Nextbtn.setVisible(true);
            }
        }
    }

    public void BNext() throws IOException {
        lodafxmlfile("Hotel.fxml");
        BusAnchor.getScene().getWindow().hide();

    }
}
