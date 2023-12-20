package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.User.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

import javafx.scene.layout.AnchorPane;

import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import javafx.animation.FadeTransition;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class UScreen implements Initializable ,Loadfxml{
    @FXML
    private ProgressBar loading;

    @FXML
    private ImageView loadingImageView;

    @FXML
    private AnchorPane parent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start();
        loading.setStyle("-fx-accent: #fa8b02;");
    }



    public void start(){
        FadeTransition fadeTransition= User.fade_Screen(0,1,parent);
        fadeTransition.onFinishedProperty().set(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                parent.getScene().getWindow().hide();
                try {
                    lodafxmlfile("Uhello-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });



    }
}

