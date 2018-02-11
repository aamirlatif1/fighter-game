package com.aamir.game;

import com.aamir.game.model.Level;
import com.aamir.game.model.Player;
import com.aamir.game.model.Weapon;
import com.aamir.game.util.LevelParser;
import com.aamir.game.util.OpponentParser;
import com.aamir.game.util.Parser;
import com.aamir.game.util.WeaponParser;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ParserTest {

    @Test
    public void parseWeapons() throws Exception {
        Parser<Weapon> parser = new WeaponParser();
        List<String> list = Arrays.asList("Knife,20,30,0,1","Shield,20,5,10,2");
        List<Weapon> weapons = parser.parse(list);
        List<String> actual = weapons.stream().map(o -> o.getName()).collect(Collectors.toList());
        assertThat(actual, contains("Knife", "Shield"));
    }

    @Test
    public void parseLevels() throws Exception {
        Parser<Level> parser = new LevelParser();
        List<String> list = Arrays.asList("1,0", "2,10", "2,30");
        List<Level> weapons = parser.parse(list);
        List<Integer> actual = weapons.stream().map(o -> o.getExperienceRequired()).collect(Collectors.toList());
        assertThat(actual, contains(0, 10, 30));
    }

    @Test
    public void parseOpponents() throws Exception {
        Parser<Player> parser = new OpponentParser();
        List<String> list = Arrays.asList("Player1,1,1", "Player2,2,1_2", "Player3,3,1_2_3");
        List<Player> weapons = parser.parse(list);
        List<Integer> actual = weapons.stream().map(o -> o.getCurrentLevel()).collect(Collectors.toList());
        assertThat(actual, contains(1, 2, 3));
    }
}
