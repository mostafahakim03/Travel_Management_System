package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Atourcontrol {

    @FXML
    private Label Tage;

    @FXML
    private Label Tid,Tname,Tpas,Tphone,Tuser;


    @FXML
    private AnchorPane deleteANCH,editANCH;
    @FXML
    private Pane ParentANCH;
    @FXML
    private TextField Tour_IDEdit,Tour_USEREdit,Tour_PASSEdit,Tour_PHONEEdit,Tour_NameEdit,Tour_AgeEdit;



    public void setdata(TourGuide tourGuide){
        Tname.setText(tourGuide.getName());
        Tuser.setText(tourGuide.getUsername());
        Tpas.setText(tourGuide.getPass());
        Tphone.setText(tourGuide.getPhone());
        Tage.setText(tourGuide.getAge());
        Tid.setText(tourGuide.getGuideID());
    }

    @FXML
    void editTour(ActionEvent event) {
        Tname.setVisible(false);Tid.setVisible(false);Tuser.setVisible(false);
        Tage.setVisible(false);Tphone.setVisible(false);Tpas.setVisible(false);
        Tour_IDEdit.setVisible(true);Tour_PASSEdit.setVisible(true);Tour_PHONEEdit.setVisible(true);Tour_USEREdit.setVisible(true);Tour_NameEdit.setVisible(true);Tour_AgeEdit.setVisible(true);
        Tour_IDEdit.setText(Tid.getText());Tour_PASSEdit.setText(Tpas.getText());Tour_PHONEEdit.setText(Tphone.getText());Tour_USEREdit.setText(Tuser.getText());Tour_NameEdit.setText(Tname.getText());Tour_AgeEdit.setText(Tage.getText());
        editANCH.setVisible(true);
    }
    @FXML
    void saveEditTour(ActionEvent event) {
        for (TourGuide T :TourGuide.TourguideAcc)
        {
            if(Tid.getText().equals(T.getGuideID())){
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

        Tour_IDEdit.setVisible(false);Tour_PASSEdit.setVisible(false);Tour_PHONEEdit.setVisible(false);Tour_USEREdit.setVisible(false);Tour_NameEdit.setVisible(false);Tour_AgeEdit.setVisible(false);
        Tname.setVisible(true);Tid.setVisible(true);Tuser.setVisible(true);
        Tage.setVisible(true);Tphone.setVisible(true);Tpas.setVisible(true);

        AHomepage.Refresh = true;
        editANCH.setVisible(false);
    }
    @FXML
    void disEditAnch(ActionEvent event) {
        Tour_IDEdit.setVisible(false);
        Tour_PASSEdit.setVisible(false);
        Tour_PHONEEdit.setVisible(false);
        Tour_USEREdit.setVisible(false);
        Tour_NameEdit.setVisible(false);
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
    void ActionOnTour(ActionEvent event) throws IOException {
        TourGuide.DeleteTour(Tid.getText());
        ParentANCH.setVisible(false);

        AHomepage.Refresh = true;
        deleteANCH.setVisible(false);
    }

    @FXML
    void disDeleteAnch(ActionEvent event) {

        deleteANCH.setVisible(false);

    }
    @FXML
    void inDeleteAnch(ActionEvent event) {
        deleteANCH.setVisible(true);
    }





}
