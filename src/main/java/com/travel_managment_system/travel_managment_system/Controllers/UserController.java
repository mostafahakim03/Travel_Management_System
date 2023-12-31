package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import com.travel_managment_system.travel_managment_system.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserController implements Loadfxml {
    @FXML
    private AnchorPane Login_Page;

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
    private AnchorPane Csign;
    @FXML
    private TextField LoginUsertext;
    @FXML
    private PasswordField LoginPasstext;
    @FXML
    private RadioButton LoginRadioCustomer;

    @FXML
    private RadioButton LoginRadioTour;

    @FXML
    private AnchorPane sign_up;
    @FXML
    private AnchorPane log;
    @FXML
    private AnchorPane Tsign;

    public void btn() throws IOException {
        lodafxmlfile("Ulogin.fxml");
        btn1.getScene().getWindow().hide();


    }

    public void signup_btn() {
        signup_anch.setVisible(true);
    }

    public void sign_tour() throws IOException {
        lodafxmlfile("Usignup_tour.fxml");
        btn1.getScene().getWindow().hide();


    }

    public void sign_cust() throws IOException {
        lodafxmlfile("Usignup_cust.fxml");
        btn1.getScene().getWindow().hide();


    }

    public void TsubmitSignup() throws IOException {
        TourGuide tourGuide = new TourGuide(TnameText.getText(), TUserText.getText(), TpassText.getText(), TphoneText.getText(), TageText.getText(), TidText.getText());
        String test = tourGuide.check_signup();
        if (test.equals("done")) {
            TourGuide.TourguideAcc.add(tourGuide);
            TourGuide.selectedTourGuide = tourGuide;
            TourGuide.isTourGuide = true;
            TnameText.getScene().getWindow().hide();
            TGHomepageController homepage = new TGHomepageController();
            homepage.thomepage();
            homepage.initialize();


        }
        ErrorMessage.setText(test);
    }


    public void Chomepage() throws IOException {
        lodafxmlfile("CHomepage.fxml");


    }

    public void CsubmitSignup() throws IOException {
        Customer customer = new Customer(CnameText.getText(), CUserText.getText(), CpassText.getText(), CphoneText.getText(), CageText.getText());
        String test = customer.check_signup();
        if (test.equals("done")) {
            Customer.selectedCustomer = customer;
            User.isTourGuide = false;
            Customer.CoustomerAcc.add(customer);
            CnameText.getScene().getWindow().hide();
            Chomepage();
        }
        CErrorMessage.setText(test);
    }

    public void checkLogin() throws IOException {
        if ((!LoginRadioCustomer.isSelected()) && (!LoginRadioTour.isSelected()) && LoginPasstext.getText().equals(Admin.getPassword()) && LoginUsertext.getText().equals(Admin.getUsername())) {
            Admin.Admin_is_Opned = true;
            AHomepage aHomepage = new AHomepage();
            aHomepage.showAhome();
            LoginRadioCustomer.getScene().getWindow().hide();

        } else if (LoginRadioTour.isSelected()) {
            for (TourGuide tourguide : TourGuide.TourguideAcc) {

                if (tourguide.getUsername().equals(LoginUsertext.getText())) {
                    if (tourguide.getPass().equals(LoginPasstext.getText())) {
                        TourGuide.selectedTourGuide = tourguide;
                        User.isTourGuide = true;
                        TGHomepageController homepage = new TGHomepageController();
                        homepage.thomepage();
                        homepage.initialize();
                        LoginRadioCustomer.getScene().getWindow().hide();
                        break;

                    } else {
                        errorlog.setText("Wrong Password");
                        sign_up.setVisible(false);
                    }

                } else {
                    errorlog.setText("Username Not Exist");
                    sign_up.setVisible(true);
                }
            }
        } else if (LoginRadioCustomer.isSelected()) {
            for (Customer customer : Customer.CoustomerAcc) {

                if (customer.getUsername().equals(LoginUsertext.getText())) {
                    if (customer.getPass().equals(LoginPasstext.getText())) {
                        User.isTourGuide = false;
                        Customer.selectedCustomer = customer;
                        Chomepage();
                        LoginRadioCustomer.getScene().getWindow().hide();
                        break;

                    } else {
                        errorlog.setText("Wrong Password");
                        sign_up.setVisible(false);
                    }

                } else {
                    errorlog.setText("Username Not Exist");
                    sign_up.setVisible(true);
                }

            }
        } else {
            errorlog.setText("Please Check Tourguide or Customer");
        }
        /////////////////


    }

    @FXML
    public void signup(ActionEvent event) throws IOException {
        if (LoginRadioCustomer.isSelected()) {
            lodafxmlfile("Usignup_cust.fxml");
            log.getScene().getWindow().hide();
        } else {
            lodafxmlfile("Usignup_tour.fxml");
            log.getScene().getWindow().hide();
        }
    }

    @FXML
    public void backlog(ActionEvent event) throws IOException {
        lodafxmlfile("Uhello-view.fxml");
        log.getScene().getWindow().hide();
    }

    @FXML
    public void backcust(ActionEvent event) throws IOException {
        lodafxmlfile("Uhello-view.fxml");
        Csign.getScene().getWindow().hide();
    }

    @FXML
    public void backtour(ActionEvent event) throws IOException {
        lodafxmlfile("Uhello-view.fxml");
        Tsign.getScene().getWindow().hide();
    }
}
