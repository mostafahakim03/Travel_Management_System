package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarController implements Initializable, Loadfxml {
    @FXML
    private VBox Car_vbox;
    @FXML
    private HBox Nav_Box;

 @FXML
    private AnchorPane CarAnchor;


    @FXML
    private ProgressBar progressBar3;


    public Integer[] NumOfRentalDays = new Integer[3];

    public void FillArr() {

        for (int i = 0; i < 3; i++) {
            NumOfRentalDays[i] = i + 1;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FillArr();
        try {
            show_cars();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        progressBar3.setStyle("-fx-accent: #FA8B02;");
        try {
            Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void show_cars() throws IOException {
        for (int j=0;j<CAr.cars.size();j++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AcarCard.fxml"));
            AnchorPane pane = fxmlLoader.load();
            AcarCard acarCard = fxmlLoader.getController();
            acarCard.setData(CAr.cars.get(j));
            Car_vbox.getChildren().add(pane);
        }
    }

    public void Next() throws IOException {
        if (Ticket.selectedTicket.packageType == "Platinum") {
            lodafxmlfile("Intinerary.fxml");
            ItineraryController itineraryController = new ItineraryController();
            itineraryController.initialize();
        } else {
            lodafxmlfile("TicketPayment.fxml");
        }
        CarAnchor.getScene().getWindow().hide();
//
//
        System.out.println(Ticket.selectedTicket.car.getCarname() + " " + Ticket.selectedTicket.car.getCarmodel());

    }
}