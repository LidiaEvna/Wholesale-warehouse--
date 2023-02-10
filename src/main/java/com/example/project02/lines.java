package com.example.project02;

import com.example.project02.inter.MyListener;
import com.example.project02.model.Products;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class lines implements Initializable {

    @FXML
    private VBox chosenFruitCard;

    @FXML
    private Button but1;

    @FXML
    private Label fruitPriceLable;

    @FXML
    private Label fruitNameLable;

    @FXML
    private Button but;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Products> products = new ArrayList<>();
    private MyListener myListener;

    private List<Products> getData() {
        List<Products> product = new ArrayList<>();
        Products products;

        products = new Products();
        products.setName("Брюки");
        products.setPrice(200);
        products.setColor("FFB605");
        product.add(products);

        products = new Products();
        products.setName("Костюм");
        products.setPrice(195);
        products.setColor("6A7324");
        product.add(products);

        products = new Products();
        products.setName("Комбинезон зимний");
        products.setPrice(300);
        products.setColor("E7C00F");
        product.add(products);

        products = new Products();
        products.setName("Туфли кожанные");
        products.setPrice(150);
        products.setColor("A7745B");
        product.add(products);

        products = new Products();
        products.setName("Рубашка");
        products.setPrice(50);
        products.setColor("22371D");
        product.add(products);

        products = new Products();
        products.setName("Кепка");
        products.setPrice(25);
        products.setColor("6A7324");
        product.add(products);

        products = new Products();
        products.setName("Шляпа");
        products.setPrice(25);
        products.setColor("FB5D03");
        product.add(products);

        products = new Products();
        products.setName("Набор белья");
        products.setPrice(55);
        products.setColor("F16C31");
        product.add(products);

        products = new Products();
        products.setName("Подтяжки");
        products.setPrice(9);
        products.setColor("15");
        product.add(products);

        return product;
    }

    private void setChosenFruit(Products products) {

        fruitNameLable.setText(products.getName());
        fruitPriceLable.setText(HelloApplication.CURRENCY + products.getPrice());
        chosenFruitCard.setStyle("-fx-background-color: #" + products.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        products.addAll(getData());
        if (products.size() > 0) {
            setChosenFruit(products.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Products products) {
                    setChosenFruit(products);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("iten.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                num num = fxmlLoader.getController();
                num.setData(products.get(i),myListener);

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
        but1.setOnAction(click -> {
            but1.getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Goods.fxml"));
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
