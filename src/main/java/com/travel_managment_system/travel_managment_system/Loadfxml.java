package com.travel_managment_system.travel_managment_system;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public interface Loadfxml {
    public default void lodafxmlfile(String filename) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(filename));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
