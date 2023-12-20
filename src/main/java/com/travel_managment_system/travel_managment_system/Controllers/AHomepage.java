package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Itinerary.Activities;
import com.travel_managment_system.travel_managment_system.Itinerary.Itinerary;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.Customer.Hotel;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class AHomepage implements Loadfxml {

    //////////////////////---Dash View----///////////////////////////////////////////////
    @FXML
    private AnchorPane DashAnch, Dashview;
    ////////////////////////////////////////////////

    ///////////// ----- New Id to tour Guides----------////////////

    @FXML
    private ListView<Integer> Guide_ID = new ListView<>();
    @FXML
    private Pane newIDpane;
    @FXML
    private TextField newTourID_Text;
    //////////////////////////////////////////////////////////////////

    //////////////////////// ------ activity ------///////////////////////////
    @FXML
    private VBox ActivitiesBox;
    @FXML
    private AnchorPane ActivetiesView, AddActiveties;
    @FXML
    private Spinner<Integer> SpinnerEndHour, SpinnerStartHour, SpinnerEndMin, SpinnerStartMin;
    @FXML
    private ImageView ActivitieImage;
    @FXML  //-----------------PM or AM///////////////////
    private ComboBox<String> EndTimeCompo, StartTimeCompo, Activities_Location_compo;
    @FXML
    private Label ErrorAddActitie;
////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////------------Hotel---------/////////////////////////////////
    @FXML
    private AnchorPane Hotel_Page, Add_Hotel_Form;
    @FXML
    private ComboBox<String> Add_Hotel_Location;
    @FXML
    private GridPane Hotel_grid = new GridPane();

    @FXML
    private ImageView Add_Hotel_Image;
    @FXML
    private TextField Add_Hotel_Name;


////////////////////////////////////////////////////////////////////////////////////////////

    ///////////--------------Cars-------/////////////////////////////
    @FXML
    private AnchorPane cars_page, Add_New_cars_anch;
    @FXML
    private VBox Carvbox;
    @FXML
    private ImageView Add_new_car_image;
    @FXML
    private TextField Add_car_model, Add_car_name;
    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////---------Trips----------//////////////////////////////////////////////
    @FXML
    private AnchorPane ATrip_page, newTripForm, allTrips;
    @FXML
    private VBox TripVbox;
    @FXML
    private DatePicker TendDate, TstartDate;
    @FXML
    private TextField TidText, TnameText, TpayText, TpriceText;
    @FXML
    private ComboBox<String> Trip_Hotel, TLocText = new ComboBox<String>(), TtypeText = new ComboBox<String>(), add_Transportation;
    @FXML
    private ComboBox<Integer> add_Itinerary;
    @FXML
    private ImageView Tripphoto;
    @FXML
    private Label ErrorAddtrip;

    int itinerary = 3;
    @FXML
    private Button add_ActivtiesToTrip;
    Activities[] activities = new Activities[3];

    ////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////------------Tour Guides---------/////////////////////////////////
    @FXML
    private AnchorPane ATourPage = new AnchorPane(), AddnewTOUR = new AnchorPane(), TOURPAne = new AnchorPane();

    @FXML
    private TextField TaddidText, TaddageText, TaddnameText, TaddpassText, TaddphoneText, TaddUserText;
    public static Boolean Refresh_Tourguide = false;
    @FXML
    private VBox TouVbox = new VBox();
    @FXML
    private Label ErrorAddTour;
/////////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////------------ Customer ---------/////////////////////////////////
    @FXML
    private AnchorPane Customer_View, Add_Customer_Pane, show_Customer_Pane;
    @FXML
    private TextField Customer_AgeText, Customer_NameText, Customer_PassText, Customer_PhoneText, Customer_UserText;
    @FXML
    private Label Error_Add_customer;
    @FXML
    private VBox Customer_Vbox;
    /////////////////////////////////////////////////////////////////////////////////////////////////
    String imageSrc;

    public static Boolean Refresh_Customer = false, Refresh_admin = false;

    ////////// loading
    public void showAhome() throws IOException {
        lodafxmlfile("AHomepage.fxml");
        Refresh_admin = true;

    }


    ////////////Dash view////////////
    @FXML
    void Dashview(ActionEvent event) {
        ATourPage.setVisible(false);
        ATrip_page.setVisible(false);
        DashAnch.setVisible(true);
        Dashview.setVisible(true);
        ActivetiesView.setVisible(false);
        Customer_View.setVisible(false);
        Hotel_Page.setVisible(false);
        cars_page.setVisible(false);
        newIDpane.setVisible(false);
        Admin.fade(DashAnch);
    }


    //////// Activities//////////
    @FXML
    void Show_Activities(ActionEvent event) throws IOException {

        ActivetiesView.setVisible(true);
        AddActiveties.setVisible(false);
        Dashview.setVisible(false);
        ActivitiesBox.getChildren().clear();
        for (int i = 0; i < Activities.activities.size(); i++) {


            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ActivitiesCard.fxml"));
            Pane pane = fxmlLoader.load();
            AActivitiesCard aActivitiesCard = fxmlLoader.getController();
            aActivitiesCard.setData(Activities.activities.get(i));
            ActivitiesBox.getChildren().add(pane);
        }
    }

    @FXML
    void Addactivtie(ActionEvent event) {
        AddActiveties.setVisible(true);
        SpinnerValueFactory<Integer> StartHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12);
        StartHour.setValue(1);
        SpinnerStartHour.setValueFactory(StartHour);
        SpinnerValueFactory<Integer> EndHour = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12);
        EndHour.setValue(6);
        SpinnerEndHour.setValueFactory(EndHour);
        SpinnerValueFactory<Integer> StartMin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
        StartMin.setValue(0);
        SpinnerStartMin.setValueFactory(StartMin);
        SpinnerValueFactory<Integer> EndMin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
        EndMin.setValue(0);
        SpinnerEndMin.setValueFactory(EndMin);
        StartTimeCompo.getItems().add("PM");
        StartTimeCompo.getItems().add("AM");
        StartTimeCompo.setValue("PM");
        EndTimeCompo.getItems().add("PM");
        EndTimeCompo.getItems().add("AM");
        EndTimeCompo.setValue("PM");
        ActivitieImage.setImage(null);
        ErrorAddActitie.setText("");
        imageSrc = "";
        Activities_Location_compo.getItems().clear();
        Activities_Location_compo.setValue(null);
        Activities_Location_compo.getItems().addAll(Admin.Locations);
    }

    @FXML
    void back_add_Activitie(ActionEvent event) {
        AddActiveties.setVisible(false);
    }

    @FXML
    void importActivtieImage(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
     //   fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png"));
        File file = fileChooser.showOpenDialog(TOURPAne.getScene().getWindow());
        if (file != null) {
            file = Admin.cobyFile(file);
            String s = file.toString();
            int index = s.indexOf("src");
            s = s.substring(index);
            FileInputStream imageInput = new FileInputStream(s);
            Image image = new Image(imageInput);
            ActivitieImage.setImage(image);
            imageSrc = s;


        }
    }

    @FXML
    void saveActivtie(ActionEvent event) throws IOException {
        if (imageSrc.equals("")) ErrorAddActitie.setText("Please Import Photo");
        else if (Activities_Location_compo.getValue() == null) ErrorAddActitie.setText("please Input Location");
        else {
            String Start = SpinnerStartHour.getValue() + " : " + SpinnerStartMin.getValue() + "  " + StartTimeCompo.getValue();
            String End = SpinnerEndHour.getValue() + " : " + SpinnerEndMin.getValue() + "  " + EndTimeCompo.getValue();
            Activities activities = new Activities(Activities_Location_compo.getValue(), Start, End, imageSrc, Activities.activities.size() + 1);
            Activities.activities.add(activities);
            if (!(Admin.Locations.contains(activities.getLocation())))
                Admin.Locations.add(activities.getLocation());
            AddActiveties.setVisible(false);
            Show_Activities(event);
        }
    }

    /////// new tour guide ID/////////
    @FXML
    void OpenNewTour_ID(ActionEvent event) {
        Add_to_List_id();
        newIDpane.setVisible(true);
        newTourID_Text.setText("");
        Guide_ID.setStyle("-fx-accent: #fa8b02;");
    }

    @FXML
    void AddnewTourID(ActionEvent event) {
        boolean test = true;
        int id = -1;
        try {
            id = Integer.parseInt(newTourID_Text.getText());

        } catch (NumberFormatException e) {
            test = false;
            Admin.Error_Alert(newTourID_Text.getScene().getWindow(), "Invalid ID", "Error");
        }
        if (test) {
            if (id > 0) {
                for (TourGuide tourGuide : TourGuide.TourguideAcc) {
                    if (newTourID_Text.getText().equals(tourGuide.getGuideID())) {
                        test = false;
                        break;
                    }
                }
                if (test && !(TourGuide.newidAcc.contains(id))) {
                    TourGuide.newidAcc.add(id);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initOwner(newTourID_Text.getScene().getWindow());
                    alert.getDialogPane().setContentText("ID Added Successful");
                    alert.getDialogPane().setHeaderText("Successful");
                    alert.showAndWait();
                    //refresh ID list
                    Add_to_List_id();

                } else {
                    Admin.Error_Alert(newTourID_Text.getScene().getWindow(), "ID is already exist", "Error");
                }
            } else {
                Admin.Error_Alert(newTourID_Text.getScene().getWindow(), "Envaild ID", "Error");
            }
        } else {
            Admin.Error_Alert(newTourID_Text.getScene().getWindow(), "Envaild ID", "Error");
        }


    }

    public void Add_to_List_id() {
        Guide_ID.getItems().clear();
        Guide_ID.getItems().addAll(TourGuide.newidAcc);
    }

    @FXML
    void newIDback(ActionEvent event) {
        newIDpane.setVisible(false);
    }

    /////////// Hotel  //////////////////////
    @FXML
    void Hotel_Page(ActionEvent event) throws IOException {
        show_Hotels();
        Add_Hotel_Form.setVisible(false);
        Hotel_Page.setVisible(true);
        Dashview.setVisible(false);
    }

    public void show_Hotels() throws IOException {

        int col = 0, row = 1;
        for (int i = 0; i < Hotel.Hotels.size(); i++) {


            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AHotel_Card.fxml"));
            Pane pane = fxmlLoader.load();
            AHotel_Card hotelCard = fxmlLoader.getController();
            hotelCard.set_data(Hotel.Hotels.get(i));
            if (col == 3) {
                col = 0;
                row++;
            }
            Hotel_grid.add(pane, col++, row);
            GridPane.setMargin(pane, new Insets(10));
        }
    }

    @FXML
    void Add_Hotel_Form(ActionEvent event) {
        Add_Hotel_Form.setVisible(true);
        Add_Hotel_Image.setImage(null);
        Add_Hotel_Name.setText("");
        imageSrc = "";
        Add_Hotel_Location.getItems().clear();
        Add_Hotel_Location.setValue("");
        Add_Hotel_Location.getItems().addAll(Admin.Locations);
    }


    @FXML
    void Back_Add_Hotel(ActionEvent event) {
        Add_Hotel_Form.setVisible(false);
    }

    @FXML
    void Add_Hotel(ActionEvent event) throws IOException {
        if (Add_Hotel_Name.getText().equals(""))
            Admin.Error_Alert(Add_Hotel_Name.getScene().getWindow(), "Please Add Hotel Name", "Error");
        else if (Add_Hotel_Location.getValue().equals(""))
            Admin.Error_Alert(Add_Hotel_Name.getScene().getWindow(), "Please Add Hotel Location", "Error");
        else if (imageSrc.equals(""))
            Admin.Error_Alert(Add_Hotel_Name.getScene().getWindow(), "Please Add Hotel Image", "Error");
        else {
            Hotel hotel = new Hotel(Add_Hotel_Name.getText(), Add_Hotel_Location.getValue(), imageSrc);
            if (!(Admin.Locations.contains(Add_Hotel_Location.getValue()))) {
                Admin.Locations.add(Add_Hotel_Location.getValue());
            }
            Hotel.Hotels.add(hotel);
            Add_Hotel_Form.setVisible(false);
            show_Hotels();
        }

    }

    @FXML
    void Import_Hotel_Image(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
      //  fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png"));
        File file = fileChooser.showOpenDialog(TOURPAne.getScene().getWindow());
        if (file != null) {
            file = Admin.cobyFile(file);
            String s = file.toString();
            int index = s.indexOf("src");
            s = s.substring(index);
            FileInputStream imageInput = new FileInputStream(s);
            Image image = new Image(imageInput);
            Add_Hotel_Image.setImage(image);
            imageSrc = s;


        }

    }
///////// cars ////////////


    @FXML
    void Cars_page(ActionEvent event) throws IOException {
        cars_page.setVisible(true);
        Dashview.setVisible(false);
        show_cars();
    }

    public void show_cars() throws IOException {
        Carvbox.getChildren().clear();
        for (int j = 0; j < CAr.cars.size(); j++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AcarCard.fxml"));
            Pane pane = fxmlLoader.load();
            AcarCard acarCard = fxmlLoader.getController();
            acarCard.setData(CAr.cars.get(j));
            Carvbox.getChildren().add(pane);

        }
    }

    @FXML
    void show_add_car_form(ActionEvent event) {
        Add_New_cars_anch.setVisible(true);
        Add_car_name.setText("");
        Add_car_model.setText("");
        Add_new_car_image.setImage(null);
        imageSrc = "";
    }

    @FXML
    void Add_car(ActionEvent event) throws IOException {
        if (Add_car_name.getText().equals("")) {
            Admin.Error_Alert(cars_page.getScene().getWindow(), "please Input Car Name ", "Error");
        } else if (Add_car_model.getText().equals("")) {
            Admin.Error_Alert(cars_page.getScene().getWindow(), "please Input Car Model ", "Error");
        } else if (imageSrc.equals("")) {
            Admin.Error_Alert(cars_page.getScene().getWindow(), "please Input Car Image ", "Error");
        } else {
            Add_New_cars_anch.setVisible(false);
            CAr car = new CAr(Add_car_name.getText(), Integer.parseInt(Add_car_model.getText()), imageSrc);
            CAr.cars.add(car);
            show_cars();
        }
    }

    @FXML
    void Back_add_new_car(ActionEvent event) {
        Add_New_cars_anch.setVisible(false);
    }

    @FXML
    void Add_car_photo(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
       // fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png"));
        File file = fileChooser.showOpenDialog(TOURPAne.getScene().getWindow());
        if (file != null) {
            file = Admin.cobyFile(file);
            String s = file.toString();
            int index = s.indexOf("src");
            s = s.substring(index);
            FileInputStream imageInput = new FileInputStream(s);
            Image image = new Image(imageInput);
            Add_new_car_image.setImage(image);
            imageSrc = s;

        }
    }

    ///////////  Trips//////////////
    @FXML
    void initializeTrips(ActionEvent event) {
        TOURPAne.setVisible(false);
        ATourPage.setVisible(false);
        ATrip_page.setVisible(true);
        allTrips.setVisible(true);
        newTripForm.setVisible(false);
        DashAnch.setVisible(false);
        Customer_View.setVisible(false);
        showTrips(event);
        Admin.fade(ATrip_page);
    }

    @FXML
    void showTrips(ActionEvent event) {

        try {
            TripVbox.getChildren().clear();
            for (int j = 0; j < Trip.trips.size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ATripCard.fxml"));
                Pane pane = fxmlLoader.load();
                ATripCard ATripCard = fxmlLoader.getController();
                ATripCard.setData(Trip.trips.get(j));
                TripVbox.getChildren().add(pane);
                FadeTransition fadeTransition = new FadeTransition();
                fadeTransition.setDuration(Duration.seconds(0.5));
                fadeTransition.setNode(pane);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void addTrip(ActionEvent event) {
        initializeAddTrip();
        newTripForm.setVisible(true);
        allTrips.setVisible(false);
    }

    @FXML
    public void initializeAddTrip() {
        Tripphoto.setImage(null);
        TLocText.getItems().clear();
        TLocText.getItems().addAll(Admin.Locations);
        TLocText.setValue("");
        TtypeText.setValue("");
        TtypeText.getItems().clear();
        TtypeText.getItems().addAll("Family", "Couple", "General");
        imageSrc = "";
        TstartDate.setValue(LocalDate.now());
        TendDate.setValue(LocalDate.now());
        TnameText.setText("");
        TidText.setText("");
        TpriceText.setText("");
        TpayText.setText("");
        ErrorAddtrip.setText("");
        add_Transportation.getItems().clear();
        add_Transportation.setValue(null);
        add_Transportation.getItems().addAll("Bus", "Plane");
        add_Itinerary.getItems().clear();
        add_Itinerary.setValue(null);
        itinerary = 3;
        add_Itinerary.setPromptText("Input " + itinerary + " ID`s Activities");
        Trip_Hotel.getItems().clear();
        Trip_Hotel.setValue("");
    }

    @FXML
    void addActivtiesToTrip(ActionEvent event) {

        if (itinerary > 0 && add_Itinerary.getValue() != null) {
            for (Activities activ : Activities.activities) {
                if (add_Itinerary.getValue().equals(activ.getId())) {
                    activities[3 - itinerary] = activ;
                    break;
                }
            }
            itinerary--;
            add_Itinerary.getItems().remove(add_Itinerary.getValue());
            add_Itinerary.setPromptText("Input " + itinerary + " ID`s Activities");
            if (itinerary == 0) add_Itinerary.setVisible(false);
        }


    }

    //// when choose activity
    @FXML
    void showadd_Itinerary(ActionEvent event) {
        add_ActivtiesToTrip.setVisible(true);
    }

    @FXML
    void Location_Trip(ActionEvent event) {
        Trip_Hotel.getItems().clear();
        Trip_Hotel.setValue("");
        for (Hotel hotel : Hotel.Hotels) {
            if (hotel.getHotellocation().equals(TLocText.getValue())) {
                Trip_Hotel.getItems().add(hotel.getHotelName());
            }
        }
        add_Itinerary.setVisible(true);
        itinerary = 3;
        activities = new Activities[3];
        add_Itinerary.getItems().clear();
        add_Itinerary.setValue(null);
        add_Itinerary.setPromptText("Input " + itinerary + " ID`s Activities");
        for (Activities a : Activities.activities) {
            if (a.getLocation().equals(TLocText.getValue())) {
                add_Itinerary.getItems().add(a.getId());
            }
        }
    }

    @FXML
    void backAddTrip(ActionEvent event) {
        initializeTrips(event);
    }


    @FXML
    void saveTrip(ActionEvent event) {
        String check = Check_add_Trip();
        if (check.equals("Done")) {
            initializeTrips(event);
        } else ErrorAddtrip.setText(check);
    }

    public String Check_add_Trip() {
        //check all fields not empty

        if (TnameText.getText().isEmpty() || TpayText.getText().isEmpty() || TpriceText.getText().isEmpty() || TidText.getText().isEmpty() || TtypeText.getValue().isEmpty() || TnameText.getText().isEmpty() || TLocText.getValue().isEmpty()) {
            return "PLease Fill All Fields";
        }
        //check payment
        double pay;
        try {
            pay = Double.parseDouble(TpayText.getText());
        } catch (NumberFormatException e) {
            return "please add Valid payment";
        }
        if (pay < 1) return "please add Valid payment";
        //check ID
        int id;
        try {
            id = Integer.parseInt(TidText.getText());
        } catch (NumberFormatException e) {
            return "Enter a Valid ID";
        }
        boolean validid = true;
        for (int i = 0; i < Trip.trips.size(); i++) {
            if (Trip.trips.get(i).getTrip_id() == id) {
                validid = false;
                break;
            }
        }
        if (!validid) return "ID is already exists... please enter another ID";
        //check price
        double price;
        try {
            price = Double.parseDouble(TpriceText.getText());
        } catch (NumberFormatException e) {
            return "please add Valid Price";
        }
        if (price < 1) return "please add Valid Price";
        //check start & end date
        if (TstartDate.getValue().isBefore(LocalDate.now()) || TstartDate.getValue().isBefore(LocalDate.now()))
            return "Enter A valid date";
        if (TstartDate.getValue().isAfter(TendDate.getValue())) return "Start Date Must be Before or Equal End Date";
        //check image
        if (imageSrc == "") return "Please Import photo";
        if (add_Transportation.getValue() == null) return "Please add Transportation";
        if (itinerary > 0) return "Please Input 3 Activities";
        Trip trip = new Trip(TnameText.getText(), id, TtypeText.getValue(), TstartDate.getValue(), TendDate.getValue(), price, pay, imageSrc, TLocText.getValue(), add_Transportation.getValue());
        Itinerary trip_itinerary = new Itinerary();
        trip_itinerary.setActivities(activities);
        trip.setItinerary(trip_itinerary);
        if (Trip_Hotel.getValue().equals("")) return "please Input Hotel";
        for (Hotel hotel : Hotel.Hotels) {
            if (hotel.getHotelName().equals(Trip_Hotel.getValue())) {
                trip.setHotel(hotel);
                break;
            }
        }
        Trip.trips.add(trip);
        Admin.addLocation(TLocText.getValue());
       for (int i=0;i<3;i++)
       {
           System.out.println( trip.getItinerary().getActivities()[0].getLocation());
           System.out.println( trip.getItinerary().getActivities()[0].getId());
           System.out.println( trip.getItinerary().getActivities()[0].getImg());
       }
        return "Done";

    }

    @FXML
    void import_Trip_Image(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        // fileChooser.setInitialDirectory(new File("C:\\"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png"));
        File file = fileChooser.showOpenDialog(TOURPAne.getScene().getWindow());
        if (file != null) {
            file = Admin.cobyFile(file);
            String s = file.toString();

            int index = s.indexOf("src");
            s = s.substring(index);
            FileInputStream imageInput = new FileInputStream(s);
            Image image = new Image(imageInput);
            Tripphoto.setImage(image);
            imageSrc = s;

        }
    }

//////////////// Tour Guide /////////////////

    @FXML
    void ShowTours(ActionEvent event) {
        Customer_View.setVisible(false);
        ATrip_page.setVisible(false);
        AddnewTOUR.setVisible(false);
        ATourPage.setVisible(true);
        TOURPAne.setVisible(true);
        DashAnch.setVisible(false);
        TouVbox.getChildren().clear();

        try {
            for (int j = 0; j < TourGuide.TourguideAcc.size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ATour.fxml"));
                Pane pane = fxmlLoader.load();
                Atourcontrol atourcontrol = fxmlLoader.getController();
                atourcontrol.setdata(TourGuide.TourguideAcc.get(j));
                TouVbox.getChildren().add(pane);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  Refresh = true;
        Admin.fade(ATourPage);
    }

    @FXML
    void AddNEWTOUR(ActionEvent event) {
        TOURPAne.setVisible(false);
        AddnewTOUR.setVisible(true);
        Initilaize_AddTOUR_Form();
    }

    public void Initilaize_AddTOUR_Form() {
        TaddidText.setText("");
        TaddphoneText.setText("");
        TaddnameText.setText("");
        TaddpassText.setText("");
        TaddUserText.setText("");
        TaddageText.setText("");
        ErrorAddTour.setText("");
    }

    @FXML
    void SaveNewTour(ActionEvent event) {
        TourGuide tourGuide = new TourGuide(TaddnameText.getText(), TaddUserText.getText(), TaddpassText.getText(), TaddphoneText.getText(), TaddageText.getText(), TaddidText.getText());
        String test = Admin.Check_Add_or_edit_tour(tourGuide, true);
        if (test.equals("done")) {

            Admin.add_User(tourGuide);
            ShowTours(event);
            Refresh_Tourguide = true;
        } else {
            ErrorAddTour.setText(test);
        }

    }

    @FXML
    void refresh(MouseEvent event) {
        if (Refresh_Tourguide) {
            ShowTours(new ActionEvent());
            System.out.println("yes");
            Refresh_Tourguide = false;
        }
        if (Refresh_Customer) {
            Show_Customer();
            Refresh_Customer = false;
        }
        if (Refresh_admin) {
            Refresh_admin = false;
        }
    }
////////  Customer  ///////////

    @FXML
    void Customer_View(ActionEvent event) {
        Customer_View.setVisible(true);
        show_Customer_Pane.setVisible(true);
        Add_Customer_Pane.setVisible(false);
        ATourPage.setVisible(false);
        ATrip_page.setVisible(false);
        DashAnch.setVisible(false);
        Show_Customer();
        Admin.fade(Customer_View);
    }

    public void Show_Customer() {

        Customer_Vbox.getChildren().clear();
        try {
            for (int j = 0; j < Customer.CoustomerAcc.size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ACustomer_Card.fxml"));
                Pane pane = fxmlLoader.load();
                ACustomer_Card customerCard = fxmlLoader.getController();
                customerCard.Set_data(Customer.CoustomerAcc.get(j));
                Customer_Vbox.getChildren().add(pane);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void AddNewCust(ActionEvent event) {
        show_Customer_Pane.setVisible(false);
        Add_Customer_Pane.setVisible(true);
////---initilaize Add Customer Form----\\\\\\\\
        Customer_NameText.setText("");
        Customer_AgeText.setText("");
        Customer_PassText.setText("");
        Customer_PhoneText.setText("");
        Customer_UserText.setText("");
        Error_Add_customer.setText("");
    }

    @FXML
    void Save_add_new_Customer(ActionEvent event) {
        Customer customer = new Customer(Customer_NameText.getText(), Customer_UserText.getText(), Customer_PassText.getText(), Customer_PhoneText.getText(), Customer_AgeText.getText());
        String check = customer.check_signup();
        if (check.equals("done")) {
            Customer_View(event);
            Admin.add_User(customer);
            Show_Customer();

        } else Error_Add_customer.setText(check);
    }

    @FXML
    void Back_from_add_customer(ActionEvent event) {
        Customer_View(event);
    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
        Optional<ButtonType> result = Admin.confirmation_alert(newTourID_Text.getScene().getWindow(), "Are you sure ?", "Log out");
        if (result.get() == ButtonType.OK) {
            Admin.Admin_is_Opned = false;
            lodafxmlfile("Uhello-view.fxml");
            newTripForm.getScene().getWindow().hide();
        }
    }

///////////////   Done ///////////////////////////////////////
}
