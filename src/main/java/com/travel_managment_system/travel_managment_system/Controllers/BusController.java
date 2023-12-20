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
    private ProgressBar busprogressBar;
    @FXML
    private ComboBox<Integer> Select_seat = new ComboBox<>();

    public int numberOfSeats;
    public int BnumberOfSeats;


    public void trip_busSwitch() throws IOException {
        lodafxmlfile("Bus.fxml");
        numberOfSeats = Ticket.selectedTicket.numberOfReservedTickets;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Select_seat.getItems().clear();
        Trip.selectedTrip.bus.FillarrSeats();
        Select_seat.getItems().addAll(Trip.selectedTrip.bus.Seats);
        BnumberOfSeats = Ticket.selectedTicket.numberOfReservedTickets;
        busprogressBar.setStyle("-fx-accent: #FA8B02;");
        BusNumber.setText("1965");
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
