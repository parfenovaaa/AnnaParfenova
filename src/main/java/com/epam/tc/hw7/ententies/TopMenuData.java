package com.epam.tc.hw7.ententies;

public enum TopMenuData {

    Home("Home"),
    ContactForm("Contact form"),
    Service("Service"),
    MetalsColors("Metals & Colors");

    public String value;
    TopMenuData(String value) {
        this.value = value;
    }
}
