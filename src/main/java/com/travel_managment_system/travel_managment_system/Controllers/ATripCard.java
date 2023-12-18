package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ATripCard {
    @FXML
    private Label TId, TendDate, Tlocation, Tname, Tpayment, Tprice, TstartDate, Ttype, bookedTicket, Transportation;
    @FXML
    private ImageView Timage;


    public void setData(Trip trip) throws FileNotFoundException {

        Tname.setText(trip.getTripName());
        Tprice.setText(String.valueOf(trip.getPrice()));
        Tpayment.setText(String.valueOf(trip.getPayment()));
        Ttype.setText(trip.getTripType());
        TId.setText(String.valueOf(trip.getTrip_id()));
        Tlocation.setText(trip.getLocation());
        TstartDate.setText(String.valueOf(trip.getStartDate()));
        TendDate.setText(String.valueOf(trip.getEndDate()));
        FileInputStream fileInputStream = new FileInputStream(trip.getTripImage());
        Image image = new Image(fileInputStream);
        Timage.setImage(image);
        Transportation.setText(trip.getTransportation());
        bookedTicket.setText(String.valueOf(50 - trip.getNumberOfAvailableSeats()));
    }
}
