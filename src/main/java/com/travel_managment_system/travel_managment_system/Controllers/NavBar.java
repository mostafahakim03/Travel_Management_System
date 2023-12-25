package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class NavBar implements Loadfxml {
    @FXML
    private Button HomeButton;
    @FXML
    private Button Salary;
    @FXML
    private Button MyProfile_btn;

    @FXML
    private Button MyTrip_btn;

    @FXML
    private ImageView logo;

    public void set() {
        if (User.isTourGuide) Salary.setVisible(true);
        if (Admin.Admin_is_Opned) dis_Button();
    }

    public void dis_Button() {
        Salary.setDisable(true);
        MyProfile_btn.setDisable(true);
    }

    @FXML
    void CProfileClicked(ActionEvent event) throws IOException {
        if (User.isTourGuide) {
            lodafxmlfile("UTprofile.fxml");
            UTProfileController UTProfileController = new UTProfileController();
            UTProfileController.initialize();
        } else
            lodafxmlfile("UCprofile.fxml");
        HomeButton.getScene().getWindow().hide();
    }

    @FXML
    void HomeClicked(ActionEvent event) throws IOException {
        if (User.isTourGuide) lodafxmlfile("TGHomepage.fxml");
        else
            lodafxmlfile("CHomepage.fxml");
        HomeButton.getScene().getWindow().hide();
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //logging out code
            if (Admin.Admin_is_Opned) {
                ACustomer_Card.Booking=false;
                AHomepage aHomepage = new AHomepage();
                aHomepage.showAhome();
            } else
                lodafxmlfile("Uhello-view.fxml");
            HomeButton.getScene().getWindow().hide();
        }
    }

    @FXML
    void myTripsClicked(ActionEvent event) throws IOException {
        if (User.isTourGuide) lodafxmlfile("TGTrips.fxml");
        else
            lodafxmlfile("CMyTrips.fxml");
        HomeButton.getScene().getWindow().hide();
    }

    @FXML
    void salaryClicked(ActionEvent event) throws IOException {
        lodafxmlfile("TGSalary.fxml");
        UTProfileController UTProfileController = new UTProfileController();
        UTProfileController.initialize();
        HomeButton.getScene().getWindow().hide();
    }

}
