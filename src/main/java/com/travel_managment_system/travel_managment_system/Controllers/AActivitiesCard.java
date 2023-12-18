package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.Itinerary.Activities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AActivitiesCard {

    @FXML
    private Label EndTime;

    @FXML
    private Label ID;

    @FXML
    private Label Location;

    @FXML
    private Label StartTime;
    @FXML
    private ImageView Image_;


    public void setData(Activities activities) throws FileNotFoundException {

        StartTime.setText(activities.getStartTime());
        EndTime.setText(activities.getEndTime());
        Location.setText(activities.getLocation());
        ID.setText(String.valueOf(activities.getId()));
        FileInputStream fileInputStream = new FileInputStream(activities.getImg());
        Image image = new Image(fileInputStream);
        Image_.setImage(image);
    }

}
