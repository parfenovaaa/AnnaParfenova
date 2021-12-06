package com.epam.tc.hw9.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DeletedBoard {

    public Object value;

    public Object get_value() {
        return value;
    }

    public void set_value(Object value) {
        this.value = value;
    }

    public DeletedBoard() {
    }

    public DeletedBoard(Object value) {
        this.value = value;
    }
}
