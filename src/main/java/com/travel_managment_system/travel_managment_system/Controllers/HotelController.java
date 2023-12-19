package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HotelController implements Initializable, Loadfxml {
    @FXML
    private HBox Nav_Box;
    @FXML
    public AnchorPane HotelAnchor;
    @FXML
    public Label hotelNameLabel;
    @FXML
    private ProgressBar progressBar2;
    @FXML
    public Label locationLabel;


    @FXML
    public ChoiceBox<String> roomtype1;
    @FXML
    public Label Alertmsg;
    @FXML
    public Button HomeButton;
    @FXML
    private ImageView HotelImage;
    private final String[] roomtypes = {"Single", "Couple", "Triple"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomtype1.getItems().addAll(roomtypes);
        ;
        hotelNameLabel.setText(Trip.selectedTrip.getHotel().getHotelName());
        locationLabel.setText(Trip.selectedTrip.getHotel().getHotellocation());
        Trip.selectedTrip.getHotel().setRoomType(roomtype1.getValue());
        FileInputStream imageInput = null;
        try {
            imageInput = new FileInputStream(Trip.selectedTrip.getHotel().getHotelImage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(imageInput);
        HotelImage.setImage(image);
        progressBar2.setStyle("-fx-accent: #FA8B02;");
        try {
            Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void Next1() throws IOException {
        if (roomtype1.getValue() == null) {
            Alertmsg.setVisible(true);
        } else {
            Ticket.selectedTicket.roomType = roomtype1.getValue();
            System.out.println(roomtype1.getValue());
            lodafxmlfile("Car.fxml");
            HotelAnchor.getScene().getWindow().hide();
        }

    }



}

