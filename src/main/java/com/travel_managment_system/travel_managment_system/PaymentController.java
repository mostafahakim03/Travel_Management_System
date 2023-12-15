package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class PaymentController implements Loadfxml {
    @FXML
    private AnchorPane paymentAnchor;

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
        Parent root;
        if(TourGuide.isTourGuide) {
            root = FXMLLoader.load(getClass().getResource("TTrips.fxml"));
            paymentAnchor.getScene().getWindow().hide();
        }
        else {
           lodafxmlfile("CMyTrips.fxml");
            paymentAnchor.getScene().getWindow().hide();
        }


    }

    }



