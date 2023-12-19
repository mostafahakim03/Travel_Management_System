package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AcarCard implements Loadfxml{
    @FXML
    private
    AnchorPane next_anch;

    @FXML
    private ImageView Car1;

    @FXML
    private Label carModel1;

    @FXML
    private Label carName1;

    @FXML
    private ChoiceBox<Integer> numOfDays;
    CAr cAr;

    public void setData(CAr cAr) throws FileNotFoundException {
        carName1.setText(cAr.getCarname());
        carModel1.setText(String.valueOf(cAr.getCarmodel()));
        if(Admin.Admin_is_Opned)next_anch.setVisible(false);
        FileInputStream fileInputStream = new FileInputStream(cAr.getImage());
        Image image = new Image(fileInputStream);
        Car1.setImage(image);
        this.cAr=cAr;
    }

    @FXML
    void Next(MouseEvent event) throws IOException {
        if (Ticket.selectedTicket.packageType == "Platinum") {
            lodafxmlfile("Intinerary.fxml");
        } else {
            lodafxmlfile("TicketPayment.fxml");
        }
        Ticket.selectedTicket.setCar(cAr);
        carName1.getScene().getWindow().hide();
        System.out.println(Ticket.selectedTicket.car.getCarname() + " " + Ticket.selectedTicket.car.getCarmodel());


    }
}
