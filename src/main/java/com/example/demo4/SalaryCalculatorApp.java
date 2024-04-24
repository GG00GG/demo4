package com.example.demo4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalaryCalculatorApp extends Application {

    private TextField hoursWorkedField;
    private TextField hourlyRateField;
    private Label totalSalaryLabel;

    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        // Создаем соединение с базой данных
        connectToDatabase();

        // Создаем интерфейс пользователя с помощью SceneBuilder
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label hoursWorkedLabel = new Label("Отработанные часы:");
        gridPane.add(hoursWorkedLabel, 0, 0);

        hoursWorkedField = new TextField();
        gridPane.add(hoursWorkedField, 1, 0);

        Label hourlyRateLabel = new Label("Почасовая ставка:");
        gridPane.add(hourlyRateLabel, 0, 1);

        hourlyRateField = new TextField();
        gridPane.add(hourlyRateField, 1, 1);

        Button calculateButton = new Button("Рассчитать зарплату");
        calculateButton.setOnAction(event -> calculateSalary());
        gridPane.add(calculateButton, 0, 2, 2, 1);

        totalSalaryLabel = new Label();
        gridPane.add(totalSalaryLabel, 0, 3, 2, 1);

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Калькулятор зарплаты");
        primaryStage.show();
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/idatia", "root", "12345");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void calculateSalary() {
        double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
        double hourlyRate = Double.parseDouble(hourlyRateField.getText());
        double totalSalary = hoursWorked * hourlyRate;

        totalSalaryLabel.setText("Зарплата: $" + totalSalary);

        // Сохраняем данные в базе данных
        saveToDatabase(hoursWorked, hourlyRate, totalSalary);
    }

    private void saveToDatabase(double hoursWorked, double hourlyRate, double totalSalary) {
        try {
            String query = "INSERT INTO salary (hours_worked, hourly_rate, total_salary) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, hoursWorked);
            preparedStatement.setDouble(2, hourlyRate);
            preparedStatement.setDouble(3, totalSalary);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
