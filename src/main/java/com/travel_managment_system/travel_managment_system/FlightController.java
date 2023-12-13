package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.spi.ResourceBundleControlProvider;

public class FlightController implements Initializable ,Loadfxml {


    @FXML
    private AnchorPane FlightAnchor;
    @FXML
    private AnchorPane AddAnchor;
    @FXML
    private Button Nextbtn;
    @FXML
    private ImageView Flightview;
//    @FXML
//    private ChoiceBox<Integer> Select_seat;
    @FXML
    private ComboBox<Integer> Select_seat=new ComboBox<>();
    public Integer[] Myseat = new Integer[50];
    public int FnumberOfSeats;

    @FXML
    private Label alertText;

    public void FillArr(){
        for(int i=0;i<50;i++){
            Myseat[i]= i+1;
        }
    }
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
        FillArr();
            Select_seat.getItems().addAll(Myseat);
        FnumberOfSeats= Ticket.selectedTicket.numberOfReservedTickets;

    }

    public void addSeatNumber(){
        if(Select_seat.getValue()==null)
        {
            alertText.setVisible(true);
        }
        else {
            Ticket.selectedTicket.seatNumber.add(Select_seat.getValue());
            System.out.println(FnumberOfSeats);
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

