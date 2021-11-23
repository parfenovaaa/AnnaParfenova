package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.site.custom.MultiDropdown;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColoursPage extends WebPage {

    @UI("[type='checkbox']") public static Checklist elementsCheckList;
    @UI("[name=custom_radio_even]") public static RadioButtons evenRadioButtons;
    @UI("[name=custom_radio_odd]") public static RadioButtons oddRadioButtons;
    @UI(".results") public static UIElement resultText;
    @UI("[id=submit-button]") public static Button submitButton;
    @XPath("//div[@class='row'][1]") public static MultiDropdown multiDropdown;

}
