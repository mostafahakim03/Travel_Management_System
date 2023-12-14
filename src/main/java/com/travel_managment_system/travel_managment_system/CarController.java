package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Itinerary.Itinerary;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
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
import java.net.URL;
import java.util.ResourceBundle;

public class CarController implements Initializable , Loadfxml{
    @FXML
    private ImageView Car1;
    @FXML
    private ImageView Car2;
    @FXML
    private ImageView Car3;
    @FXML
    private AnchorPane CarAnchor;
    @FXML
    private AnchorPane CarAnchor1;
    @FXML
    private Button HomeButton;
    @FXML
    private ChoiceBox<Integer> numOfDays = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> numOfDays1 = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> numOfDays2 =new ChoiceBox<>();
    public Integer[] NumOfRentalDays = new Integer[3];
    public void FillArr(){
        for(int i=0;i<3;i++){
            NumOfRentalDays[i]= i+1;
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
            //logging out code
            lodafxmlfile("hello-view.fxml");
            CarAnchor.getScene().getWindow().hide();
        }
    }
    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
       lodafxmlfile("CHomepage.fxml");
        CarAnchor.getScene().getWindow().hide();
    }
    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        CarAnchor.getScene().getWindow().hide();

    }
    public void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("Cprofile.fxml");
        CarAnchor.getScene().getWindow().hide();
        //profile.initialize();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FillArr();
        numOfDays.getItems().addAll(NumOfRentalDays);
        numOfDays1.getItems().addAll(NumOfRentalDays);
        numOfDays2.getItems().addAll(NumOfRentalDays);
    }
    public void Next() throws IOException {
       lodafxmlfile("Intinerary.fxml");
        CarAnchor.getScene().getWindow().hide();
        ItineraryController itineraryController = new ItineraryController();
        itineraryController.initialize();
    }
}