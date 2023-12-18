package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
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

public class Cprofile implements Loadfxml {
    @FXML
    private HBox Nav_Box;

    @FXML
    private Label CAge= new Label();

    @FXML
    private Label CName= new Label();

    @FXML
    private Label CPassword= new Label();

    @FXML
    private Label CPhonenumber= new Label();

    @FXML
    private TextField CUserText=new TextField();

    @FXML
    private Label CUsername= new Label();

    @FXML
    private TextField CageText=new TextField();

    @FXML
    private TextField CnameText=new TextField();

    @FXML
    private TextField CpassText=new TextField();

    @FXML
    private TextField CphoneText=new TextField();

    @FXML
    private AnchorPane Cprofile;

    @FXML
    private AnchorPane Clabanchor=new AnchorPane();

    @FXML
    private AnchorPane Clabanchor2=new AnchorPane();

    @FXML
    private Button profileButton;



    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //logging out code
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Cprofile.getScene().getWindow().hide();

        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Cprofile.getScene().getWindow().hide();

    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        profileButton.setDisable(true);
    }
    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
        Cprofile.getScene().getWindow().hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

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

        Customer.selectedCustomer.setName(CnameText.getText());
        Customer.selectedCustomer.setAge(CageText.getText());
        Customer.selectedCustomer.setPass(CpassText.getText());
        Customer.selectedCustomer.setPhone(CphoneText.getText());
        Customer.selectedCustomer.setUsername(CUserText.getText());

        for (Customer customer : Customer.CoustomerAcc) {
            customer.setName(Customer.selectedCustomer.getName());
            customer.setAge(Customer.selectedCustomer.getAge());
            customer.setAge(Customer.selectedCustomer.getAge());
            customer.setPhone(Customer.selectedCustomer.getPhone());
            customer.setUsername(Customer.selectedCustomer.getUsername());
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
