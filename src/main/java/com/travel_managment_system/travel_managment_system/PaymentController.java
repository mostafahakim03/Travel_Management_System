package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PaymentController implements Loadfxml {
    @FXML
    private AnchorPane paymentAnchor;
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

    public void SubmitButton() throws IOException {
        lodafxmlfile("TicketScene.fxml");
        paymentAnchor.getScene().getWindow().hide();

        for (Customer customer : Customer.CoustomerAcc) {
            if (customer.getUsername().equals(Customer.selectedCustomer.getUsername())) {
                customer.numberOfReservedTickets=Customer.selectedCustomer.numberOfReservedTickets;
                customer.tickets.add(Ticket.selectedTicket);
                System.out.println(customer.tickets.get(0).TicketID + " "+ customer.tickets.get(0).car.getCarname() + " "+customer.tickets.get(0).car.getCarmodel()+" "+customer.tickets.get(0).seatNumber);
                break;
            }
        }
        if(Trip.selectedTrip.getTransportation()=="Plane"){
            FlightController flightController=new FlightController();
            flightController.AvailableSeats.stream()
                    .filter(trip -> Ticket.selectedTicket.seatNumber==flightController.Seats)
                    .collect(Collectors.toCollection(ArrayList::new));
            System.out.println(flightController.AvailableSeats);
        }



    }

    }



