package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import com.travel_managment_system.travel_managment_system.User.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class usercontroller implements Loadfxml {

    @FXML
    private Label ErrorMessage;
    @FXML
    private Label CErrorMessage;
    @FXML
    private Label errorlog;
    @FXML
    private Button btn1;
    @FXML
    private AnchorPane signup_anch;
    @FXML
    private TextField TUserText;
    @FXML
    private TextField TageText;
    @FXML
    private TextField TidText;
    @FXML
    private TextField TnameText;
    @FXML
    private PasswordField TpassText;
    @FXML
    private TextField TphoneText;
    @FXML
    private TextField CUserText;

    @FXML
    private TextField CageText;

    @FXML
    private TextField CnameText;

    @FXML
    private PasswordField CpassText;

    @FXML
    private TextField CphoneText;

    @FXML
    private AnchorPane Csign=new AnchorPane();
    @FXML
    private TextField LoginUsertext;
    @FXML
    private PasswordField LoginPasstext;
    @FXML
    private RadioButton LoginRadioCustomer;

    @FXML
    private RadioButton LoginRadioTour;


    public void btn() throws IOException {
        lodafxmlfile("login.fxml");
        btn1.getScene().getWindow().hide();


    }

    public void signup_btn() {
        signup_anch.setVisible(true);
    }

    public void sign_tour() throws IOException {
        lodafxmlfile("signup_tour.fxml");
        btn1.getScene().getWindow().hide();



    }

    public void sign_cust() throws IOException {
       lodafxmlfile("signup_cust.fxml");
        btn1.getScene().getWindow().hide();


    }

    public void TsubmitSignup() throws IOException {
        TourGuide.newidAcc.add(100);
        TourGuide.newidAcc.add(101);
        TourGuide.newidAcc.add(102);
        TourGuide tourGuide = new TourGuide(TnameText.getText(), TUserText.getText(), TpassText.getText(), TphoneText.getText(), TageText.getText(), TidText.getText());
        String test = tourGuide.check_signup();
        if (test.equals("done")) {
            TourGuide.TourguideAcc.add(tourGuide);
            TourGuide.selectedTourGuide=tourGuide;
            TourGuide.isTourGuide=true;
            TnameText.getScene().getWindow().hide();
            HomepageController homepage=new HomepageController();
            homepage.thomepage();
            homepage.initialize();




        }
        ErrorMessage.setText(test);
    }



   public void Chomepage() throws IOException {
       lodafxmlfile("CHomepage.fxml");
       Csign.getScene().getWindow().hide();

    }

    public void CsubmitSignup() throws IOException {
        Customer customer = new Customer(CnameText.getText(),CUserText.getText(),CpassText.getText(),CphoneText.getText(),CageText.getText());
        String test = customer.check_signup();
        if (test.equals("done")) {
            Customer.selectedCustomer = customer;
            User.isTourGuide=false;
            Customer.CoustomerAcc.add(customer);
            CnameText.getScene().getWindow().hide();
            Chomepage();
        }
        CErrorMessage.setText(test);
    }
    public void checkLogin() throws IOException {
        if((!LoginRadioCustomer.isSelected())&&(!LoginRadioTour.isSelected())&&LoginPasstext.getText().equals(Admin.getPassword())&&LoginUsertext.getText().equals(Admin.getUsername()))
        {
            AHomepage aHomepage=new AHomepage();
            aHomepage.showAhome();


        } else if (LoginRadioTour.isSelected()) {
            for (TourGuide tourguide : TourGuide.TourguideAcc) {

                if (tourguide.getUsername().equals(LoginUsertext.getText())) {
                      if (tourguide.getPass().equals(LoginPasstext.getText())){
                          HomepageController homepage=new HomepageController();
                          homepage.thomepage();
                          TourGuide.selectedTourGuide=tourguide;
                          User.isTourGuide=true;
                          LoginRadioCustomer.getScene().getWindow().hide();
                          break;
                          
                      }
                      else {
                            errorlog.setText("Wrong Password");
                      }

                }
                else errorlog.setText("Username Not Exist");


            }
        }

        else if (LoginRadioCustomer.isSelected()) {
            for (Customer customer : Customer.CoustomerAcc) {

                if (customer.getUsername().equals(LoginUsertext.getText())) {
                    if (customer.getPass().equals(LoginPasstext.getText())){

                       Chomepage();
                        Customer.selectedCustomer=customer;
                        LoginRadioCustomer.getScene().getWindow().hide();
                        break;

                    }
                    else {
                        errorlog.setText("Wrong Password");
                    }

                }
                else errorlog.setText("Username Not Exist");


            }
        }
        else {
           errorlog.setText("Please Check Tourguide or Customer");
        }
        /////////////////


    }

}
