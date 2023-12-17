package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.Customer.Flight;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PaymentController implements Loadfxml {
    @FXML
    private AnchorPane paymentAnchor;

    @FXML
    TextField visaNumberTextField = new TextField();
    @FXML
    Label alertLabel = new Label();

    @FXML
    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            lodafxmlfile("hello-view.fxml");
            paymentAnchor.getScene().getWindow().hide();
        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        lodafxmlfile("CHomepage.fxml");
        paymentAnchor.getScene().getWindow().hide();
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyProfile.fxml");
        paymentAnchor.getScene().getWindow().hide();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        paymentAnchor.getScene().getWindow().hide();
    }

    public void CancelTrip() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelling trip");
        alert.setHeaderText("All information you just entered will not be saved!");
        alert.setContentText("Are you sure you want to cancel the trip?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            lodafxmlfile("CHomepage.fxml");
            paymentAnchor.getScene().getWindow().hide();
        }
    }

    public void SubmitButton() throws IOException {
        lodafxmlfile("TicketScene.fxml");
        paymentAnchor.getScene().getWindow().hide();
        Trip.selectedTrip.setNumberOfAvailableSeats(Trip.selectedTrip.getNumberOfAvailableSeats() - Ticket.selectedTicket.numberOfReservedTickets);
//        Ticket.selectedTicket.ticket_price=Customer.selectedCustomer.checkDiscount(Ticket.selectedTicket.numberOfReservedTickets,Trip.selectedTrip.getPrice());
        Customer.selectedCustomer.myTrips.add(Trip.selectedTrip);
        for (Customer customer : Customer.CoustomerAcc) {
            if (customer.getUsername().equals(Customer.selectedCustomer.getUsername())) {
                customer.tickets.add(Ticket.selectedTicket);
                customer.myTrips = Customer.selectedCustomer.myTrips;
                break;
            }
        }
        Trip.selectedTrip.tickets.add(Ticket.selectedTicket);
        for (Trip trip : Trip.trips) {
            if (trip.getTrip_id() == Trip.selectedTrip.getTrip_id()) {
                if (trip.getTransportation() == "Plane") {
                    for (Integer seat : Ticket.selectedTicket.seatNumber) {
                        trip.flight.Seats.remove(seat);
                    }

                }
                if (trip.getTransportation() == "Bus") {
                    for (Integer seat : Ticket.selectedTicket.seatNumber) {
                        trip.bus.Seats.remove(seat);
                    }
                }
            }
        }


    }


}






