package com.example.project02;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class auto {

    @FXML
    private Button but;

    @FXML
    private Button but1;

    @FXML
    private TextField log;

    @FXML
    private TextField pass;

    @FXML
    private Label log1;

    @FXML
    private Label pass1;

    @FXML
    void initialize() {
        but.setOnAction(click -> {  // Фактически прописываем функционал кнопки "Вход" и функционал TextField
            but.setText("Добро пожаловать");
            System.out.println("Логин:" + log.getText());
            System.out.println("Пароль:" + pass.getText());
            but.getScene().getWindow().hide(); // 37 строчка читает из файла(к которому прописан путь к документу txt
            try (BufferedReader reader = new BufferedReader(new FileReader("D:\\project.0.2\\src\\main\\resources\\com\\example\\project02\\login.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(log.getText().trim())) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("Goods.fxml")); // Пропиываем путь к следующему окну( которое будет открываться после окна регистрации
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Верный логин");
                    }else {
                        try {
                            FXMLLoader loader = new FXMLLoader();//Создали исключение(при вводе логина и тд) для ошибки
                            loader.setLocation(getClass().getResource("Erorr.fxml")); // Пропиываем путь к окну сообщающем ошибку вврда данных
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Данные введены некорректно");
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }  // Повторяем те же действия для пароля
            try (BufferedReader reader = new BufferedReader(new FileReader("D:\\project.0.2\\src\\main\\resources\\com\\example\\project02\\pass.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(pass.getText().trim())) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("Goods.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                            stage.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Верный пароль");
                    } else {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("Erorr.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Данные введены некорректно");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        but1.setOnAction(click -> {  // Пропиываем функционал для кнопки регистрации
            but1.getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("reg.fxml"));
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