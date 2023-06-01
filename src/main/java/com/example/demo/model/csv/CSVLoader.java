package com.example.demo.model.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVLoader {

    public List<List<String>> loadCsv(String datasourcePath) {
        List<List<String>> datasourceContent = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(datasourcePath));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] values = currentLine.split(",");
                datasourceContent.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return datasourceContent;
    }
}
