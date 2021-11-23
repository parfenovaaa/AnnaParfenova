package com.epam.tc.hw7;

import com.jdiai.tools.DataClass;
import java.util.Arrays;

public class MetalsColoursData extends DataClass<MetalsColoursData> {
    public long[] summary;
    public String[] elements;
    public String color;
    public String metal;
    public String[] vegetables;

    public int getSum(long[] summary) {
        return (int) (summary[0] + summary[1]);
    }

    public MetalsColoursData set(long[] summary, String[] elements, String color, String metal, String[] vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
        return this;
    }

    public String getDataInLine() {
        return "Summary: " + getSum(summary)
            + "\nElements: " + Arrays.toString(elements)
            + "\nColor: " + color
            + "\nMetal: " + metal
            + "\nVegetables: " + Arrays.toString(vegetables);
    }
}
