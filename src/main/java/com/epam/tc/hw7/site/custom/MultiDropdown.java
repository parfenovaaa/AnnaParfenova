package com.epam.tc.hw7.site.custom;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;

public class MultiDropdown {

    @JDropdown(root = "#colors",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown colourDropdown;

    @JDropdown(root = "#metals",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown metalsDropdown;

    @JDropdown(root = "#vegetables",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown vegetablesDropdown;


}
