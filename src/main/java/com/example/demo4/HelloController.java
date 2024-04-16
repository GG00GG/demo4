package com.example.demo4;

import java.io.IOException;
import java.net.URL;
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

            // Здесь можно добавить логику проверки логина и пароля
            // Например, можно сравнивать введенные данные с данными из базы данных или массива

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
            } if (usernameField.equals("user") && passwordField.equals("user")){
                authSiglnButton.getScene().getWindow().hide();

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
            }else {
                System.out.println("Неправильный логин или пароль");
                // Здесь можно добавить код для вывода сообщения об ошибке пользователю
            }

        });
//
//        loginSignUpButton.setOnAction(event -> {
//            openNewScene("app.fxml");
//        });
//
//    }
//
//    private void loginUser(String loginText, String loginPasswort) {
//        DatabaseHandler dbHandler = new DatabaseHandler();
//        User user = new User();
//        user.setUserName(loginText);
//        user.setPassword(loginPasswort);
//        ResultSet result = dbHandler.getUser(user);
//
//        int counter = 0;
//
//        while (true){
//            try {
//                if (!result.next()) break;
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            counter++;
//        }
//
//        if (counter >= 1) {
//            openNewScene("biblot.fxml");
//        }else {
//            Shake userLoginAnim = new Shake(login_field);
//            Shake userPassAnim = new Shake(password_field);
//            userLoginAnim.playAnim();
//            userPassAnim.playAnim();
//        }
//    }
//    public void openNewScene(String window){
//        loginSignUpButton.getScene().getWindow().hide();
//
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(window));
//
//        try {
//            loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Parent root = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.showAndWait();
//
//    }

}
    }