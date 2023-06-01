module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires MaterialFX;
    requires javafx.web;
    requires jdk.jsobject;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.controller;
    opens com.example.demo.controller to javafx.fxml;

}
