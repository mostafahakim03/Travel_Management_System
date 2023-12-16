package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TicketController implements Loadfxml{
    @FXML
    public Label ticketIDLabel=new Label();
    @FXML
    public Label tripDateLabel=new Label();
    @FXML
    public Label userLabel=new Label();
    @FXML
    public Label priceLabel;
    @FXML
    public Label tripNameLabel=new Label();
    @FXML
    public Button confirmButton=new Button();
    @FXML
    public AnchorPane TicketAnchor;
    @FXML
    public Label tripTypeLabel=new Label();
    @FXML
    private Label carDetails = new Label();
    @FXML
    private Label hotelDetails=new Label();

    @FXML
    private Label numOfTickets=new Label();

    @FXML
    private Label packageType = new Label();

    @FXML
    private HBox seatNumberHBox=new HBox();

    @FXML
    private Label TripIDLabel = new Label();

    @FXML
    private ImageView tripImage=new ImageView();

    @FXML
    private Label BookingDate=new Label();



    public void initialize() throws FileNotFoundException {
        Trip trip = Trip.selectedTrip;

        Ticket.selectedTicket.ticket_price=Ticket.selectedTicket.numberOfReservedTickets* Trip.selectedTrip.getPrice();

        ticketIDLabel.setText(String.valueOf(Ticket.selectedTicket.TicketID));
        tripNameLabel.setText(trip.getTripName());
        TripIDLabel.setText(String.valueOf(Ticket.selectedTicket.trip_id));
        tripDateLabel.setText(trip.getStartDate().toString());
        tripTypeLabel.setText(trip.getTripType());
        priceLabel.setText(String.valueOf(Ticket.selectedTicket.ticket_price));
        numOfTickets.setText(String.valueOf(Ticket.selectedTicket.numberOfReservedTickets));
        carDetails.setText(Ticket.selectedTicket.car.getCarname() + " " + Ticket.selectedTicket.car.getCarmodel());
        hotelDetails.setText(Ticket.selectedTicket.roomType);
        packageType.setText(Ticket.selectedTicket.packageType);
        BookingDate.setText(String.valueOf(Ticket.selectedTicket.booking_date));
        userLabel.setText(Customer.selectedCustomer.getUsername());



        for(int i=0; i<Ticket.selectedTicket.numberOfReservedTickets;i++){
            Label seatnum= new Label();
            seatnum.setText(String.valueOf(Ticket.selectedTicket.seatNumber.get(i)+"    "));
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
    @FXML
    void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("Cprofile.fxml");
        TicketAnchor.getScene().getWindow().hide();
    }
    @FXML
    void HomeClicked(ActionEvent event) throws IOException{
        lodafxmlfile("CHomepage.fxml");
        TicketAnchor.getScene().getWindow().hide();
    }
    @FXML
    void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK)  {
//            logging out code
            lodafxmlfile("hello-view.fxml");
            TicketAnchor.getScene().getWindow().hide();

        }
    }
    @FXML
    void myTripsClicked(ActionEvent event) throws IOException{
        lodafxmlfile("CMyTrips.fxml");
        TicketAnchor.getScene().getWindow().hide();
    }
}
