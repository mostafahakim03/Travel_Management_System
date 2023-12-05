package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class profile {
    @FXML
    private Label TAge=new Label();

    @FXML
    private Label TName=new Label();

    @FXML
    private Label TPassword=new Label();

    @FXML
    private Label TPhonenumber=new Label();

    @FXML
    private TextField TUserText= new TextField();

    @FXML
    private Label TUsername=new Label();

    @FXML
    private TextField TageText= new TextField();

    @FXML
    private TextField TnameText= new TextField();

    @FXML
    private TextField TpassText= new TextField();

    @FXML
    private TextField TphoneText= new TextField();

    @FXML
    private AnchorPane Tprofile;

    @FXML
    private AnchorPane labanchor;

    @FXML
    private AnchorPane labanchor2;
    @FXML
    private Button profileButton;

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
        if (Tprofile.getScene() != null) {
            Tprofile.getScene().getWindow().hide();
        } //else if (Cprofile.getScene() != null) {
           // Cprofile.getScene().getWindow().hide();
       // }
    }
}

    public void THomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("THomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Tprofile.getScene().getWindow().hide();
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        profileButton.setDisable(true);

    }
    public void initialize()
    {
       TName.setText(TourGuide.selectedTourGuide.getName());
        TAge.setText(TourGuide.selectedTourGuide.getAge());
        TPassword.setText(TourGuide.selectedTourGuide.getPass());
        TPhonenumber.setText(TourGuide.selectedTourGuide.getPhone());
        TUsername.setText(TourGuide.selectedTourGuide.getUsername());

        TnameText.setText(TourGuide.selectedTourGuide.getName());
        TageText.setText(TourGuide.selectedTourGuide.getAge());
        TpassText.setText(TourGuide.selectedTourGuide.getPass());
        TphoneText.setText(TourGuide.selectedTourGuide.getPhone());
        TUserText.setText(TourGuide.selectedTourGuide.getUsername());
    }

    @FXML
    void TEdit(ActionEvent event) {
        labanchor.setVisible(true);
        labanchor2.setVisible(false);
        initialize();
    }
    @FXML
    void TSave(ActionEvent event) {
        labanchor.setVisible(false);
        labanchor2.setVisible(true);
        initialize();

    }
}