package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;


public class NavBar implements Loadfxml{
    @FXML
    private Button HomeButton;
    @FXML
    private Button Salary;
    @FXML
    private Button MyProfile_btn;

    @FXML
    private Button MyTrip_btn;


    public void set(){
        if(User.isTourGuide)Salary.setVisible(true);
if(Admin.Admin_is_Opned)dis_Button();
    }
    public void dis_Button(){
     Salary.setDisable(true);
     MyTrip_btn.setDisable(true);
     MyProfile_btn.setDisable(true);
     HomeButton.setDisable(true);
    }

    @FXML
    void CProfileClicked(ActionEvent event) throws IOException {
        if(User.isTourGuide) {
            lodafxmlfile("Tprofile.fxml");
            profile profile = new profile();
            profile.initialize();
        }else
            lodafxmlfile("Cprofile.fxml");
            HomeButton.getScene().getWindow().hide();
    }

    @FXML
    void HomeClicked(ActionEvent event) throws IOException {
        if(User.isTourGuide)   lodafxmlfile("THomepage.fxml");
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
            if(Admin.Admin_is_Opned) {
                AHomepage aHomepage=new AHomepage();
                aHomepage.showAhome();
            }
            else
            lodafxmlfile("hello-view.fxml");
            HomeButton.getScene().getWindow().hide();
        }
    }

    @FXML
    void myTripsClicked(ActionEvent event) throws IOException {
      if(User.isTourGuide)   lodafxmlfile("TTrips.fxml");
      else
        lodafxmlfile("CMyTrips.fxml");
        HomeButton.getScene().getWindow().hide();
    }
    @FXML
    void salaryClicked(ActionEvent event) throws IOException {
        lodafxmlfile("TSalary.fxml");
        profile profile=new profile();
        profile.initialize();
        HomeButton.getScene().getWindow().hide();
    }

}