package com.epam.tc.hw9.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Prefs {
    public String background;

    public Prefs() {
    }

    public Prefs(String background) {
        this.background = background;
    }

    @Override
    public String toString() {
        return "Prefs{"
            + "background='" + background + '\'' + '}';
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
