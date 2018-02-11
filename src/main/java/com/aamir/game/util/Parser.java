package com.aamir.game.util;

import java.util.List;

/**
 * Parse String data to list of objects
 * @param <T>
 */
@FunctionalInterface
public interface Parser<T> {

    String DELIMITER = ",";

    /**
     * uses {@link List<String>} and parses List of T
     * @param data
     * @return parsed list of T
     */
    List<T> parse(List<String> data);
}