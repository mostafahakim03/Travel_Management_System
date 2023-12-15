package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Hotel;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class serviseController implements Initializable ,Loadfxml {
    @FXML
    public AnchorPane HotelAnchor;
    @FXML
    public Label hotelNameLabel;
    @FXML
    public Label locationLabel;
    @FXML
    public ChoiceBox<String>  roomtype1;
    @FXML
    public Label hotelNameLabel2;
    @FXML
    public Label locationLabel2;
    @FXML
    public ChoiceBox<String>  roomtype2;
    @FXML
    public Label hotelNameLabel3;
    @FXML
    public Label locationLabel3;
    @FXML
    public ChoiceBox<String>  roomtype3;
    @FXML
    public Label Alertmsg11;
    @FXML
    public Label Alertmsg1;
    @FXML
    public Label Alertmsg;
    @FXML
    public Button HomeButton;
    private String[] roomtypes={"Single","Couple","Triple"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomtype1.getItems().addAll(roomtypes);
        roomtype2.getItems().addAll(roomtypes);
        roomtype3.getItems().addAll(roomtypes);
        Hotel hotel = new Hotel("Sonesta San George","Luxor");
        Hotel hotel2 = new Hotel("Nefertiti Hotel","Luxor");
        Hotel hotel3 = new Hotel("Iberotel","Luxor");
        Trip.selectedTrip.setHotel(hotel);
        hotelNameLabel.setText(hotel.getHotelName());
        hotelNameLabel2.setText("Nefertiti Hotel");
        hotelNameLabel3.setText("Iberotel");
        locationLabel.setText(hotel.getHotellocation());
        locationLabel2.setText("Awamiya , Luxor");
        locationLabel3.setText("Awamiya , Luxor");
    }


    public void Next1() throws IOException {
        if(roomtype1.getValue()==null){
            Alertmsg.setVisible(true);
        } else {
            Ticket.selectedTicket.roomType=roomtype1.getValue();
            System.out.println(roomtype1.getValue());
            lodafxmlfile("Car.fxml");
            HotelAnchor.getScene().getWindow().hide();
        }

    }
    public void Next2() throws IOException {
        if(roomtype2.getValue()==null){
            Alertmsg1.setVisible(true);
        } else {
            Ticket.selectedTicket.roomType=roomtype2.getValue();
           lodafxmlfile("Car.fxml");
            HotelAnchor.getScene().getWindow().hide();
        }

    }
    public void Next3() throws IOException {
        if(roomtype3.getValue()==null){
            Alertmsg1.setVisible(true);
        } else {
            Ticket.selectedTicket.roomType=roomtype3.getValue();
            lodafxmlfile("Car.fxml");
            HotelAnchor.getScene().getWindow().hide();
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
            HotelAnchor.getScene().getWindow().hide();
        }


    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        lodafxmlfile("CHomepage.fxml");
        HotelAnchor.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("Cprofile.fxml");
        HotelAnchor.getScene().getWindow().hide();
        //profile.initialize();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        HotelAnchor.getScene().getWindow().hide();

    }
}

