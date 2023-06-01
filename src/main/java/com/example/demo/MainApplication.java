package com.example.demo;

import com.example.demo.controller.Controller;
import com.example.demo.controller.WebViewController;
import com.example.demo.model.csv.CSVLoader;
import com.example.demo.model.csv.CSVParser;
import com.example.demo.model.entities.Country;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainApplication extends Application {

    static WebEngine webEngine;
    @Override
    public void start(Stage stage) throws IOException {
        WebView webView = new WebView();
        webEngine = webView.getEngine();
        WebViewController webViewController = new WebViewController(webEngine);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        VBox vBox = new VBox(webView, fxmlLoader.load());
        Scene scene = new Scene(vBox, 960, 600);
        MFXThemeManager.addOn(scene, Themes.DEFAULT, Themes.LEGACY);
        stage.setTitle("POP Mental");

        loadData();

        stage.setScene(scene);
        stage.show();
    }

    private void loadData(){
        CSVLoader csvLoader = new CSVLoader();
        List<List<String>> test = csvLoader.loadCsv("src/main/resources/com/example/datasource/Datasource.csv");
        CSVParser parser = new CSVParser();
        List<Country> countryDatasetList = parser.parseData(test);
        Controller.setCountryDatasetList(countryDatasetList);
    }

    public static void main(String[] args) {
        launch();
    }
}