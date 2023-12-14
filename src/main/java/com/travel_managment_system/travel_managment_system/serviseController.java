package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class serviseController implements Initializable ,Loadfxml {
    @FXML
    private Label Alertmsg;

    @FXML
    private Label Alertmsg1;

    @FXML
    private Label Alertmsg2;

    @FXML
    private Button HomeButton;

    @FXML
    private AnchorPane HotelAnchor;

    @FXML
    private ImageView LuxorHotel;

    @FXML
    private ImageView LuxorHotel1;

    @FXML
    private ImageView LuxorHotel11;

    @FXML
    private ChoiceBox<String> roomtype;

    @FXML
    private ChoiceBox<String> roomtype2;

    @FXML
    private ChoiceBox<String> roomtype3;
    private String []roomtypes={"Single","Couple","Triple"};

//private ImageView myimage;
//private Image mimage = new Image(getClass().getResourceAsStream("img.png"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomtype.getItems().addAll(roomtypes);
        roomtype2.getItems().addAll(roomtypes);
        roomtype3.getItems().addAll(roomtypes);

    }


//    public void displayimage(){
//        myimage.setImage(mimage);
//    }

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
           lodafxmlfile("hello-view.fxml");
            HotelAnchor.getScene().getWindow().hide();
        }


    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
       lodafxmlfile("CHomepage.fxml");
        HotelAnchor.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("Cprofile.fxml");
        HotelAnchor.getScene().getWindow().hide();
        //profile.initialize();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        HotelAnchor.getScene().getWindow().hide();

    }
    public void Next1() throws IOException {
        if(roomtype.getValue()==null){
            Alertmsg.setVisible(true);
        } else {
            Ticket.selectedTicket.roomType=roomtype.getValue();
            System.out.println(roomtype.getValue());
            lodafxmlfile("Car.fxml");
            HotelAnchor.getScene().getWindow().hide();
        }

    }
    public void Next2() throws IOException {
        if(roomtype2.getValue()==null){
            Alertmsg1.setVisible(true);
        } else {
            Ticket.selectedTicket.roomType=roomtype2.getValue();
           lodafxmlfile("Car.fxml");
            HotelAnchor.getScene().getWindow().hide();
        }

    }
    public void Next3() throws IOException {
        if(roomtype3.getValue()==null){
            Alertmsg2.setVisible(true);
        } else {
            Ticket.selectedTicket.roomType=roomtype3.getValue();
            lodafxmlfile("Car.fxml");
            HotelAnchor.getScene().getWindow().hide();
        }

    }
}

