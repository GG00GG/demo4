package com.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.*;

public class Prog {
    @FXML
    private TextField hoursField;
    @FXML
    private TextField rateField;
    @FXML
    private TextField totalField;

    private static final String DB_URL = "jdbc:sqlite:workhours.db";

    @FXML
    private void calculateSalary() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            int hours = Integer.parseInt(hoursField.getText());
            double rate = Double.parseDouble(rateField.getText());

            double total = hours * rate;
            totalField.setText(String.valueOf(total));

            String sql = "INSERT INTO WorkHours (hours, hourlyRate) VALUES (" + hours + ", " + rate + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}