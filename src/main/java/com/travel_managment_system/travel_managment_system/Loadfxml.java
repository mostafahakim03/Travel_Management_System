package com.travel_managment_system.travel_managment_system;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public interface Loadfxml {
    public default void lodafxmlfile(String filename) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(filename));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public default ToolBar Load_navBar(URL resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(resource);
        ToolBar toolBar = fxmlLoader.load();
        NavBar navBar = fxmlLoader.getController();
        navBar.set();
        return toolBar;

    }

}
