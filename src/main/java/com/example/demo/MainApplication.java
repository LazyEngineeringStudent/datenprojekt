package com.example.demo;

import com.example.demo.model.csv.CSVLoader;
import com.example.demo.model.csv.CSVParser;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);
        MFXThemeManager.addOn(scene, Themes.DEFAULT, Themes.LEGACY);
        stage.setTitle("NoMansLand");
        CSVLoader csvLoader = new CSVLoader();
        List<List<String>> test = csvLoader.loadCsv("src/main/resources/com/example/datasource/Datasource.csv");
        CSVParser parser = new CSVParser();
        parser.parseData(test);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}