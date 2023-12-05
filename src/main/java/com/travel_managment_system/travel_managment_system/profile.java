package com.travel_managment_system.travel_managment_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class profile {
    @FXML
    private TextField TUserText;

    @FXML
    private TextField TageText;

    @FXML
    private TextField TnameText;

    @FXML
    private PasswordField TpassText;

    @FXML
    private TextField TphoneText;

    @FXML
    private AnchorPane Tprofile;
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
        Parent root = FXMLLoader.load(getClass().getResource("Tprofile.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Tprofile.getScene().getWindow().hide();

    }

}
