package com.aamir.game.util;

import com.aamir.game.model.Player;
import com.aamir.game.model.PlayerBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OpponentParser implements Parser<Player> {

    public static final int NAME = 0;
    public static final int LEVEL = 1;
    public static final int WEAPONS = 2;

    @Override
    public List<Player> parse(List<String> data) {
        List<Player> playerList = data.stream().map(v -> buildPlayer(v)
        ).collect(Collectors.toList());
        return playerList;
    }

    private Player buildPlayer(String playerString) {
        String[] fields = playerString.split(DELIMITER);
        List<Integer> weaponId = Arrays.asList(
                fields[WEAPONS].split("_"))
                .stream()
                .map(o -> Integer.valueOf(o))
                .collect(Collectors.toList());

        return PlayerBuilder.builder(fields[NAME])
                .withLevel(Integer.parseInt(fields[LEVEL]))
                .withWeaponIds(weaponId).build();
    }
}
