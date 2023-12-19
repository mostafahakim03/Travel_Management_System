package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FlightController implements Initializable, Loadfxml {

    @FXML
    private HBox Nav_Box;
    ///////////////////////////////////////
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
    private ComboBox<Integer> Select_seat = new ComboBox<>();

    public int FnumberOfSeats;

    @FXML
    private Label alertText;


    public void trip_flightSwitch() throws IOException {
        lodafxmlfile("Flight.fxml");
        FnumberOfSeats = Ticket.selectedTicket.numberOfReservedTickets;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Select_seat.getItems().clear();
        Trip.selectedTrip.flight.FillarrSeats();
        Select_seat.getItems().addAll(Trip.selectedTrip.flight.Seats);
        FnumberOfSeats = Ticket.selectedTicket.numberOfReservedTickets;
        progressBar.setStyle("-fx-accent: #FA8B02;");


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
            int chosenSeat = Select_seat.getValue();
            Ticket.selectedTicket.seatNumber.add(Select_seat.getValue());
            Select_seat.getItems().remove(Select_seat.getValue());
            FnumberOfSeats--;
            if (FnumberOfSeats == 0) {
                AddAnchor.setVisible(false);
                Nextbtn.setVisible(true);

            }
        }
    }

    public void Next() throws IOException {
        lodafxmlfile("Hotel.fxml");
        FlightAnchor.getScene().getWindow().hide();

    }
}

