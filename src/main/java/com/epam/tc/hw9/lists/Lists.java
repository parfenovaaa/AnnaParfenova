package com.epam.tc.hw9.lists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lists {

    public String id;
    public String name;
    public boolean closed;
    public int pos;
    public String idBoard;

    public Lists() {
    }

    public Lists(String id, String name, boolean closed, int pos, String idBoard) {
        this.id = id;
        this.name = name;
        this.closed = closed;
        this.pos = pos;
        this.idBoard = idBoard;
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

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

}

