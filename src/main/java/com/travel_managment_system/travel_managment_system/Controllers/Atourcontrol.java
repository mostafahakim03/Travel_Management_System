package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;

public class Atourcontrol {

    @FXML
    private Label Tage;

    @FXML
    private Label Tid, Tname, Tpas, Tphone, Tuser, TAssingnedTrips;


    @FXML
    private AnchorPane deleteANCH, editANCH, Available, NOTavailale;
    @FXML
    private Pane ParentANCH;
    @FXML
    private TextField Tour_IDEdit, Tour_USEREdit, Tour_PASSEdit, Tour_PHONEEdit, Tour_AgeEdit;
    TourGuide tourGuide;
    public void setdata(TourGuide tourGuide) {
        Tname.setText(tourGuide.getName());
        Tuser.setText(tourGuide.getUsername());
        Tpas.setText(tourGuide.getPass());
        Tphone.setText(tourGuide.getPhone());
        Tage.setText(tourGuide.getAge());
        Tid.setText(tourGuide.getGuideID());
        TAssingnedTrips.setText(String.valueOf(tourGuide.getAssignedTrips().size()));
        if (tourGuide.isAvailibility()) Available.setVisible(true);
        else NOTavailale.setVisible(true);
        disEditAnch(new ActionEvent());
        this.tourGuide=tourGuide;
    }

    @FXML
    void editTour(ActionEvent event) {
        Tid.setVisible(false);
        Tuser.setVisible(false);
        Tage.setVisible(false);
        Tphone.setVisible(false);
        Tpas.setVisible(false);
        Tour_IDEdit.setVisible(true);
        Tour_PASSEdit.setVisible(true);
        Tour_PHONEEdit.setVisible(true);
        Tour_USEREdit.setVisible(true);
        Tour_AgeEdit.setVisible(true);
        Tour_IDEdit.setText(Tid.getText());
        Tour_PASSEdit.setText(Tpas.getText());
        Tour_PHONEEdit.setText(Tphone.getText());
        Tour_USEREdit.setText(Tuser.getText());
        Tour_AgeEdit.setText(Tage.getText());
        editANCH.setVisible(true);
    }

    @FXML
    void saveEditTour(ActionEvent event) {
        TourGuide tourGuide;
        if (Tuser.getText().equals(Tour_USEREdit.getText()))
            tourGuide = new TourGuide(Tname.getText(), "-1", Tour_PASSEdit.getText(), Tour_PHONEEdit.getText(), Tage.getText(), Tour_IDEdit.getText());
        else
            tourGuide = new TourGuide(Tname.getText(), Tour_USEREdit.getText(), Tour_PASSEdit.getText(), Tour_PHONEEdit.getText(), Tage.getText(), Tour_IDEdit.getText());

        String test;
        if (Tid.getText().equals(Tour_IDEdit.getText()))
            test = Admin.Check_Add_or_edit_tour(tourGuide, false);
        else test = Admin.Check_Add_or_edit_tour(tourGuide, true);


        if (test.equals("done")) {
            for (TourGuide T : TourGuide.TourguideAcc) {
                if (Tid.getText().equals(T.getGuideID())) {
                    T.setUsername(Tour_USEREdit.getText());
                    T.setPass(Tour_PASSEdit.getText());
                    T.setPhone(Tour_PHONEEdit.getText());
                    T.setGuideID(Tour_IDEdit.getText());
                    /////////Set Labels
                    Tid.setText(T.getGuideID());
                    Tphone.setText(T.getPhone());
                    Tuser.setText(T.getUsername());
                    Tpas.setText(T.getPass());
                    break;
                }
            }
            Tour_IDEdit.setVisible(false);
            Tour_PASSEdit.setVisible(false);
            Tour_PHONEEdit.setVisible(false);
            Tour_USEREdit.setVisible(false);
            Tour_AgeEdit.setVisible(false);
            Tname.setVisible(true);
            Tid.setVisible(true);
            Tuser.setVisible(true);
            Tage.setVisible(true);
            Tphone.setVisible(true);
            Tpas.setVisible(true);

            AHomepage.Refresh_Tourguide = true;
            editANCH.setVisible(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(ParentANCH.getScene().getWindow());
            alert.getDialogPane().setContentText(test);
            alert.getDialogPane().setHeaderText("Error");
            alert.showAndWait();
        }

    }


    @FXML
    void disEditAnch(ActionEvent event) {
        Tour_IDEdit.setVisible(false);
        Tour_PASSEdit.setVisible(false);
        Tour_PHONEEdit.setVisible(false);
        Tour_USEREdit.setVisible(false);
        Tour_AgeEdit.setVisible(false);
        Tname.setVisible(true);
        Tid.setVisible(true);
        Tuser.setVisible(true);
        Tage.setVisible(true);
        Tphone.setVisible(true);
        Tpas.setVisible(true);
        editANCH.setVisible(false);
    }



    @FXML
    void inDeleteAnch(ActionEvent event) {
        //   deleteANCH.setVisible(true);
        Optional<ButtonType> check = Admin.confirmation_alert(Tname.getScene().getWindow(), "Are You Sure", "Delete Account");
        if (check.get() == ButtonType.OK) {
          Admin.DeleteUser(tourGuide);
            AHomepage.Refresh_Tourguide = true;
        }
    }
    @FXML
    void Assign_to_trip(ActionEvent event) throws IOException {
        Optional<ButtonType> check= Admin.confirmation_alert(Tname.getScene().getWindow(),"Are You Sure","Log in");
        if(check.get()==ButtonType.OK)
        {
            TourGuide.selectedTourGuide=tourGuide;
            TourGuide.isTourGuide=true;
            TGHomepageController homepage=new TGHomepageController();
            homepage.thomepage();
            homepage.initialize();
            Tid.getScene().getWindow().hide();
        }
    }


}
