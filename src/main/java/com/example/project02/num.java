package com.example.project02;
import com.example.project02.inter.MyListener;
import com.example.project02.model.Products;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class num {

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
        private void click(MouseEvent mouseEvent) {
            myListener.onClickListener(products);
        }

        private Products products;
        private MyListener myListener;

        public void setData(Products products, MyListener myListener) {
            this.products = products;
            this.myListener = myListener;

            nameLabel.setText(products.getName());
            priceLable.setText(HelloApplication.CURRENCY + products.getPrice());
        }

}