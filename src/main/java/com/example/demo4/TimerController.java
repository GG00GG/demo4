package com.example.demo4;
import javafx.animation.Animation;import javafx.animation.KeyFrame;
import javafx.animation.Timeline;import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;import javafx.scene.Parent;
import javafx.scene.Scene;import javafx.scene.control.Label;
import javafx.stage.Stage;import javafx.util.Duration;
import java.io.IOException;
public class TimerController {
    @FXML
    private Label timerLabel;
    private Timeline timeline;
    private Duration timeElapsed = Duration.ZERO;
    private boolean running = false;

    @FXML    private void initialize() {

    timerLabel.setText(formatTime(timeElapsed));
    }
    @FXML
    private void startTimer() {
        if (!running) {
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
        timeElapsed = timeElapsed.add(Duration.millis(100));
        timerLabel.setText(formatTime(timeElapsed));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        running = true;
    }
    }
    @FXML    private void stopTimer() {
        if (running) {            timeline.stop();
            running = false;
        }    }
    @FXML
    private void saveAndGetFinalTime() {
        saveTime();
        int finalTimeInMillis = getFinalTimeInMillis();
        System.out.println("Final Time in Milliseconds: " + finalTimeInMillis);
        if (finalTimeInMillis>0){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(""));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }    }
    @FXML
    private void subtractTime() {
        if (running) {
        stopTimer();
        }
        timeElapsed = timeElapsed.subtract(Duration.seconds(1));
        timerLabel.setText(formatTime(timeElapsed));
    }
    @FXML
    private void multiplyTime() {
        if (running) {
        stopTimer();        }
        timeElapsed = timeElapsed.multiply(2);
        timerLabel.setText(formatTime(timeElapsed));
    }
    private void saveTime() {
        System.out.println("Time saved: " + timeElapsed);
    }
    private int getFinalTimeInMillis() {
        return (int) timeElapsed.toMillis();
    }
    private String formatTime(Duration duration) {
        int minutes = (int) duration.toMinutes();
        int seconds = (int) duration.toSeconds() % 60;
        int millis = (int) duration.toMillis() % 1000;
        return String.format("%02d:%02d:%03d", minutes, seconds, millis);    }
}