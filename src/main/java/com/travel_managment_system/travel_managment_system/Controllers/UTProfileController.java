package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class UTProfileController implements Loadfxml {
    @FXML
    private HBox Nav_Box = new HBox();
    @FXML
    private Label TAge = new Label();

    @FXML
    private Label TName = new Label();

    @FXML
    private Label TPassword = new Label();

    @FXML
    private Label TPhonenumber = new Label();

    @FXML
    private TextField TUserText = new TextField();

    @FXML
    private Label TUsername = new Label();

    @FXML
    private TextField TageText = new TextField();

    @FXML
    private TextField TnameText = new TextField();

    @FXML
    private TextField TpassText = new TextField();

    @FXML
    private TextField TphoneText = new TextField();

    @FXML
    private AnchorPane labanchor;

    @FXML
    private AnchorPane labanchor2;


    public void initialize() throws IOException {
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
        Nav_Box.getChildren().clear();
        Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));

    }

    public void Update() {
        TourGuide tourGuide1;
        if (TUsername.getText().equals(TUserText.getText()))
            tourGuide1 = new TourGuide(TnameText.getText(), "-1", TpassText.getText(), TphoneText.getText(), TageText.getText(), TourGuide.selectedTourGuide.getGuideID());
        else
            tourGuide1 = new TourGuide(TnameText.getText(), TUserText.getText(), TpassText.getText(), TphoneText.getText(), TageText.getText(), TourGuide.selectedTourGuide.getGuideID());
        String check = tourGuide1.check_signup(true);
        if (check.equals("done")) {
            TourGuide.selectedTourGuide.setName(TnameText.getText());
            TourGuide.selectedTourGuide.setAge(TageText.getText());
            TourGuide.selectedTourGuide.setPass(TpassText.getText());
            TourGuide.selectedTourGuide.setPhone(TphoneText.getText());
            TourGuide.selectedTourGuide.setUsername(TUserText.getText());

            for (TourGuide tourguide : TourGuide.TourguideAcc) {
                if (TourGuide.selectedTourGuide.getGuideID().equals(tourguide.getGuideID())) {
                    tourguide.setName(TourGuide.selectedTourGuide.getName());
                    tourguide.setAge(TourGuide.selectedTourGuide.getAge());
                    tourguide.setAge(TourGuide.selectedTourGuide.getAge());
                    tourguide.setPhone(TourGuide.selectedTourGuide.getPhone());
                    tourguide.setUsername(TourGuide.selectedTourGuide.getUsername());
                    break;
                }
            }
        } else Admin.Error_Alert(TAge.getScene().getWindow(), check, "Error");
    }


    @FXML
    void TEdit(ActionEvent event) throws IOException {
        labanchor.setVisible(true);
        labanchor2.setVisible(false);
        initialize();
    }

    @FXML
    void TSave(ActionEvent event) throws IOException {
        labanchor.setVisible(false);
        labanchor2.setVisible(true);
        Update();
        initialize();


    }
}

