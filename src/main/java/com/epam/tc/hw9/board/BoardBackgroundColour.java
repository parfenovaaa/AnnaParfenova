package com.epam.tc.hw9.board;

import java.util.List;
import java.util.Random;

public enum BoardBackgroundColour {

    blue("blue"),
    orange("orange"),
    green("green"),
    purple("purple"),
    pink("pink"),
    lime("lime"),
    sky("sky"),
    grey("grey");

    public final String value;
    BoardBackgroundColour(String value) {
        this.value = value;
    }

    private static final List<BoardBackgroundColour> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static BoardBackgroundColour randomColour()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
