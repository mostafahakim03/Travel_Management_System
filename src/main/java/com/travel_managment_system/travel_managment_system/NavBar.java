package com.travel_managment_system.travel_managment_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;


public class NavBar implements Loadfxml{
    @FXML
    private Button HomeButton;



    @FXML
    void CProfileClicked(ActionEvent event) throws IOException {
            lodafxmlfile("Cprofile.fxml");
            HomeButton.getScene().getWindow().hide();
    }

    @FXML
    void HomeClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CHomepage.fxml");
        HomeButton.getScene().getWindow().hide();
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //logging out code
            lodafxmlfile("hello-view.fxml");
            HomeButton.getScene().getWindow().hide();
        }
    }

    @FXML
    void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        HomeButton.getScene().getWindow().hide();
    }

}
