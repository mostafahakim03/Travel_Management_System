package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.User.Customer.Hotel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AHotel_Card {
    @FXML
    private ImageView Hotel_image;

    @FXML
    private Label Location;

    @FXML
    private Label Name;


    public void set_data(Hotel hotel) throws FileNotFoundException {
        Name.setText(hotel.getHotelName());
        Location.setText(hotel.getHotellocation());
        FileInputStream fileInputStream = new FileInputStream(hotel.getHotelImage());
        Image image = new Image(fileInputStream);
        Hotel_image.setImage(image);
    }


}
