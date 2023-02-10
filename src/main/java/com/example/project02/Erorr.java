package com.example.project02;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Erorr {

    @FXML
    private Button but;

    @FXML
    void initialize() {
        but.setOnAction(click -> {  // Пропиываем функционал для кнопки регистрации
            but.getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("auto.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}