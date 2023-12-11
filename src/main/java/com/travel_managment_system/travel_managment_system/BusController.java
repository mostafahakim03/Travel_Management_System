package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BusController implements Initializable {
    @FXML
    private AnchorPane BusAnchor;
    @FXML
    private Label BusNumber;
    @FXML
    private ComboBox<Integer> Select_seat= new ComboBox<>();
    public Integer[] Myseat = new Integer[50];
    public int numberOfSeats;
    public void FillArr(){
        for(int i=0;i<50;i++){
            Myseat[i]= i+1;
        }
    }

    public void trip_busSwitch() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bus.fxml"));
        numberOfSeats= Ticket.selectedTicket.numberOfReservedTickets;
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
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
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            BusAnchor.getScene().getWindow().hide();
        }
    }
    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        BusAnchor.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cprofile.fxml"));
        //profile profile=new profile();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        BusAnchor.getScene().getWindow().hide();
        //profile.initialize();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
        BusAnchor.getScene().getWindow().hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        FillArr();
        Select_seat.getItems().addAll(Myseat);
    }

}
