package com.epam.tc.hw9.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {

    public String id;
    public String name;
    public String desc;
    public Prefs prefs;

    public Board() {
    }

    public Board(String id, String name, String desc, Prefs prefs) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.prefs = prefs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    @Override
    public String toString() {
        return "Board{"
            + "id='" + id + '\''
            + ", name='" + name + '\''
            + ", desc='" + desc + '\''
            + ", prefs=" + prefs + '}';
    }
}

