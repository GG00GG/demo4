package com.example.demo4;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.sql.*;

public class Proba {

    @FXML
    private ListView<String> workListView;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/idatia";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    @FXML
    public void initialize() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "SELECT start_time, end_time, hourly_rate, username FROM work_data";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Timestamp startTime = resultSet.getTimestamp("start_time");
                Timestamp endTime = resultSet.getTimestamp("end_time");
                double hourlyRate = resultSet.getDouble("hourly_rate");
                String username = resultSet.getString("username");

                long durationInMillis = endTime.getTime() - startTime.getTime();
                double hoursWorked = durationInMillis / (1000.0 * 60 * 60);

                double earnedForThisWork = hoursWorked * hourlyRate;

                String entry = "User: " + username + ", Work Time: " + hoursWorked + " hours, Earned: $" + earnedForThisWork;
                workListView.getItems().add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}