package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

public class AHomepage {
    @FXML
    private DatePicker TendDate,TstartDate;

    @FXML
    private TextField TidText,TnameText,TpayText,TpriceText;

    @FXML
    private ComboBox<String> TLocText=new ComboBox<String>(),TtypeText=new ComboBox<String>();
    @FXML
    private AnchorPane ATripAnch,newTripForm,allTrips;


    public static Boolean Refresh=false;

    @FXML
    private VBox TouVbox=new VBox(),TripVbox;
    @FXML
    private Button ATourBTN;
    @FXML
    public AnchorPane TOURPAne=new AnchorPane();
    Boolean TourView= false;
    @FXML
    private Label ErrorAddtrip;

    @FXML
    private ImageView Tripphoto;
    String imageSrc ;



    public void showAhome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void  ShowTours(ActionEvent event) {
        ATripAnch.setVisible(false);
        TouVbox.getChildren().clear();
        TOURPAne.setVisible(true);
        TourView=true;
        try
        {
            for (int j = 0; j < TourGuide.TourguideAcc.size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ATour.fxml"));
                Pane pane = fxmlLoader.load();
                Atourcontrol atourcontrol= fxmlLoader.getController();
                atourcontrol.setdata(TourGuide.TourguideAcc.get(j));
                TouVbox.getChildren().add(pane);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
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
        ATripAnch.setVisible(true);
        allTrips.setVisible(true);
        newTripForm.setVisible(false);
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
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
