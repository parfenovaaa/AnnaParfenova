package com.epam.tc.hw9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    public static void setBoardId(String id){
        try {
            property.setProperty("boardId", id);
            property.store(new FileOutputStream("src/test/resources/boardId.properties"), null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBoardId()  {
        try {
            loadFIle("src/test/resources/boardId.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty("boardId");
    }

    public static void setBoardData(String name, String desc, String colour) {
        try {
            property.setProperty("boardName", name);
            property.setProperty("boardDesc", desc);
            property.setProperty("boardColour", colour);
            property.store(new FileOutputStream("src/test/resources/boardData.properties"), null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBoardName()  {
        try {
            loadFIle("src/test/resources/boardData.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty("boardName");
    }

    public static String getBoardDesc()  {
        try {
            loadFIle("src/test/resources/boardData.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty("boardDesc");
    }

    public static String getBoardColour()  {
        try {
            loadFIle("src/test/resources/boardData.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty("boardColour");
    }


}
