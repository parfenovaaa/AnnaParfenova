package com.epam.tc.hw9.lists;

import java.util.List;
import java.util.Random;

public enum Pos {

    top("top"),
    bottom("bottom");

    public final String value;
    Pos(String value) {
        this.value = value;
    }

    private static final List<Pos> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Pos randomPos()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
