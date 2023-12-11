package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
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

public class Cprofile {

    @FXML
    private Label CAge;

    @FXML
    private Label CName;

    @FXML
    private Label CPassword;

    @FXML
    private Label CPhonenumber;

    @FXML
    private TextField CUserText;

    @FXML
    private Label CUsername;

    @FXML
    private TextField CageText;

    @FXML
    private TextField CnameText;

    @FXML
    private TextField CpassText;

    @FXML
    private TextField CphoneText;

    @FXML
    private AnchorPane Cprofile;

    @FXML
    private AnchorPane Clabanchor;

    @FXML
    private AnchorPane Clabanchor2;

    @FXML
    private Button profileButton;

    public void initialize2() {
        CName.setText(Customer.selectedCustomer.getName());
        CAge.setText(Customer.selectedCustomer.getAge());
        CPassword.setText(Customer.selectedCustomer.getPass());
        CPhonenumber.setText(Customer.selectedCustomer.getPhone());
        CUsername.setText(Customer.selectedCustomer.getUsername());

        CnameText.setText(Customer.selectedCustomer.getName());
        CageText.setText(Customer.selectedCustomer.getAge());
        CpassText.setText(Customer.selectedCustomer.getPass());
        CphoneText.setText(Customer.selectedCustomer.getPhone());
        CUserText.setText(Customer.selectedCustomer.getUsername());
    }

    public void Update() {

        Customer.selectedCustomer.setName(CnameText.getText());
        Customer.selectedCustomer.setAge(CageText.getText());
        Customer.selectedCustomer.setPass(CpassText.getText());
        Customer.selectedCustomer.setPhone(CphoneText.getText());
        Customer.selectedCustomer.setUsername(CUserText.getText());

        for (Customer customer : Customer.CoustomerAcc) {
           customer.setName(Customer.selectedCustomer.getName());
            customer.setAge(Customer.selectedCustomer.getAge());
            customer.setAge(Customer.selectedCustomer.getAge());
            customer.setPhone(Customer.selectedCustomer.getPhone());
            customer.setUsername(Customer.selectedCustomer.getUsername());
        }

    }


    @FXML
    void CEdit(ActionEvent event) {
        Clabanchor.setVisible(true);
        Clabanchor2.setVisible(false);
        initialize2();
    }

    @FXML
    void CSave(ActionEvent event) {
        Clabanchor.setVisible(false);
        Clabanchor2.setVisible(true);
        Update();
        initialize2();
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
            if (Cprofile.getScene() != null) {
                Cprofile.getScene().getWindow().hide();
            } //else if (Cprofile.getScene() != null) {
            // Cprofile.getScene().getWindow().hide();
            // }
        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Cprofile.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        profileButton.setDisable(true);
    }
    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
        Cprofile.getScene().getWindow().hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }



}
