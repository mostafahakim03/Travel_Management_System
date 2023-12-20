package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
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
import java.util.Optional;

public class UCProfileController implements Loadfxml {
    @FXML
    private HBox Nav_Box;

    @FXML
    private Label CAge = new Label();

    @FXML
    private Label CName = new Label();

    @FXML
    private Label CPassword = new Label();

    @FXML
    private Label CPhonenumber = new Label();

    @FXML
    private TextField CUserText = new TextField();

    @FXML
    private Label CUsername = new Label();

    @FXML
    private TextField CageText = new TextField();

    @FXML
    private TextField CnameText = new TextField();

    @FXML
    private TextField CpassText = new TextField();

    @FXML
    private TextField CphoneText = new TextField();

    @FXML
    private AnchorPane Clabanchor = new AnchorPane();

    @FXML
    private AnchorPane Clabanchor2 = new AnchorPane();


    public void initialize() throws IOException {
        CName.setText(Customer.selectedCustomer.getName());
        CAge.setText(Customer.selectedCustomer.getAge());
        CPassword.setText(Customer.selectedCustomer.getPass());
        CPhonenumber.setText(Customer.selectedCustomer.getPhone());
        CUsername.setText(Customer.selectedCustomer.getUsername());


        CnameText.setText(Customer.selectedCustomer.getName());
        CageText.setText(Customer.selectedCustomer.getAge());
        CpassText.setText(Customer.selectedCustomer.getPass());
        CphoneText.setText(Customer.selectedCustomer.getPhone());
        CUserText.setText(Customer.selectedCustomer.getUsername());

        Nav_Box.getChildren().clear();
        Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));

    }

    public void Update() {
        Customer customer1;
        if(CUsername.getText().equals(CUserText.getText()))
 customer1=new Customer(CnameText.getText(),"-1",CpassText.getText(),CphoneText.getText(),CageText.getText());
        else  customer1=new Customer(CnameText.getText(),CUserText.getText(),CpassText.getText(),CphoneText.getText(),CageText.getText());

        String check= customer1.check_signup();
        if(check.equals("done")) {
            Customer.selectedCustomer.setName(CnameText.getText());
            Customer.selectedCustomer.setAge(CageText.getText());
            Customer.selectedCustomer.setPass(CpassText.getText());
            Customer.selectedCustomer.setPhone(CphoneText.getText());
            Customer.selectedCustomer.setUsername(CUserText.getText());
            for (Customer customer : Customer.CoustomerAcc) {
                if(customer.getUsername().equals(CUsername.getText())) {
                    customer.setName(Customer.selectedCustomer.getName());
                    customer.setAge(Customer.selectedCustomer.getAge());
                    customer.setAge(Customer.selectedCustomer.getAge());
                    customer.setPhone(Customer.selectedCustomer.getPhone());
                    customer.setUsername(Customer.selectedCustomer.getUsername());
                }
            }
        }
        else {
              Admin.Error_Alert(CAge.getScene().getWindow(),check,"Error");
        }




    }


    @FXML
    void CEdit(ActionEvent event) throws IOException {
        Clabanchor.setVisible(true);
        Clabanchor2.setVisible(false);
        initialize();
    }

    @FXML
    void CSave(ActionEvent event) throws IOException {
        Clabanchor.setVisible(false);
        Clabanchor2.setVisible(true);
        Update();
        initialize();
    }

}
