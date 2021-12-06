package com.epam.tc.hw9;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetSetData {

    public static String consumerKey;
    public static String accessToken;

    public static Properties property = new Properties();

    public static void loadFIle(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        property.load(file);
    }

    public static String getToken() throws IOException {
        loadFIle("src/test/resources/api.properties");
        return accessToken = property.getProperty("accessToken");
    }

    public static String getKey() throws IOException {
        loadFIle("src/test/resources/api.properties");
        return consumerKey = property.getProperty("consumerKey");
    }

}
