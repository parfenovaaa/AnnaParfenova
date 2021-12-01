package com.epam.tc.hw7;

import com.jdiai.tools.DataClass;
import java.util.Arrays;

public class MetalsColoursData extends DataClass<MetalsColoursData> {
    public String odd;
    public String even;
    public String[] elements;
    public String color;
    public String metal;
    public String[] vegetables;

    public int getSum(String odd, String even) {
        return (Integer.parseInt(odd) + Integer.parseInt(even));
    }

    public MetalsColoursData(String odd, String even, String elements, String color, String metal,
                             String vegetables) {
        this.odd = odd;
        this.even = even;
        this.elements = elements.split(", ");
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables.split(", ");
    }

    public String getDataInLine() {
        String fullLine = "Summary: " + getSum(odd, even)
                        + "\nElements: " + Arrays.toString(elements)
                        + "\nColor: " + color
                        + "\nMetal: " + metal
                        + "\nVegetables: " + Arrays.toString(vegetables);
        String regex = "[\\p{Ps}\\p{Pe}]";

        return fullLine.replaceAll(regex, "");
    }
}
