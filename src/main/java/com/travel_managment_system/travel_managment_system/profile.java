package com.travel_managment_system.travel_managment_system;

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
    private Label TAge;

    @FXML
    private Label TName;

    @FXML
    private Label TPassword;

    @FXML
    private Label TPhonenumber;

    @FXML
    private TextField TUserText;

    @FXML
    private Label TUsername;

    @FXML
    private TextField TageText;

    @FXML
    private TextField TnameText;

    @FXML
    private TextField TpassText;

    @FXML
    private TextField TphoneText;

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

    @FXML
    void TEdit(ActionEvent event) {
        labanchor.setVisible(true);
        labanchor2.setVisible(false);
    }
    @FXML
    void TSave(ActionEvent event) {
        labanchor.setVisible(false);
        labanchor2.setVisible(true);
    }
}
