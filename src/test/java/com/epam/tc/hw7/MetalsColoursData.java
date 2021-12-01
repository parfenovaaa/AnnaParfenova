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

    public void setOdd(String odd) {
        this.odd = odd;
    }

    public void setEven(String even) {
        this.even = even;
    }

    public void setElements(String elements) {
        this.elements = elements.split(", ");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables.split(", ");
    }

    public int getSum(String odd, String even) {
        return (Integer.parseInt(odd) + Integer.parseInt(even));
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
