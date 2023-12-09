package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.spi.ResourceBundleControlProvider;

public class FlightController implements Initializable {


    @FXML
    private AnchorPane FlightAnchor;
    @FXML
    private ImageView Flightview;
    @FXML
    private ChoiceBox<String> Select_seat;
    private  String[] Myseat= {"1"};
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
            FlightAnchor.getScene().getWindow().hide();
        }


    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        FlightAnchor.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cprofile.fxml"));
        //profile profile=new profile();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        FlightAnchor.getScene().getWindow().hide();
        //profile.initialize();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;
            root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
            FlightAnchor.getScene().getWindow().hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
         Select_seat.getItems().addAll(Myseat);
    }
}

