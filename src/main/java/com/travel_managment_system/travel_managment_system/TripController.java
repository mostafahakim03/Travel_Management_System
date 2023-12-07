package com.travel_managment_system.travel_managment_system;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TripController implements Initializable {
    @FXML
    private Button BookingButton;
    @FXML
    private Label ChoiceLabel;
    @FXML
    private Label NoOfTicketsMessageLabel1;
    @FXML
    private Label PackageMessageLabel;
    @FXML
    private AnchorPane TripHome;
    @FXML
    private Label TripNameLabel;
    @FXML
    private Label end_dateLabel;
    @FXML
    private ImageView imgView;
    @FXML
    private TextField numbersOfTicketsInputs;
    @FXML
    private ChoiceBox<String> packageTypeChoice;
    @FXML
    private Label priceLabel;
    @FXML
    private Label start_dateLabel;
    @FXML
    private Label tripTypeLabel;
    @FXML
    private String[] packages = {"Silver", "Golden" , "Platinum"};

    public void ViewTripDetails(Trip trip){
        TripNameLabel.setText(trip.tripName);
        tripTypeLabel.setText(trip.tripType);
        start_dateLabel.setText(trip.start_date);
        end_dateLabel.setText(trip.end_date);
        priceLabel.setText(String.valueOf(trip.price));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        packageTypeChoice.getItems().addAll(packages);
        packageTypeChoice.setOnAction(this::getPackage);
    }

    public void getPackage(ActionEvent event){
        String packageType = String.valueOf(packageTypeChoice.getValue());
        ChoiceLabel.setText("You chose : " + packageType);
        if (packageType.equals("Silver")) {
            PackageMessageLabel.setText("The trip contains only the transportation and half-board");
        } else if (packageType.equals("Golden")) {
            PackageMessageLabel.setText("The trip contains the transportation and full-board");
        } else if (packageType.equals("Platinum")) {
            PackageMessageLabel.setText("The trip contains the transportation, full-board and activities");
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
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            TripHome.getScene().getWindow().hide();
        }
    }

    public void THomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("THomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        TripHome.getScene().getWindow().hide();
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Tprofile.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        TripHome.getScene().getWindow().hide();

    }



    public void Booking(ActionEvent actionEvent) {

        int numbersOfTickets = Integer.parseInt(numbersOfTicketsInputs.getText());

        if (tripTypeLabel.getText().equals("family") && numbersOfTickets < 3){
            NoOfTicketsMessageLabel1.setText("The minimum number for the tickets is 3");
        }
        else if (tripTypeLabel.getText().equals("couple") && numbersOfTickets % 2 != 0){
            NoOfTicketsMessageLabel1.setText("Tickets must be Even number");
        } else
            NoOfTicketsMessageLabel1.setText("");

    }

}
