package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TripController implements Initializable, Loadfxml {
    @FXML
    public Label checkTicket;
    @FXML
    private HBox Nav_Box = new HBox();
    @FXML
    public Label locationLabel;
    @FXML
    public Label checkLabel;
    @FXML
    private Label NoOfTicketsMessageLabel1;
    @FXML
    private Label PackageMessageLabel;
    @FXML
    private AnchorPane TripHome;
    @FXML
    private Label TripNameLabel;
    @FXML
    private Label end_dateLabel;
    @FXML
    private ImageView imgView;
    @FXML
    private TextField numbersOfTicketsInputs;
    @FXML
    private ChoiceBox<String> packageTypeChoice;
    @FXML
    private Label priceLabel;
    @FXML
    private Label start_dateLabel;
    @FXML
    private Label tripTypeLabel;
    @FXML
    private final String[] packages = {"Silver", "Golden", "Platinum"};

    public void ViewTripDetails(Trip trip) throws IOException {

        Trip.selectedTrip = trip;
        FileInputStream imageInput = new FileInputStream(trip.getTripImage());
        Image image = new Image(imageInput);
        imgView.setImage(image);

        TripNameLabel.setText(trip.getTripName());
        tripTypeLabel.setText(trip.getTripType());
        start_dateLabel.setText(trip.getStartDate().toString());
        end_dateLabel.setText(trip.getEndDate().toString());
        priceLabel.setText(String.valueOf(trip.getPrice()));
        locationLabel.setText(trip.getLocation());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        packageTypeChoice.getItems().addAll(packages);
        packageTypeChoice.setOnAction(this::getPackage);
        packageTypeChoice.setValue("Select Package");
        try {
            Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void getPackage(ActionEvent event) {
        String packageType = String.valueOf(packageTypeChoice.getValue());
        if (packageType.equals("Silver")) {
            PackageMessageLabel.setText("The trip contains only the transportation and half-board");
            Trip.selectedTrip.setPackageType(packageType);
        } else if (packageType.equals("Golden")) {
            PackageMessageLabel.setText("The trip contains the transportation and full-board.The price will increase by 10% over the sum.");
            Trip.selectedTrip.setPackageType(packageType);
        } else if (packageType.equals("Platinum")) {
            PackageMessageLabel.setText("The trip contains the transportation, full-board and activities. The price will increase by 25% over the sum.");
            Trip.selectedTrip.setPackageType(packageType);
        }

    }


    public void Booking(ActionEvent actionEvent) throws IOException {


        int numbersOfTickets = 0;
        try {
            numbersOfTickets = Integer.parseInt(numbersOfTicketsInputs.getText());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        if (tripTypeLabel.getText().equalsIgnoreCase("family") && numbersOfTickets < 3) {
            NoOfTicketsMessageLabel1.setText("The minimum number for the tickets is 3");
        } else if (tripTypeLabel.getText().equalsIgnoreCase("couple") && numbersOfTickets % 2 != 0) {
            NoOfTicketsMessageLabel1.setText("Tickets must be Even number");
        } else if (packageTypeChoice.getValue() == null || numbersOfTickets == 0) {
            checkLabel.setVisible(true);
        } else if (Customer.selectedCustomer.checkExists(Customer.selectedCustomer.myTrips)) {
            NoOfTicketsMessageLabel1.setText(("You already reserved in this trips once. Find in more trips at home."));
        } else {


            NoOfTicketsMessageLabel1.setText("");
            Ticket.selectedTicket = new Ticket();
            Ticket.selectedTicket.numberOfReservedTickets = numbersOfTickets;
            Ticket.selectedTicket.packageType = packageTypeChoice.getValue();
            Ticket.selectedTicket.trip_id = Trip.selectedTrip.getTrip_id();
            Ticket.selectedTicket.TicketID = Trip.selectedTrip.tickets.size() + 1;
            Ticket.selectedTicket.ticket_price = Admin.checkDiscount(Ticket.selectedTicket.numberOfReservedTickets, Trip.selectedTrip.getPrice(), Ticket.selectedTicket.packageType,Customer.selectedCustomer);

            for (Ticket ticket: Customer.selectedCustomer.tickets) {
                if(ticket == Ticket.selectedTicket){
                    if(Customer.selectedCustomer.checkTicket(ticket.TicketID)) {
                        checkTicket.setVisible(true);
                        checkLabel.setVisible(true);
                        if (Trip.selectedTrip.getTransportation().equals("Plane")) {
                            FlightController flight = new FlightController();
                            flight.trip_flightSwitch();
                            TripHome.getScene().getWindow().hide();
                        } else if (Trip.selectedTrip.getTransportation().equals("Bus")) {
                            BusController bus = new BusController();
                            bus.trip_busSwitch();
                            TripHome.getScene().getWindow().hide();
                        }
                    }
                    }
                }

            if(numbersOfTickets != 0 && String.valueOf(packageTypeChoice.getValue()) != "Select Package"){
                System.out.println(numbersOfTickets);
                System.out.println(String.valueOf(packageTypeChoice.getValue()));
                if (Trip.selectedTrip.getTransportation().equals("Plane")) {
                    FlightController flight = new FlightController();
                    flight.trip_flightSwitch();
                    TripHome.getScene().getWindow().hide();
                } else if (Trip.selectedTrip.getTransportation().equals("Bus")) {
                    BusController bus = new BusController();
                    bus.trip_busSwitch();
                    TripHome.getScene().getWindow().hide();
                }
            }
        }

    }

}