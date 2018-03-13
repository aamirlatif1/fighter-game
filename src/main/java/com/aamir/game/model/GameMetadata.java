package com.aamir.game.model;

import com.aamir.game.model.Level;
import com.aamir.game.model.Player;
import com.aamir.game.model.Weapon;
import com.aamir.game.util.*;

import java.util.List;

import static com.aamir.game.util.Constants.LEVELS_FILE_PATH;
import static com.aamir.game.util.Constants.OPPONENT_FILE_PATH;
import static com.aamir.game.util.Constants.WEAPONS_FILE_PATH;

public class GameMetadata {

    public static final int DEFAULT_INDEX = 0;

    private List<Weapon> weapons;
    private List<Player> opponents;
    private List<Level> levels;

    public GameMetadata() {
        loadOpponents();
        loadWeapons();
        loadWLevels();
    }

    private  void loadWeapons() {
        Parser<Weapon> parser = new WeaponParser();
        List<String> data = FileUtil.readData(WEAPONS_FILE_PATH);
        weapons = parser.parse(data);
    }
    private  void loadWLevels() {
        Parser<Level> parser = new LevelParser();
        List<String> data = FileUtil.readData(LEVELS_FILE_PATH);
        levels = parser.parse(data);
    }
    private  void loadOpponents() {
        Parser<Player> parser = new OpponentParser();
        List<String> data = FileUtil.readData(OPPONENT_FILE_PATH);
        opponents = parser.parse(data);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Player> getOpponents() {
        return opponents;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public Weapon getDefaultWeapon() {
        return getWeapons().get(DEFAULT_INDEX);
    }

    public Weapon getWeapon(int index) {
        return getWeapons().get(index);
    }
}
