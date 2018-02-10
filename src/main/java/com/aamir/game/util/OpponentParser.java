package com.aamir.game.util;

import com.aamir.game.model.Player;
import com.aamir.game.model.PlayerBuilder;
import com.aamir.game.model.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OpponentParser implements Parser<Player> {

    public static final int NAME = 0;
    public static final int LEVEL = 1;

    @Override
    public List<Player> parse(List<String> data) {
        List<Player> playerList = data.stream().map(v -> buildPlayer(v)
        ).collect(Collectors.toList());
        return playerList;
    }

    private Player buildPlayer(String playerString) {
        String[] fields = playerString.split(DELIMITER);
        List<Weapon> weapons = new ArrayList<>();
        return PlayerBuilder.builder(fields[NAME]).
                withLevel(Integer.parseInt(fields[LEVEL])).
                withWeapons(weapons).build();
    }
}
