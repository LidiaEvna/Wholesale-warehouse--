module com.example.project02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.project02 to javafx.fxml;
    exports com.example.project02;
    exports com.example.project02.model;
    opens com.example.project02.model to javafx.fxml;
    exports com.example.project02.inter;
    opens com.example.project02.inter to javafx.fxml;
}