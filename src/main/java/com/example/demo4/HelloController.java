package com.example.demo4;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane LognSgnUpButton;

    @FXML
    private Button authSiglnButton;


    @FXML
    private PasswordField password;

    @FXML
    private TextField username;


    @FXML
    void initialize() {

        authSiglnButton.setOnAction(event -> {
            String usernameField = username.getText();
            String passwordField = password.getText();

            if (usernameField.equals("admin") && passwordField.equals("admin")) {
                authSiglnButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("admin.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }if (!usernameField.equals("") && !passwordField.equals("")){
                loginUser(usernameField, passwordField);

            }else {
                System.out.println("Неправильный логин или пароль");

            }

        });
}

    private void loginUser(String loginText, String loginPasswort) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassvord(loginPasswort);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }

        if (counter >= 1) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("user.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
    }
    }