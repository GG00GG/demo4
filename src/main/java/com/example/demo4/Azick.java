package com.example.demo4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Azick {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSumm;

    @FXML
    private TextField chas;

    @FXML
    private TextField stafcka;

    @FXML
    private Text summa;

    @FXML
    void initialize() {
        buttonSumm.setOnAction(event -> {
            double hoursWorked = Double.parseDouble(chas.getText());
            double hourlyRate = Double.parseDouble(stafcka.getText());
            double totalSalary = hoursWorked * hourlyRate;

            summa.setText("Зарплата: руб: " + totalSalary);

        });

    }

}


