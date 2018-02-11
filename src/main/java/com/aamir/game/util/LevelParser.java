package com.aamir.game.util;

import com.aamir.game.model.Level;

import java.util.List;
import java.util.stream.Collectors;

public class LevelParser implements Parser<Level> {

    public static final int NUMBER = 1;
    public static final int EXPERIENCE_REQUIRED = 1;
    public static final int AVAILABLE_COINS = 2;

    @Override
    public List<Level> parse(List<String> data) {
        List<Level> levelList = data.stream().map(v -> {String[] values = v.split(DELIMITER);
            return new Level(Integer.valueOf(values[NUMBER]),
                    Integer.valueOf(values[EXPERIENCE_REQUIRED]),
                    Integer.valueOf(values[AVAILABLE_COINS]));
        }).collect(Collectors.toList());
        return levelList;
    }
}
