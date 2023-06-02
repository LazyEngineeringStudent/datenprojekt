package com.example.demo.controller;

import com.example.demo.util.DataAttributes;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import java.net.URL;
import java.util.List;

public class WebViewController {
    static WebEngine webEngine;

    public static void setData(List<List<String>> data, DataAttributes dataAttribute){
        webEngine.executeScript("setData('" + convertDoubleStringArray(data) + "', '" + dataAttribute + "')");
        webEngine.executeScript("drawChart()");
    }

    public static void changeColorAxis(String color1, String color2){
        webEngine.executeScript("changeColorAxis('" + color1 + "', '" + color2 + "')");
    }

    public WebViewController(WebEngine webEngine1){
        webEngine = webEngine1;

        URL url = this.getClass().getResource("/com/example/demo/worldmap.html");
        webEngine.load(url.toString());
    }

    private static String convertDoubleStringArray(List<List<String>> data){
        String data1 = "Country ; Popularity";
        for (List<String> dat : data) {
            data1 += "," + dat.get(0) + ";" + dat.get(1);
        }
        return data1;
    }
}
