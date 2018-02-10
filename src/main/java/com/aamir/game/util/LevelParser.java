package com.aamir.game.util;

import com.aamir.game.model.Level;

import java.util.List;
import java.util.stream.Collectors;

public class LevelParser implements Parser<Level> {

    @Override
    public List<Level> parse(List<String> data) {
        List<Level> levelList = data.stream().map(v -> {String[] values = v.split(DELIMITER);
            return new Level(Integer.valueOf(values[1]), Integer.valueOf(values[1]));
        }).collect(Collectors.toList());
        return levelList;
    }
}
