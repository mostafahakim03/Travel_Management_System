package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class usercontroller {

    @FXML
    private Label ErrorMessage;
    @FXML
    private Button btn1;
    @FXML
    private AnchorPane signup_anch;
    @FXML
    private TextField TUserText;
    @FXML
    private TextField TageText;
    @FXML
    private TextField TidText;
    @FXML
    private TextField TnameText;
    @FXML
    private PasswordField TpassText;
    @FXML
    private TextField TphoneText;



    public void btn() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        btn1.getScene().getWindow().hide();


    }

    public void signup_btn() {
        signup_anch.setVisible(true);
    }

    public void sign_tour() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signup_tour.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        btn1.getScene().getWindow().hide();



    }

    public void sign_cust() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signup_cust.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        btn1.getScene().getWindow().hide();


    }

    public void TsubmitSignup() throws IOException {
        TourGuide.newidAcc.add(100);
        TourGuide tourGuide = new TourGuide(TnameText.getText(), TUserText.getText(), TpassText.getText(), TphoneText.getText(), TageText.getText(), TidText.getText());
        String test = tourGuide.check_signup();
        if (test.equals("done")) {
            TourGuide.TourguideAcc.add(tourGuide);
            TourGuide.selectedTourGuide=tourGuide;
            TourGuide.isTourGuide=true;
            TnameText.getScene().getWindow().hide();
            thomepage();



        }
        ErrorMessage.setText(test);
    }
    void thomepage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("THomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }




}
