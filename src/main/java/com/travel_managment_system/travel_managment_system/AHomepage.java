package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Itinerary.Activities;
import com.travel_managment_system.travel_managment_system.Itinerary.Itinerary;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Admin.Admin;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.Customer.Hotel;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class AHomepage implements Loadfxml{
    @FXML
    private ListView<Integer> Guide_ID=new ListView<>();
    @FXML
    private ComboBox<String> Trip_Hotel;
    @FXML
    private GridPane Hotel_grid=new GridPane();

    @FXML
    private AnchorPane Hotel_Page;

    @FXML
    private AnchorPane Hotel_Form;
    @FXML
    private ImageView Add_Hotel_Image;

    @FXML
    private ComboBox<String> Add_Hotel_Location;

    @FXML
    private TextField Add_Hotel_Name;

    @FXML
    private AnchorPane Customer_View;
    @FXML
    private TextField Customer_AgeText;

    @FXML
    private TextField Customer_NameText;

    @FXML
    private TextField Customer_PassText;

    @FXML
    private TextField Customer_PhoneText;

    @FXML
    private TextField Customer_UserText;
    @FXML
    private Label Error_Add_customer;
    @FXML
    private AnchorPane Add_Customer_Pane;
    @FXML
    private AnchorPane show_Customer_Pane;

    @FXML
    private DatePicker TendDate, TstartDate;

    @FXML
    private TextField TidText, TnameText, TpayText, TpriceText;

    @FXML
    private ComboBox<String> TLocText = new ComboBox<String>(), TtypeText = new ComboBox<String>();
    @FXML
    private ComboBox<String> add_Transportation;
    @FXML
    private ComboBox<Integer> add_Itinerary;
    @FXML
    private AnchorPane ATripAnch, newTripForm, allTrips, ATourPage = new AnchorPane(), AddnewTOUR = new AnchorPane();
    @FXML
    private TextField TaadidText;

    @FXML
    private TextField TaddUserText;

    @FXML
    private Pane newIDpane;
    @FXML
    private VBox Customer_Vbox;



    @FXML
    private TextField TaddageText;

    @FXML
    private TextField TaddnameText;
    @FXML
    private TextField newTourID_Text;


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
    private VBox ActivitiesBox;


    @FXML
    private AnchorPane DashAnch,Dashview,ActivetiesView;
    Boolean TourView = false;
    @FXML
    private Label ErrorAddtrip, ErrorAddTour,ErrorAddActitie;


    @FXML
    private ImageView Tripphoto;
    String imageSrc;
    @FXML
    private Pane Admin_Page;
    @FXML
    private ComboBox<String> EndTimeCompo;
    @FXML
    private ComboBox<String> StartTimeCompo;
    @FXML
    private ImageView ActivitieImage;
    @FXML
    private ComboBox<String> Activities_Location_compo;
    int itinerary =3;
    @FXML
    private Button add_ActivtiesToTrip;
    Activities [] activities =new Activities[3];
    public static Boolean Refresh_Customer=false;



    public void showAhome() throws IOException {
      lodafxmlfile("AHomepage.fxml");
    }

    @FXML
    void Dashview(ActionEvent event) {
      ATourPage.setVisible(false);
      ATripAnch.setVisible(false);
      DashAnch.setVisible(true);
      Dashview.setVisible(true);
      AddActiveties.setVisible(false);
      ActivetiesView.setVisible(false);
        Customer_View.setVisible(false);
        Hotel_Page.setVisible(false);
    }
    @FXML
    void Show_Activities(ActionEvent event) throws IOException {

        ActivetiesView.setVisible(true);
        AddActiveties.setVisible(false);
        Dashview.setVisible(false);
ActivitiesBox.getChildren().clear();
        for (int i=0;i<Activities.Activitties.size();i++) {


            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ActivitieCard.fxml"));
            Pane pane = fxmlLoader.load();
           AActivitieCard aActivitieCard = fxmlLoader.getController();
            aActivitieCard.setData(Activities.Activitties.get(i));
            ActivitiesBox.getChildren().add(pane);
        }
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
        ActivitieImage.setImage(null);
ErrorAddActitie.setText("");
imageSrc="";
Activities_Location_compo.getItems().clear();
Activities_Location_compo.setValue(null);
Activities_Location_compo.getItems().addAll(Admin.Locations);
    }
    @FXML
    void backAddActivties(ActionEvent event) {
        AddActiveties.setVisible(false);
    }

    @FXML
    void importActivtieImage(ActionEvent event) throws IOException {
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
          ActivitieImage.setImage(image);
            imageSrc=s;


        }
    }
    @FXML
    void back_add_Activitie(ActionEvent event) {
AddActiveties.setVisible(false);
    }
    @FXML
    void saveActivtie(ActionEvent event) throws IOException {
if(imageSrc.equals(""))ErrorAddActitie.setText("Please Import Photo");
else if(Activities_Location_compo.getValue()==null)ErrorAddActitie.setText("please Input Location");
else {
    String Start=String.valueOf(SpinnerStartHour.getValue())+" : "+String.valueOf(SpinnerStartMin.getValue())+"  "+StartTimeCompo.getValue();
    String End=String.valueOf(SpinnerEndHour.getValue())+" : "+String.valueOf(SpinnerEndMin.getValue())+"  "+EndTimeCompo.getValue();
    Activities activities=new Activities(Activities_Location_compo.getValue(),Start,End,imageSrc,Activities.Activitties.size()+1);
    Activities.Activitties.add(activities);
    if(!(Admin.Locations.contains(activities.getLocation())))
    Admin.Locations.add(activities.getLocation());
    AddActiveties.setVisible(false);
Show_Activities(event);
}
    }



    @FXML
    void ShowTours(ActionEvent event) {
        Customer_View.setVisible(false);
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
        Initilaize_AddTOUR_Form();
  }
  public void Initilaize_AddTOUR_Form()
  {
TaadidText.setText("");
TaddphoneText.setText("");
TaddnameText.setText("");
TaddpassText.setText("");
TaddUserText.setText("");
TaddageText.setText("");
ErrorAddTour.setText("");
  }

    @FXML
    void SaveNewTour(ActionEvent event) {
        System.out.println(TaddageText.getText());
        TourGuide tourGuide = new TourGuide(TaddnameText.getText(), TaddUserText.getText(), TaddpassText.getText(), TaddphoneText.getText(), TaddageText.getText(), TaadidText.getText());
        String test=Admin.Check_Add_or_edit_tour(tourGuide,true);
        if (test.equals("done")) {

           Admin.add_Tour(tourGuide);
            ShowTours(event);
            Refresh = true;
        } else {
            ErrorAddTour.setText(test);
        }

    }
    @FXML
    void refresh(MouseEvent event) {
        if(Refresh) {
            ShowTours(new ActionEvent());
            System.out.println("yes");
            Refresh = false;
        }
        if(Refresh_Customer)
        {
            Show_Customer();
            Refresh_Customer=false;
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
            Customer_View.setVisible(false);
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
        TtypeText.getItems().addAll("Family","Couple","General");
        imageSrc ="";
        TstartDate.setValue(LocalDate.now());
        TendDate.setValue(LocalDate.now());
        TnameText.setText("");
        TidText.setText("");
        TpriceText.setText("");
        TpayText.setText("");
        ErrorAddtrip.setText("");
        add_Transportation.getItems().clear();
        add_Transportation.setValue(null);add_Transportation.getItems().addAll("Bus","Plane");
add_Itinerary.getItems().clear();
add_Itinerary.setValue(null);
itinerary=3;
add_Itinerary.setPromptText("Input "+String.valueOf(itinerary)+" ID`s Activities");
Trip_Hotel.getItems().clear();
Trip_Hotel.setValue("");
    }
    @FXML
    void showadd_Itinerary(ActionEvent event) {
        add_ActivtiesToTrip.setVisible(true);
    }
    @FXML
    void addActivtiesToTrip(ActionEvent event) {

            if (itinerary > 0&&add_Itinerary.getValue()!=null) {
                for (Activities activ : Activities.Activitties) {
                    if (add_Itinerary.getValue().equals(activ.getId())) {
                        activities[3 - itinerary] = activ;
                        break;
                    }
                }
                itinerary--;
                add_Itinerary.getItems().remove(add_Itinerary.getValue());
                add_Itinerary.setPromptText("Input " + String.valueOf(itinerary) + " ID`s Activities");
                if (itinerary == 0) add_Itinerary.setVisible(false);
            }



    }
    @FXML
    void Activties_Location(ActionEvent event) {
        Trip_Hotel.getItems().clear();
        Trip_Hotel.setValue("");
      for (Hotel hotel:Hotel.Hotels)
      {
          if(hotel.getHotellocation().equals(TLocText.getValue())) {
              Trip_Hotel.getItems().add(hotel.getHotelName());
          }
      }
        add_Itinerary.setVisible(true);
        itinerary=3;
        activities=new Activities[3];
        add_Itinerary.getItems().clear();
        add_Itinerary.setValue(null);
        add_Itinerary.setPromptText("Input "+String.valueOf(itinerary)+" ID`s Activities");
        for (Activities a:Activities.Activitties){
            if(a.getLocation().equals(TLocText.getValue())) {
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
            price = Double.parseDouble(TpriceText.getText());
        } catch (NumberFormatException e) {
            return "please add Valid Price";
        }
        if(price<1)  return "please add Valid Price";
        //check start & end date
        if(TstartDate.getValue().isBefore(LocalDate.now())||TstartDate.getValue().isBefore(LocalDate.now()))return "Enter A valid date";
        if(TstartDate.getValue().isAfter(TendDate.getValue()))return "Start Date Must be Before or Equal End Date";
        //check image
        if(imageSrc=="")return "Please Import photo";
        if(add_Transportation.getValue()==null)return "Please add Transportation";
        if(itinerary>0)return "Please Input 3 Activities";
        Trip trip=new Trip(TnameText.getText(),id,TtypeText.getValue(),TstartDate.getValue(),TendDate.getValue(),price,pay,imageSrc,TLocText.getValue(),add_Transportation.getValue());
        Itinerary trip_itinerary=new Itinerary();
        trip_itinerary.setActivities(activities);
        trip.setItinerary(trip_itinerary);
        if(Trip_Hotel.getValue().equals(""))return "please Input Hotel";
     for (Hotel hotel:Hotel.Hotels)
     {
         if(hotel.getHotelName().equals(Trip_Hotel.getValue()))
         {
             trip.setHotel(hotel);
             break;
         }
     }
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
    void AddnewTourID(ActionEvent event) {
        boolean test=true;
        int  id = -1;
        try {
       id  = Integer.parseInt(newTourID_Text.getText());

        }
        catch (NumberFormatException e)
        {
       test=false;
            Admin.Error_Alert(newTourID_Text.getScene().getWindow(),"Invalid ID","Error");
        }
        if(test) {
            if (id > 0) {
                for (TourGuide tourGuide : TourGuide.TourguideAcc) {
                    if (newTourID_Text.getText().equals(tourGuide.getGuideID())) {
                        test = false;
                        break;
                    }
                }
                if (test && !(TourGuide.newidAcc.contains(id)))
                {
                    TourGuide.newidAcc.add(id);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initOwner(newTourID_Text.getScene().getWindow());
                    alert.getDialogPane().setContentText("ID Added Successful");
                    alert.getDialogPane().setHeaderText("Successful");
                    alert.showAndWait();
                    Add_to_List_id();

                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(newTourID_Text.getScene().getWindow());
                    alert.getDialogPane().setContentText("ID is already exist");
                    alert.getDialogPane().setHeaderText("Error");
                    alert.showAndWait();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(newTourID_Text.getScene().getWindow());
                alert.getDialogPane().setContentText("Envaild ID");
                alert.getDialogPane().setHeaderText("Error");
                alert.showAndWait();
            }
        }



    }
    @FXML
    void newIDback(ActionEvent event) {
newIDpane.setVisible(false);
    }

    @FXML
    void OpenNewTour_ID(ActionEvent event) {
        Add_to_List_id();
newIDpane.setVisible(true);
newTourID_Text.setText("");
    }

    @FXML
    void Customer_View(ActionEvent event) {
        Customer_View.setVisible(true);
        show_Customer_Pane.setVisible(true);
        Add_Customer_Pane.setVisible(false);
        ATourPage.setVisible(false);
        ATripAnch.setVisible(false);
        DashAnch.setVisible(false);
        Show_Customer();
    }
    public void Show_Customer() {

        Customer_Vbox.getChildren().clear();
        try {
            for (int j = 0; j < Customer.CoustomerAcc.size(); j++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Customer_Card.fxml"));
                Pane pane = fxmlLoader.load();
                Customer_Card customerCard = fxmlLoader.getController();
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
        Customer customer=new Customer(Customer_NameText.getText(),Customer_UserText.getText(),Customer_PassText.getText(),Customer_PhoneText.getText(),Customer_AgeText.getText());
     String check=customer.check_signup();
     if(check.equals("done"))
     {
         Customer_View(event);
         Customer.CoustomerAcc.add(customer);
         Show_Customer();

     }
     else Error_Add_customer.setText(check);
    }
    @FXML
    void Back_from_add_customer(ActionEvent event) {
     Customer_View(event);
    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
      Optional<ButtonType> result= Admin.confirmation_alert(newTourID_Text.getScene().getWindow(),"Are you sure ?","Log out");
    if(result.get()==ButtonType.OK) {
        lodafxmlfile("hello-view.fxml");
        newTripForm.getScene().getWindow().hide();
    }
  }

    @FXML
    void Add_Hotel(ActionEvent event) throws IOException {
         if(Add_Hotel_Name.getText().equals(""))
             Admin.Error_Alert(Add_Hotel_Name.getScene().getWindow(),"Please Add Hotel Name","Error");
       else  if(Add_Hotel_Location.getValue().equals(""))
             Admin.Error_Alert(Add_Hotel_Name.getScene().getWindow(),"Please Add Hotel Location","Error");
        else if(imageSrc.equals(""))
             Admin.Error_Alert(Add_Hotel_Name.getScene().getWindow(),"Please Add Hotel Image","Error");
        else {
             Hotel hotel=new Hotel(Add_Hotel_Name.getText(),Add_Hotel_Location.getValue(),imageSrc);
            if(!(Admin.Locations.contains(Add_Hotel_Location.getValue())))
            { Admin.Locations.add(Add_Hotel_Location.getValue());}
             Hotel.Hotels.add(hotel);
             Hotel_Form.setVisible(false);
             show_Hotels();
         }

    }
    @FXML
    void Import_Hotel_Image(ActionEvent event) throws IOException {
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
           Add_Hotel_Image.setImage(image);
            imageSrc=s;


        }

    }
    @FXML
    void Add_Hotel_Form(ActionEvent event) {
       Hotel_Form.setVisible(true);
       Add_Hotel_Image.setImage(null);
       Add_Hotel_Name.setText("");
       imageSrc="";
       Add_Hotel_Location.getItems().clear();
       Add_Hotel_Location.setValue("");
       Add_Hotel_Location.getItems().addAll(Admin.Locations);
    }
    @FXML
    void Hotel_Page(ActionEvent event) throws IOException {
        show_Hotels();
     Hotel_Form.setVisible(false);
     Hotel_Page.setVisible(true);
     Dashview.setVisible(false);
    }
    public void show_Hotels() throws IOException {

        int col=0,row=1;
        for (int i=0;i<Hotel.Hotels.size();i++) {


            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Hotel_Card.fxml"));
            Pane pane = fxmlLoader.load();
            Hotel_Card hotelCard = fxmlLoader.getController();
            hotelCard.set_data(Hotel.Hotels.get(i));
            if(col==4)
            {
                col=0;
                row++;
            }
            Hotel_grid.add(pane,col++,row);
            GridPane.setMargin(pane,new Insets(10));
        }
    }
    @FXML
    void Back_Add_Hotel(ActionEvent event) {
Hotel_Form.setVisible(false);
    }
    public void Add_to_List_id(){
        Guide_ID.getItems().clear();
        Guide_ID.getItems().addAll(TourGuide.newidAcc);
    }

}
