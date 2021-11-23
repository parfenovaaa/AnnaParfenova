package com.epam.tc.hw5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {

    public static String login;
    public static String password;
    public static String userName;
    public static String indexAddress;

    public static void getProp() throws IOException {
        FileInputStream file;
        Properties property = new Properties();

        file = new FileInputStream("src/test/resources/config.properties");
        property.load(file);

        login = property.getProperty("login.name");
        password = property.getProperty("login.password");
        userName = property.getProperty("login.userName");
        indexAddress = property.getProperty("page.address");
    }

}
