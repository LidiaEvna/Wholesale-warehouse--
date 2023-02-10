package com.example.project02;

import com.example.project02.inter.MyList;
import com.example.project02.model.Proba;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class num2 {

    @FXML
    private Label priceLabel;

    @FXML
    private ImageView img;

    @FXML
    private Label name;

    @FXML
    private Button but;


    @FXML
    void click(MouseEvent event) {
        myList.onClickListener(proba);
        but.setOnAction(click -> {  // Пропиываем функционал для кнопки регистрации
            but.getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("market.fxml"));
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

    private Proba proba;
    private MyList myList;

    public void setData(Proba proba, MyList myList) {
        this.proba = proba;
        this.myList = myList;

        but.setText("Товары");

        name.setText(proba.getName());
        priceLabel.setText(HelloApplication.CURRENCY + proba.getPrice());
    }

}