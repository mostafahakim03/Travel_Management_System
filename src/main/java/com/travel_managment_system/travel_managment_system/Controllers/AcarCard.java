package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    private ImageView CarImageView;

    @FXML
    private Label carModel;

    @FXML
    private Label carName;

    @FXML
    private ChoiceBox<Integer> numOfDays;
    CAr cAr;

    public void setData(CAr cAr) throws FileNotFoundException {
        carName.setText(cAr.getCarname());
        carModel.setText(String.valueOf(cAr.getCarmodel()));
        if(Admin.Admin_is_Opned&&!(ACustomer_Card.Booking))next_anch.setVisible(false);
        FileInputStream fileInputStream = new FileInputStream(cAr.getImage());
        Image image = new Image(fileInputStream);
        CarImageView.setImage(image);
        this.cAr=cAr;
    }

    @FXML
    void Next(MouseEvent event) throws IOException {
        if (Ticket.selectedTicket.packageType .equals( "Platinum") ) {
            lodafxmlfile("Intinerary.fxml");
        } else {
            lodafxmlfile("TicketPayment.fxml");
        }
        Ticket.selectedTicket.setCar(cAr);
        carName.getScene().getWindow().hide();
//        System.out.println(Ticket.selectedTicket.car.getCarname() + " " + Ticket.selectedTicket.car.getCarmodel());


    }
}
