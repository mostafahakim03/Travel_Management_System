package com.travel_managment_system.travel_managment_system;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class usercontroller {
        @FXML
        private Button btn1;
        @FXML
        private AnchorPane signup_anch;
        public void btn() throws IOException {
            Parent root= FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene =new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
            btn1.getScene().getWindow().hide();

        }
        public void signup_btn()  {
            signup_anch.setVisible(true);
        }
        public void sign_tour() throws IOException {
            Parent root= FXMLLoader.load(getClass().getResource("signup_tour.fxml"));
            Scene scene =new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
            btn1.getScene().getWindow().hide();

        }
        public void sign_cust() throws IOException {
            Parent root= FXMLLoader.load(getClass().getResource("signup_cust.fxml"));
            Scene scene =new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
            btn1.getScene().getWindow().hide();

        }

    }
