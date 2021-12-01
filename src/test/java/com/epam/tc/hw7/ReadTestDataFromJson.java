package com.epam.tc.hw7;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class ReadTestDataFromJson {

    @DataProvider(name = "readJsonToMetalsColoursData")
    public static Object[][] readJsonToMetalsColoursData() throws IOException, ParseException {

        String fileName = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(fileName));

        Object[][] returnValue = new Object[jsonObject.size()][1];

        for (int i = 0; i < jsonObject.size(); i++) {
            JSONObject data = (JSONObject) jsonObject.get("data_" + (i + 1));

            JSONArray summaryArray = (JSONArray) data.get("summary");

            MetalsColoursData metalsColoursData = new MetalsColoursData();

            for (Object o : summaryArray) {
                if ((long) o % 2 == 0) {
                    metalsColoursData.setEven(o.toString());
                } else {
                    metalsColoursData.setOdd(o.toString());
                }
            }

            JSONArray elementsArray = (JSONArray) data.get("elements");
            StringBuilder elements = new StringBuilder();
            for (Object value : elementsArray) {
                elements.append(value).append(", ");
            }
            metalsColoursData.setElements(elements.toString());

            metalsColoursData.setColor(data.get("color").toString());
            metalsColoursData.setMetal(data.get("metals").toString());

            JSONArray vegetablesArray = (JSONArray) data.get("vegetables");
            StringBuilder vegetables = new StringBuilder();
            for (Object o : vegetablesArray) {
                vegetables.append(o).append(", ");
            }
            metalsColoursData.setVegetables(vegetables.toString());

            returnValue[i][0] = metalsColoursData;
        }

        return returnValue;
    }

}
