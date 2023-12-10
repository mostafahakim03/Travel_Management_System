package com.travel_managment_system.travel_managment_system;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import com.travel_managment_system.travel_managment_system.User.Customer.CarCompany;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class TMSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Trip.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        CarCompany coma=new CarCompany("Elkrsh");
        CAr car1 =new CAr("byd",2011);
        CAr car2 =new CAr("byd",2010);
        CAr car3 =new CAr("byd",2009);
        coma.AddCAr(car1);
        coma.AddCAr(car2);
        coma.AddCAr(car3);

    }


    public static void main(String[] args) {
        launch();
    }
}