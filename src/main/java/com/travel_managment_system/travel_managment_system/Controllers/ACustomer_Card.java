package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;

public class ACustomer_Card implements Loadfxml {

    @FXML
    private Label Age;

    @FXML
    private AnchorPane Available;

    @FXML
    private AnchorPane NOTavailale;

    @FXML
    private Label Name;

    @FXML
    private Pane ParentANCH;

    @FXML
    private Label Pass;

    @FXML
    private TextField Pass_Text;

    @FXML
    private Label Phone;

    @FXML
    private TextField Phone_text;

    @FXML
    private Label Tickets;

    @FXML
    private Label User_Name;

    @FXML
    private TextField User_text;

    @FXML
    private AnchorPane deleteANCH;


    @FXML
    private AnchorPane editANCH;
    private Customer Customer_Card;

    public void Set_data(Customer customer) {
        Customer_Card = customer;
        Name.setText(customer.getName());
        User_Name.setText(customer.getUsername());
        Pass.setText(customer.getPass());
        Phone.setText(customer.getPhone());
        Age.setText(customer.getAge());
        int num_Tickets = 0;
        for (Ticket tickets : customer.tickets) {
            num_Tickets += tickets.numberOfReservedTickets;
        }
        Tickets.setText(String.valueOf(num_Tickets));
        dis_edit();
    }

    public void dis_edit() {
        Phone_text.setVisible(false);
        User_text.setVisible(false);
        Pass_Text.setVisible(false);
        editANCH.setVisible(false);

        Phone.setVisible(true);
        Pass.setVisible(true);
        User_Name.setVisible(true);
    }

    @FXML
    void Edit_Account(ActionEvent event) {
        Phone_text.setVisible(true);
        User_text.setVisible(true);
        Pass_Text.setVisible(true);
        editANCH.setVisible(true);
        Pass_Text.setText(Pass.getText());
        User_text.setText(User_Name.getText());
        Phone_text.setText(Phone.getText());
        Phone.setVisible(false);
        Pass.setVisible(false);
        User_Name.setVisible(false);

    }

    @FXML
    void delete_Account(ActionEvent event) {
        Optional<ButtonType> check = Admin.confirmation_alert(Name.getScene().getWindow(), "Are You Sure", "Delete Account");
        if (check.get() == ButtonType.OK) {
            for (Customer c : Customer.CoustomerAcc) {
                if (User_Name.getText().equals(c.getUsername())) {
                    System.out.println("Yes");
                    Customer.CoustomerAcc.remove(c);
                    break;
                }
            }
            AHomepage.Refresh_Customer = true;
        }
    }

    @FXML
    void disEditAnch(ActionEvent event) {

        dis_edit();
    }

    @FXML
    void saveEditCust(ActionEvent event) {
        Customer customer;
        if (User_text.getText().equals(User_Name.getText()))
            customer = new Customer(Name.getText(), "-1", Pass_Text.getText(), Phone_text.getText(), Age.getText());
        else
            customer = new Customer(Name.getText(), User_text.getText(), Pass_Text.getText(), Phone_text.getText(), Age.getText());

        String check = customer.check_signup();

        if (check.equals("done")) {
            for (Customer c : Customer.CoustomerAcc) {
                if (User_Name.getText().equals(c.getUsername())) {
                    c.setUsername(User_text.getText());
                    c.setPhone(Phone_text.getText());
                    c.setPass(Pass_Text.getText());
                    break;
                }
            }
            AHomepage.Refresh_Customer = true;
            dis_edit();
        } else Admin.Error_Alert(Phone.getScene().getWindow(), check, "Error");
    }

    @FXML
    void Booking(ActionEvent event) throws IOException {
        Optional<ButtonType> check = Admin.confirmation_alert(Phone.getScene().getWindow(), "Are you sure book a ticket?", "Booking");
        if (check.get() == ButtonType.OK) {
            Customer.selectedCustomer = Customer_Card;
            User.isTourGuide = false;
            lodafxmlfile("CHomepage.fxml");
            Phone.getScene().getWindow().hide();
        }

    }

}
