package com.example.demo4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AdminController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private PasswordField passvord;

    @FXML
    private Button saveButton;

    @FXML
    void initialize() {

        saveButton.setOnAction(event -> {

            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

//        String firstName = signUpName.getText();
//        String lastName = signUpLastName.getText();
        String userName = login.getText();
        String password = passvord.getText();
//        String lacation = sighUpContry.getText();
//        String gender = "";
//        if (signUpCheckBoxMale.isSelected())
//            gender = "Мурской";
//        else
//            gender = "Женский";

//        User user = new User(firstName, lastName, userName, password, lacation, gender);
        User user = new User(userName, password);

        dbHandler.signUpUser(user);
    }









//    @FXML
//    private TextField newUsernameField;
//
//    @FXML
//    private PasswordField newPasswordField;
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button button;
//
//    @FXML
//    private PasswordField passwordField;
//
//    @FXML
//    private TextField usernameField;
//
//    @FXML
//    void loginButtonClicked(ActionEvent event) {
//
//    }
//    public static void addTimeToAdmin(String time) {
//        // Здесь можно реализовать логику для отправки времени в окно администратора
//        // Например, можно добавить время в список или базу данных
//
//        // Пример: вывод сообщения с полученным временем
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Время пользователя");
//        alert.setHeaderText(null);
//        alert.setContentText("Время пользователя: " + time);
//        alert.showAndWait();
//    }
//
//    @FXML
//    private void addUserButtonClicked() {
//        String newUsername = newUsernameField.getText();
//        String newPassword = newPasswordField.getText();
//
//        // Здесь можно добавить логику для сохранения нового пользователя в базе данных или массиве
//
//        // Пример: добавление пользователя в массив
//        // users.add(new User(newUsername, newPassword));
//
//        // После успешного добавления пользователя, можно вывести сообщение об успешном добавлении
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Успех");
//        alert.setHeaderText(null);
//        alert.setContentText("Пользователь успешно добавлен");
//        alert.showAndWait();
//
//        // Очистка полей после добавления пользователя
//        newUsernameField.clear();
//        newPasswordField.clear();
//    }
}
