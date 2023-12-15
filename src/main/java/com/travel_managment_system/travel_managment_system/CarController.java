package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Itinerary.Itinerary;
import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarController implements Initializable , Loadfxml{
    @FXML
    private ImageView Car1;
    @FXML
    private ImageView Car2;
    @FXML
    private ImageView Car3;
    @FXML
    private AnchorPane CarAnchor;
    @FXML
    private AnchorPane CarAnchor1;
    @FXML
    private Button HomeButton;
    @FXML
    private ChoiceBox<Integer> numOfDays = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> numOfDays1 = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> numOfDays2 =new ChoiceBox<>();
    @FXML
    private Label carModel1;

    @FXML
    private Label carModel2;

    @FXML
    private Label carModel3;

    @FXML
    private Label carName1;

    @FXML
    private Label carName2;

    @FXML
    private Label carName3;
    private CAr car;

    public Integer[] NumOfRentalDays = new Integer[3];
    public void FillArr(){
        for(int i=0;i<3;i++){
            NumOfRentalDays[i]= i+1;
        }
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
            lodafxmlfile("hello-view.fxml");
            CarAnchor.getScene().getWindow().hide();
        }
    }
    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
       lodafxmlfile("CHomepage.fxml");
        CarAnchor.getScene().getWindow().hide();
    }
    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        CarAnchor.getScene().getWindow().hide();

    }
    public void CProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("Cprofile.fxml");
        CarAnchor.getScene().getWindow().hide();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FillArr();
        numOfDays.getItems().addAll(NumOfRentalDays);
        numOfDays1.getItems().addAll(NumOfRentalDays);
        numOfDays2.getItems().addAll(NumOfRentalDays);
        CAr.cars.add(new CAr("BMW M4",2022));
        CAr.cars.add(new CAr("Nissan Qashqai",2020));
        CAr.cars.add(new CAr("Lada",2011));
        String carModelString1=Integer.toString(CAr.cars.get(0).getCarmodel());
        String carModelString2=Integer.toString(CAr.cars.get(1).getCarmodel());
        String carModelString3=Integer.toString(CAr.cars.get(1).getCarmodel());
        carName1.setText(CAr.cars.get(0).getCarname());
        carName2.setText(CAr.cars.get(1).getCarname());
        carName3.setText(CAr.cars.get(2).getCarname());
        carModel1.setText(carModelString1);
        carModel2.setText(carModelString2);
        carModel3.setText(carModelString3);



    }
    public void Next() throws IOException {
        if(Ticket.selectedTicket.packageType=="Platinum") {
            lodafxmlfile("Intinerary.fxml");
        }
        else
        {
            lodafxmlfile("Payment.fxml");
        }
        CarAnchor.getScene().getWindow().hide();

        if(numOfDays.getValue()!= null){
        Ticket.selectedTicket.car.setCarname(carName1.getText());
        Ticket.selectedTicket.car.setCarmodel(Integer.parseInt(carModel1.getText()));
        }
        else if(numOfDays1.getValue()!= null){
            Ticket.selectedTicket.car.setCarname(carName2.getText());
            Ticket.selectedTicket.car.setCarmodel(Integer.parseInt(carModel2.getText()));
        }
        else if(numOfDays2.getValue()!= null){
            Ticket.selectedTicket.car.setCarname(carName3.getText());
            Ticket.selectedTicket.car.setCarmodel(Integer.parseInt(carModel3.getText()));
        }
        System.out.println(Ticket.selectedTicket.car.getCarname()+" "+Ticket.selectedTicket.car.getCarmodel());
        ItineraryController itineraryController = new ItineraryController();
        itineraryController.initialize();
    }
}