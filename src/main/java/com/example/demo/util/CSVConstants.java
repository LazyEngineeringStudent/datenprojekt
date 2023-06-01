package com.example.demo.util;

import lombok.Getter;

public enum CSVConstants {
    COMMA_DELIMITER(",");

    @Getter
    private final String value;
    private CSVConstants(String value) {
        this.value = value;
    }
}
