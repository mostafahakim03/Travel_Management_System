package com.travel_managment_system.travel_managment_system;
import com.travel_managment_system.travel_managment_system.Files.Files;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class TMSApplication extends Application implements Loadfxml {
    @Override
    public void start(Stage stage) throws IOException {
       lodafxmlfile("hello-view.fxml");
        Trip.trips.add(new Trip("Luxor", 1000, "Family", LocalDate.of(2023,12,11), LocalDate.of(2023,12,17),3000, 10000, "src/main/java" +
                "/com/travel_managment_system/travel_managment_system/luxorPhoto.jpg","Luxor","Plane"));
        Trip.trips.add(new Trip("Alexandria", 1001, "Couple", LocalDate.of(2023,12,13), LocalDate.of(2023,12,18), 400, 7000, "src/main" +
                "/java/com/travel_managment_system/travel_managment_system/Alexandria.jpeg","Alexandria", "Bus"));
        Trip.trips.add(new Trip("Hurghada", 1002, "Couple",LocalDate.of(2023,5,15) ,LocalDate.of(2023,5,18), 400, 7000, "src/main/resources/com/travel_managment_system/travel_managment_system/Hurghada.png","Hurghada","Bus"));
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Files.read();
        launch();
   Files.write();

    }
}