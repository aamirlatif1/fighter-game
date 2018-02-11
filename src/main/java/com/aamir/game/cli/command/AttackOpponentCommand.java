package com.aamir.game.cli.command;

import com.aamir.game.Fight;

public class AttackOpponentCommand implements Command {
    private Fight fight;

    public AttackOpponentCommand(Fight fight) {
        this.fight = fight;
    }

    @Override
    public void execute() {
        fight.attackWithSelectedWeapon();
    }
}
