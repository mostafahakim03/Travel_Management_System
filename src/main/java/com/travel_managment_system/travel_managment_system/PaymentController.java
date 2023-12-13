package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController {
    @FXML
    private AnchorPane paymentAnchor;
    @FXML

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //logging out code
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            paymentAnchor.getScene().getWindow().hide();
            }
    }
    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        paymentAnchor.getScene().getWindow().hide();
    }
    public void TProfileClicked(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("CMyProfile.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            paymentAnchor.getScene().getWindow().hide();

        }
    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;
        if(TourGuide.isTourGuide) {
            root = FXMLLoader.load(getClass().getResource("TTrips.fxml"));
            paymentAnchor.getScene().getWindow().hide();
        }
        else {
            root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
            paymentAnchor.getScene().getWindow().hide();
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void SubmitButton() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("TicketScene.fxml"));
        //profile profile=new profile();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        paymentAnchor.getScene().getWindow().hide();
    }

}



