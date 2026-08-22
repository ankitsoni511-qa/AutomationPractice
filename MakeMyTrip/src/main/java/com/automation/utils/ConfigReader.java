package com.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("resources/config.properties")) {
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load config.properties from resources folder", e);
        }
        for (String key : prop.stringPropertyNames()) {
            String sysVal = System.getProperty(key);
            if (sysVal != null && !sysVal.isEmpty()) {
                prop.setProperty(key, sysVal); // CLI -D flag overrides file
            }
        }
    }

    public static String getProperty(String key) {
        String value = prop.getProperty(key);
        if (value == null) throw new RuntimeException("Missing config key: " + key);
        return value;
    }
}
