package com.epam.tc.hw7;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTestDataFromJson {

    public MetalsColoursData readJsonToMetalsColoursData(int j) {

        String fileName = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) new JSONParser().parse(new FileReader(fileName));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject data = (JSONObject) jsonObject.get("data_" + j);

        JSONArray summaryArray = (JSONArray) data.get("summary");
        String oddsSelector = "";
        String evenSelector = "";
        for (Object o : summaryArray) {
            if ((long) o % 2 == 0) {
                evenSelector = o.toString();
            } else {
                oddsSelector = o.toString();
            }
        }

        JSONArray elementsArray = (JSONArray) data.get("elements");
        String[] elements = new String[elementsArray.size()];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = (String) elementsArray.get(i);
        }

        JSONArray vegetablesArray = (JSONArray) data.get("vegetables");
        String[] vegetables = new String[vegetablesArray.size()];
        for (int i = 0; i < vegetables.length; i++) {
            vegetables[i] = (String) vegetablesArray.get(i);
        }

        String color = (String) data.get("color");
        String metal = (String) data.get("metals");

        MetalsColoursData metalsColoursData = new MetalsColoursData();

        return metalsColoursData.set(oddsSelector, evenSelector, elements, color, metal, vegetables);
    }
}
