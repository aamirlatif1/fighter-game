package com.aamir.game.util;

import com.aamir.game.model.Weapon;

import java.util.List;
import java.util.stream.Collectors;

public class WeaponParser implements Parser<Weapon> {

    public static final int NAME = 0;
    public static final int PRICE = 1;
    public static final int DAMAGE = 2;
    public static final int DEFENCE = 3;
    public static final int LEVEL = 4;

    @Override
    public List<Weapon> parse(List<String> data) {
        List<Weapon> weaponList = data.stream().map(v -> buildWeapon(v)
        ).collect(Collectors.toList());
        return weaponList;
    }

    private Weapon buildWeapon(String weaponStr) {
        String[] fields = weaponStr.split(DELIMITER);
        Weapon weapon = new Weapon(fields[NAME], Integer.valueOf(fields[PRICE]),
                Integer.valueOf(fields[DAMAGE]), Integer.valueOf(fields[DEFENCE]));
        weapon.setLevel(Integer.valueOf(fields[LEVEL]));
        return weapon;
    }

}
