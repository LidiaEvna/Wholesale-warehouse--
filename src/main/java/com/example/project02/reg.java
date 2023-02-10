package com.example.project02;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class reg {

    @FXML
    private TextField log;

    @FXML
    private TextField pas;

    @FXML
    private Button but1;

    @FXML
    void initialize() {
        but1.setOnAction(click -> {
            System.out.println("Логин:" + log.getText());
            System.out.println("Пароль:" + pas.getText());
            but1.getScene().getWindow().hide();
            // Запись в txt документ для регистрации
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\project.0.2\\src\\main\\resources\\com\\example\\project02\\login.txt"))) {
                writer.write(log.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("auto.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\project.0.2\\src\\main\\resources\\com\\example\\project02\\pass.txt"))) {
                writer.write(pas.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("auto.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        });
    }
}