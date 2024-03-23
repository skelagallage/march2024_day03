package com.ucsc.automation.propertiesdemo;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {

    Properties properties = new Properties();
    private static final String FILE_NAME = "dbconfig.properties";

    public void writeDBProperties() throws IOException {
        OutputStream outputStream = new FileOutputStream(FILE_NAME);

        properties.setProperty("connectionString", "https://127.0.0.1/db_name");
        properties.setProperty("username", "root");
        properties.setProperty("password", "root");
        properties.setProperty("port", "3306");

        properties.store(outputStream, null);
    }

    public void readDBProperties() throws IOException {
        InputStream inputStream = new FileInputStream(FILE_NAME);
        properties.load(inputStream);
        System.out.println(properties.getProperty("connectionString"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("port"));
    }

    public static void main(String[] args) throws IOException {
//        new PropertiesDemo().writeDBProperties();
//        new PropertiesDemo().readDBProperties();

        int count = 0;
        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0)
                continue;
            count++;
        }
        System.out.println(count);
    }
}
