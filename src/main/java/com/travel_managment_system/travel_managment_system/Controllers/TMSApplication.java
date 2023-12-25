package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Files.Files;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class TMSApplication extends Application implements Loadfxml {
    @Override
    public void start(Stage stage) throws IOException {
        lodafxmlfile("screen.fxml");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Files.read();
        launch();
        Files.write();
//
    }
}