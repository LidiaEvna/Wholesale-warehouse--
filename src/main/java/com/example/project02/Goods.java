package com.example.project02;

import com.example.project02.inter.MyList;
import com.example.project02.model.Proba;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Goods implements Initializable {

    @FXML
    private Label nameProd;

    @FXML
    private VBox chosenFruitCard;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;


    private List<Proba> proba = new ArrayList<>();
    private MyList myList;

    private List<Proba> getData() {
        List<Proba> product = new ArrayList<>();
        Proba proba;

        proba = new Proba();
        proba.setName("Детская одежда");
        proba.setPrice(1);
        proba.setColor("FFB605");
        product.add(proba);

        proba = new Proba();
        proba.setName("Мужская одежда");
        proba.setPrice(2);
        proba.setColor("6A7324");
        product.add(proba);

        proba = new Proba();
        proba.setName("Женская одежда");
        proba.setPrice(3);
        proba.setColor("E7C00F");
        product.add(proba);

        proba = new Proba();
        proba.setName("Сумки");
        proba.setPrice(4);
        proba.setColor("A7745B");
        product.add(proba);

        proba = new Proba();
        proba.setName("Животные");
        proba.setPrice(5);
        proba.setColor("22371D");
        product.add(proba);

        proba = new Proba();
        proba.setName("Живые цветы");
        proba.setPrice(6);
        proba.setColor("6A7324");
        product.add(proba);

        return product;
    }
    private void setChosenFruit(Proba proba) {

        nameProd.setText(proba.getName());
        chosenFruitCard.setStyle("-fx-background-color: #" + proba.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        proba.addAll(getData());
        if (proba.size() > 0) {
            setChosenFruit(proba.get(0));
            myList = new MyList() {
                @Override
                public void onClickListener(Proba proba) {
                    setChosenFruit(proba);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < proba.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("but.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                num2 num = fxmlLoader.getController();
                num.setData(proba.get(i),myList);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                //установить ширину сетки
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //установить высоту сетки
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}