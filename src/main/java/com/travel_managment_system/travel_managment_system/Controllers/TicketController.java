package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.IOException;

public class TicketController implements Loadfxml {
    @FXML
    private HBox Nav_Box = new HBox();
    @FXML
    public Label ticketIDLabel = new Label();
    @FXML
    public Label tripDateLabel = new Label();
    @FXML
    public Label userLabel = new Label();
    @FXML
    public Label priceLabel = new Label();
    @FXML
    public Label tripNameLabel = new Label();
    @FXML
    public Button confirmButton = new Button();
    @FXML
    public AnchorPane TicketAnchor = new AnchorPane();
    @FXML
    public Label tripTypeLabel = new Label();
    @FXML
    private Label carDetails = new Label();
    @FXML
    private Label hotelDetails = new Label();

    @FXML
    private Label numOfTickets = new Label();

    @FXML
    private Label packageType = new Label();

    @FXML
    private HBox seatNumberHBox = new HBox();

    @FXML
    private Label TripIDLabel = new Label();

    @FXML
    private ImageView tripImage = new ImageView();

    @FXML
    private Label BookingDate = new Label();


    public void initialize() throws IOException {
        Trip trip = Trip.selectedTrip;

        ticketIDLabel.setText(String.valueOf(Ticket.selectedTicket.TicketID));
        tripNameLabel.setText(trip.getTripName());
        TripIDLabel.setText(String.valueOf(Ticket.selectedTicket.trip_id));
        tripDateLabel.setText(trip.getStartDate().toString());
        tripTypeLabel.setText(trip.getTripType());
        priceLabel.setText(Ticket.selectedTicket.ticket_price + "EGP");
        numOfTickets.setText(String.valueOf(Ticket.selectedTicket.numberOfReservedTickets));
        if(Ticket.selectedTicket.car.getCarname() != null && Ticket.selectedTicket.car.getCarmodel() != 0){
            carDetails.setText(Ticket.selectedTicket.car.getCarname() + " " + Ticket.selectedTicket.car.getCarmodel());
        }
        else carDetails.setText("There is no car ");
        hotelDetails.setText(Ticket.selectedTicket.roomType);
        packageType.setText(Ticket.selectedTicket.packageType);
        BookingDate.setText(String.valueOf(Ticket.selectedTicket.booking_date));
        userLabel.setText(Customer.selectedCustomer.getUsername());
        Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));

        for (int i = 0; i < Ticket.selectedTicket.numberOfReservedTickets; i++) {

            Label seatnum = new Label();
            seatnum.setText(Ticket.selectedTicket.seatNumber.get(i) + "    ");
            seatnum.setStyle("-fx-font-family: Segoe Print; -fx-text-fill:#fa8b02; -fx-font-size:18px;");
            seatNumberHBox.getChildren().add(seatnum);
        }

        FileInputStream imageInput = new FileInputStream(trip.getTripImage());
        Image image = new Image(imageInput);
        tripImage.setImage(image);

    }

    @FXML
    public void ConfirmButtonClicked() throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        TicketAnchor.getScene().getWindow().hide();
    }
}
