package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

public class AHomepage implements Loadfxml {
    @FXML
    private DatePicker TendDate, TstartDate;

    @FXML
    private TextField TidText, TnameText, TpayText, TpriceText;

    @FXML
    private ComboBox<String> TLocText = new ComboBox<String>(), TtypeText = new ComboBox<String>();
    @FXML
    private AnchorPane ATripAnch, newTripForm, allTrips, ATourPage = new AnchorPane(), AddnewTOUR = new AnchorPane();
    @FXML
    private TextField TaadidText;

    @FXML
    private TextField TaddUserText;

    @FXML
    private TextField TaddageText;

    @FXML
    private TextField TaddnameText;

    @FXML
    private TextField TaddpassText;

    @FXML
    private TextField TaddphoneText;

    public static Boolean Refresh = false;

    @FXML
    private VBox TouVbox = new VBox(), TripVbox;
    @FXML
    private Button ATourBTN;
    @FXML
    public AnchorPane TOURPAne = new AnchorPane();
    @FXML
    private AnchorPane AddActiveties;

    @FXML
    private Spinner<Integer> SpinnerEndHour;

    @FXML
    private Spinner<Integer> SpinnerEndMin;

    @FXML
    private Spinner<Integer> SpinnerStartHour;

    @FXML
    private Spinner<Integer> SpinnerStartMin;

    @FXML
    private AnchorPane DashAnch,Dashview,ActivetiesView;
    Boolean TourView = false;
    @FXML
    private Label ErrorAddtrip, ErrorAddTour;

    @FXML
    private ImageView Tripphoto;
    String imageSrc;
    @FXML
    private Pane Admin_Page;
    @FXML
    private ComboBox<String> EndTimeCompo;
    @FXML
    private ComboBox<String> StartTimeCompo;


    public void showAhome() throws IOException {
        lodafxmlfile("AHomepage.fxml");
      TourGuide.newidAcc.add(78);



        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(3));
        fadeTransition.setNode(Admin_Page);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

    }

    @FXML
    void Dashview(ActionEvent event) {
      ATourPage.setVisible(false);
      ATripAnch.setVisible(false);
      DashAnch.setVisible(true);
    }
    @FXML
    void Addactivtie(ActionEvent event) {
        AddActiveties.setVisible(true);
        SpinnerValueFactory<Integer>StartHour=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,12);StartHour.setValue(1);
   SpinnerStartHour.setValueFactory(StartHour);
        SpinnerValueFactory<Integer>EndHour=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,12);EndHour.setValue(6);
        SpinnerEndHour.setValueFactory(EndHour);
        SpinnerValueFactory<Integer>StartMin=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59);StartMin.setValue(0);
        SpinnerStartMin.setValueFactory(StartMin);
        SpinnerValueFactory<Integer>EndMin=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59);EndMin.setValue(0);
        SpinnerEndMin.setValueFactory(EndMin);
        StartTimeCompo.getItems().add("PM");
        StartTimeCompo.getItems().add("AM");
            StartTimeCompo.setValue("PM");
        EndTimeCompo.getItems().add("PM");
        EndTimeCompo.getItems().add("AM");
        EndTimeCompo.setValue("PM");


    }

    @FXML
    void ShowTours(ActionEvent event) {
        ATripAnch.setVisible(false);
        AddnewTOUR.setVisible(false);
        ATourPage.setVisible(true);
        TouVbox.getChildren().clear();
        TOURPAne.setVisible(true);
        DashAnch.setVisible(false);
        TourView = true;
        try {
            for (int j = 0; j < TourGuide.TourguideAcc.size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ATour.fxml"));
                Pane pane = fxmlLoader.load();
                Atourcontrol atourcontrol = fxmlLoader.getController();
                atourcontrol.setdata(TourGuide.TourguideAcc.get(j));
                TouVbox.getChildren().add(pane);
                FadeTransition fadeTransition=new FadeTransition();
                fadeTransition.setDuration(Duration.seconds(0.5));
                fadeTransition.setNode(pane);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Refresh = true;
    }

    @FXML
    void AddNEWTOUR(ActionEvent event) {
        TOURPAne.setVisible(false);
        AddnewTOUR.setVisible(true);
  }

    @FXML
    void SaveNewTour(ActionEvent event) {
        System.out.println(TaddageText.getText());
        TourGuide tourGuide = new TourGuide(TaddnameText.getText(), TaddUserText.getText(), TaddpassText.getText(), TaddphoneText.getText(), TaddageText.getText(), TaadidText.getText());
        String check = tourGuide.check_signup();
        if (check.equals("done")) {

            TourGuide.TourguideAcc.add(tourGuide);
            ShowTours(event);
            Refresh = true;
        } else {
            ErrorAddTour.setText(check);
        }

    }
    @FXML
    void refresh(MouseEvent event) {
        if(Refresh) {
            ShowTours(new ActionEvent());
            System.out.println("yes");
            Refresh = false;
        }
    }
    @FXML
    void showTrips(ActionEvent event) {

        try
        {
            TripVbox.getChildren().clear();
            for (int j = 0; j < Trip.trips.size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("TripCard.fxml"));
                Pane pane = fxmlLoader.load();
                TripCard tripCard= fxmlLoader.getController();
                tripCard.setData(Trip.trips.get(j));
                TripVbox.getChildren().add(pane);
                FadeTransition fadeTransition=new FadeTransition();
                fadeTransition.setDuration(Duration.seconds(0.5));
                fadeTransition.setNode(pane);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    void initializeTrips(ActionEvent event) {
        TOURPAne.setVisible(false);
        ATourPage.setVisible(false);
        ATripAnch.setVisible(true);
        allTrips.setVisible(true);
        newTripForm.setVisible(false);
        DashAnch.setVisible(false);
        showTrips(event);
    }

    @FXML
    void addTrip(ActionEvent event) {
        initializeAddTrip();
        newTripForm.setVisible(true);
        allTrips.setVisible(false);
    }
    @FXML
    public void initializeAddTrip()
    {
        Tripphoto.setImage(null);
        TLocText.getItems().clear();
        TLocText.getItems().addAll(Admin.Locations);
        TLocText.setValue("");
        TtypeText.setValue("");
        TtypeText.getItems().clear();
        TtypeText.getItems().addAll("Family","Couble","General");
        imageSrc ="";
        TstartDate.setValue(LocalDate.now());
        TendDate.setValue(LocalDate.now());
        TnameText.setText("");
        TidText.setText("");
        TpriceText.setText("");
        TpayText.setText("");
        ErrorAddtrip.setText("");

    }
    @FXML
    void backAddTrip(ActionEvent event) {
        initializeTrips(event);
    }


    @FXML
    void saveTrip(ActionEvent event) {
        String check= Check_add_Trip();
        if(check=="Done"){ initializeTrips(event);}
        else ErrorAddtrip.setText(check);
    }

    public String Check_add_Trip(){
        //check all fields not empty

        if(TnameText.getText().isEmpty()||TpayText.getText().isEmpty()||TpriceText.getText().isEmpty()||TidText.getText().isEmpty()||TtypeText.getValue().isEmpty()||TnameText.getText().isEmpty()||TLocText.getValue().isEmpty())
        {
            return "PLease Fill All Fields";
        }
        //check payment
        double pay;
        try {
            pay = Double.parseDouble(TpayText.getText());
        } catch (NumberFormatException e) {
            return "please add Valid payment";
        }
        if(pay<1)  return "please add Valid payment";
        //check ID
        int id;
        try {
            id= Integer.parseInt(TidText.getText());
        }
        catch (NumberFormatException e)
        {
            return "Enter a Valid ID";
        }
        boolean validid=true;
        for (int i=0;i<Trip.trips.size();i++)
        {
            if(Trip.trips.get(i).getTrip_id()==id){validid=false;break;}
        }
        if(!validid)return "ID is already exists... please enter another ID";
        //check price
        double price;
        try {
            price = Double.parseDouble(TpayText.getText());
        } catch (NumberFormatException e) {
            return "please add Valid Price";
        }
        if(price<1)  return "please add Valid Price";
        //check start & end date
        if(TstartDate.getValue().isBefore(LocalDate.now())||TstartDate.getValue().isBefore(LocalDate.now()))return "Enter A valid date";
        if(TstartDate.getValue().isAfter(TendDate.getValue()))return "Start Date Must be Before or Equal End Date";
        //check image
        if(imageSrc=="")return "Please Import photo";
        Trip trip=new Trip(TnameText.getText(),id,TtypeText.getValue(),TstartDate.getValue(),TendDate.getValue(),price,pay,imageSrc,TLocText.getValue(),"Bus_test");
        Trip.trips.add(trip);
        Admin.addLocation(TLocText.getValue());
        return "Done";

    }
    @FXML
    void importImage(ActionEvent event) throws IOException {
        FileChooser fileChooser=new FileChooser();
        fileChooser.setInitialDirectory(new File("C:\\"));
        File file= fileChooser.showOpenDialog(TOURPAne.getScene().getWindow());
        if(file!=null) {
            file = Admin.cobyFile(file);
            String s = file.toString();

            int index = s.indexOf("src");
            s = s.substring(index);
            FileInputStream imageInput = new FileInputStream(s);
            Image image = new Image(imageInput);
            Tripphoto.setImage(image);
            imageSrc=s;

        }
    }
    @FXML
    void Logout(ActionEvent event) throws IOException {
        lodafxmlfile("hello-view.fxml");
    }
}
