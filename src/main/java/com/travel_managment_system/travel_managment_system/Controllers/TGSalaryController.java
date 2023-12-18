package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TGSalaryController implements Loadfxml, Initializable {
    @FXML
    private HBox Nav_Box;

    private final LocalDate thisDate = LocalDate.now();
    private final int thisMonth = thisDate.getMonthValue();
    private final int thisYear = thisDate.getYear();
    private final int lastDayOfThisMonth = thisDate.lengthOfMonth();

    @FXML
    private AnchorPane SalaryAnchor;
    @FXML
    private Button salaryButton;
    @FXML
    private VBox tripsVBox;
    @FXML
    private Label numOfMonthlyTrips;
    @FXML
    private Button collectButton;
    @FXML
    private AnchorPane salaryBox;
    @FXML
    private Label salaryLabel;
    @FXML
    private Label notification;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tripsVBox.getChildren().clear();
        try {
            DisplayMonthlyTrips();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void DisplayMonthlyTrips() throws FileNotFoundException {

        ArrayList<Trip> monthlyTrips = TourGuide.selectedTourGuide.getAssignedTrips().stream()
                .filter(trip -> (trip.getStartDate().isAfter(LocalDate.of(thisYear, thisMonth, 1))))
                .filter(trip -> trip.getStartDate().isBefore(LocalDate.of(thisYear, thisMonth, lastDayOfThisMonth)))
                .collect(Collectors.toCollection(ArrayList::new));

        numOfMonthlyTrips.setText("Your trip count this month is " + monthlyTrips.size() + ", scroll down to view your salary.");

        Double calculateSalary = 0.0;
        for (Trip trip : monthlyTrips) {
            calculateSalary = calculateSalary + trip.getPayment();
            VBox tripBox = createVBox(trip);
            tripsVBox.getChildren().add(tripBox);
        }
        TourGuide.selectedTourGuide.setSalary(calculateSalary);
        salaryLabel.setText(calculateSalary + "EGP");

        collectButton.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#fa8b02; -fx-border-width:2px; -fx-border-color:#fa8b02;");
        collectButton.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#fa8b02; -fx-border-width:2px; -fx-border-color:#fa8b02;");

        collectButton.setOnMouseEntered(e -> collectButton.setStyle("-fx-background-color: #ffae00; -fx-text-fill: white; -fx-border-width:2px; -fx-border-color:#fa8b02; "));
        collectButton.setOnMouseExited(e -> collectButton.setStyle("-fx-background-color:#ffffff; -fx-text-fill:#fa8b02; -fx-border-width:2px; -fx-border-color:#fa8b02;"));

        tripsVBox.getChildren().add(salaryBox);

    }

    public void CollectButtonClicked() {
        collectButton.setDisable(true);
        notification.setVisible(true);
        if (LocalDate.now().isEqual(LocalDate.of(thisYear, thisMonth, lastDayOfThisMonth))) {
            tripsVBox.getChildren().clear();
            notification.setText("Salary collected! Come back next month.");

        } else {
            notification.setText("Please wait till the end of the month.");
        }

    }

    public VBox createVBox(Trip trip) throws FileNotFoundException {
        VBox tripBox = new VBox(); //returned VBox
        VBox detailsBox = new VBox(); //VBox that contains the trips relevant details
        HBox aligningBox = new HBox(); //HBox that styles all components horizontally

        FileInputStream imageInput = new FileInputStream(trip.getTripImage());
        Image image = new Image(imageInput);
        ImageView tripImage = new ImageView(image);


        Label tripName = new Label(trip.getTripName());
        Label tripID = new Label("Trip id: " + trip.getTrip_id());
        Label tripPayment = new Label(trip.getPayment() + "EGP");

        detailsBox.getChildren().addAll(tripName, tripID);
        aligningBox.getChildren().addAll(tripImage, detailsBox, tripPayment);
        tripBox.getChildren().add(aligningBox);

        styleVBox(tripImage, tripBox, tripName, aligningBox, detailsBox, tripPayment);
        return tripBox;
    }


    public static void styleVBox(ImageView tripImage, VBox tripBox, Label tripName,
                                 HBox aligningBox, VBox detailsBox, Label tripPayment) {

        tripImage.setFitHeight(150);
        tripImage.setFitWidth(250);
        tripImage.setStyle("-fx-background-radius: 20;");

        aligningBox.setAlignment(Pos.TOP_LEFT);
        aligningBox.setSpacing(80);
        detailsBox.setSpacing(10);
        detailsBox.setAlignment(Pos.TOP_LEFT);
        tripBox.setAlignment(Pos.TOP_LEFT);

        tripName.setStyle("-fx-font-weight:bold; -fx-font-size:20px; -fx-text-fill:#ffae00;");
        tripBox.setStyle("-fx-padding:20px 0px 20px 0px; -fx-border-style: solid; -fx-border-width: 0px 0px 1px 0px; -fx-border-color: ffae00;");
        tripPayment.setStyle("-fx-font-weight:bold; -fx-text-alignment:right;");
    }


    public void HomeClicked(ActionEvent event) throws IOException {
        lodafxmlfile("TGHomepage.fxml");
        SalaryAnchor.getScene().getWindow().hide();
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("UTprofile.fxml");
        SalaryAnchor.getScene().getWindow().hide();
        UTProfileController UTProfileController = new UTProfileController();
        UTProfileController.initialize();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("TGTrips.fxml");
        SalaryAnchor.getScene().getWindow().hide();
    }

    public void salaryClicked(ActionEvent event) {
        salaryButton.setDisable(true);
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
            lodafxmlfile("Uhello-view.fxml");
            SalaryAnchor.getScene().getWindow().hide();
        }
    }

}
