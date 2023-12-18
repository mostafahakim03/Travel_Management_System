module com.travel_managment_system.travel_managment_system {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.travel_managment_system.travel_managment_system to javafx.fxml;
    exports com.travel_managment_system.travel_managment_system.Itinerary;
    opens com.travel_managment_system.travel_managment_system.Itinerary to javafx.fxml;
    exports com.travel_managment_system.travel_managment_system.Controllers;
    opens com.travel_managment_system.travel_managment_system.Controllers to javafx.fxml;
}