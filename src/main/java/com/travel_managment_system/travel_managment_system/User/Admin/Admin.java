package com.travel_managment_system.travel_managment_system.User.Admin;

import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import com.travel_managment_system.travel_managment_system.User.User;
import javafx.animation.FadeTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Optional;

import static com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide.TourguideAcc;

public class Admin {
    public static ArrayList<String> Locations = new ArrayList<>();
    private static String Username = "admin";
    private static String Password = "1234";
    public static Boolean Refresh_admin = false, Admin_is_Opned = false;


    public static String getUsername() {
        return Username;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setUsername(String username) {
        Username = username;
    }

    public static void setPassword(String password) {
        Password = password;
    }

    public static File cobyFile(File source) throws IOException {
        File dest = new File("src\\main\\resources\\com\\travel_managment_system\\travel_managment_system\\assets" + File.separator + source.getName());
        if (dest.exists()) System.out.println("yes");
        else {
            System.out.println("no");
            Files.copy(source.toPath(), dest.toPath());
        }

        return dest;
    }

    public static void addLocation(String location) {
        if (!(Locations.contains(location))) Locations.add(location);
    }


    public static Optional<ButtonType> confirmation_alert(Window window, String content, String Header) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(window);
        alert.getDialogPane().setContentText(content);
        alert.getDialogPane().setHeaderText(Header);
        return alert.showAndWait();

    }

    public static void Error_Alert(Window window, String content, String Header) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(window);
        alert.getDialogPane().setContentText(content);
        alert.getDialogPane().setHeaderText(Header);
        alert.showAndWait();
    }

    public static String Check_Add_or_edit_tour(TourGuide tourGuide, Boolean add) {
        String test = tourGuide.check_signup(true);
        if (add) {
            if (test.equals("done")) {
                boolean exist = false;
                for (TourGuide T : TourGuide.TourguideAcc) {
                    if (tourGuide.getGuideID().equals(T.getGuideID())) {
                        exist = true;
                        break;
                    }
                }
                if (exist) return "ID is already exist";
                else {
                    try {
                        int id = Integer.parseInt(tourGuide.getGuideID());
                        TourGuide.newidAcc.remove((Integer) id);
                    } catch (NumberFormatException e) {
                        return "Invalid ID";
                    }
                }
            }
        }
        return test;

    }

    public static void add_User(User user) {

        if(user instanceof TourGuide)
        {
            TourguideAcc.add((TourGuide) user);
        }
        else if(user instanceof Customer)Customer.CoustomerAcc.add((Customer) user);
    }
    public static double checkDiscount(int numberofTickets, double tripPrice, String packageType,Customer customer) {
        double overallPrice = numberofTickets * tripPrice;
        if (packageType.equals("Platinum")) {
            overallPrice = overallPrice + (overallPrice * 0.25);
        } else if (packageType.equals("Golden")) {
            overallPrice = overallPrice + (overallPrice * 0.1);
        }

        if (customer.myTrips.size() % 2 == 0 && !customer.myTrips.isEmpty()) {
            System.out.println("Discount applied , whoo hoo!!");
            return overallPrice - (overallPrice * 0.15);
        } else {
            return overallPrice;
        }

    }

    public static void fade(AnchorPane anchorPane) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(anchorPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public static void DeleteUser(User user) {
        if(user instanceof TourGuide) {
            for (int i = 0; i < TourguideAcc.size(); i++) {
                if (TourguideAcc.get(i).getGuideID().equals(((TourGuide) user).getGuideID())) {
                    TourguideAcc.remove(i);
                    break;
                }
            }
        }
        else if(user instanceof Customer) {
            for (Customer c : Customer.CoustomerAcc) {
                if (user.getUsername().equals(c.getUsername())) {
                    Customer.CoustomerAcc.remove(c);
                    break;
                }
            }
        }
    }

}

