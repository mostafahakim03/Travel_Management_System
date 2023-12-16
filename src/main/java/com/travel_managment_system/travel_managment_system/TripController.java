package com.travel_managment_system.travel_managment_system;
import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TripController implements Initializable ,Loadfxml{
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
    private String[] packages = {"Silver", "Golden" , "Platinum"};

    public void ViewTripDetails(Trip trip) throws IOException {

        Trip.selectedTrip=trip;
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
    }

    public void getPackage(ActionEvent event){
        String packageType = String.valueOf(packageTypeChoice.getValue());
        if (packageType.equals("Silver")) {
            PackageMessageLabel.setText("The trip contains only the transportation and half-board");
            Trip.selectedTrip.setPackageType(packageType);
        } else if (packageType.equals("Golden")) {
            PackageMessageLabel.setText("The trip contains the transportation and full-board");
            Trip.selectedTrip.setPackageType(packageType);
        } else if (packageType.equals("Platinum")) {
            PackageMessageLabel.setText("The trip contains the transportation, full-board and activities");
            Trip.selectedTrip.setPackageType(packageType);
        }

    }

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            lodafxmlfile("hello-view.fxml");
            TripHome.getScene().getWindow().hide();
        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        lodafxmlfile("CHomepage.fxml");
        TripHome.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("Cprofile.fxml");
        TripHome.getScene().getWindow().hide();
        //profile.initialize();

    }
    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        TripHome.getScene().getWindow().hide();


    }

    public void Booking(ActionEvent actionEvent) throws IOException {


        int numbersOfTickets = 0;
        try {
            numbersOfTickets = Integer.parseInt(numbersOfTicketsInputs.getText());
        }
        catch (NumberFormatException e)
        {
            System.out.println(e);
        }

        if (tripTypeLabel.getText().toLowerCase().equals("family") && numbersOfTickets < 3){
            NoOfTicketsMessageLabel1.setText("The minimum number for the tickets is 3");
        }
        else if (tripTypeLabel.getText().toLowerCase().equals("couple") && numbersOfTickets % 2 != 0){
            NoOfTicketsMessageLabel1.setText("Tickets must be Even number");
        }
        else if (packageTypeChoice.getValue() == null || numbersOfTickets == 0) {
            checkLabel.setVisible(true);
        }
       else if(Customer.selectedCustomer.myTrips.contains(Trip.selectedTrip))
        {
            NoOfTicketsMessageLabel1.setText(("You already reserved in this trips one. Find in more trips at home."));
        }
        else {
                NoOfTicketsMessageLabel1.setText("");
                Ticket.selectedTicket=new Ticket();
                Ticket.selectedTicket.numberOfReservedTickets = numbersOfTickets;
                Ticket.selectedTicket.packageType = packageTypeChoice.getValue();
                Ticket.selectedTicket.trip_id = Trip.selectedTrip.getTrip_id();
                Ticket.selectedTicket.TicketID=Trip.selectedTrip.tickets.size()+1;

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