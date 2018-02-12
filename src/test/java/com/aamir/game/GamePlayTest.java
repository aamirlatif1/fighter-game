package com.aamir.game;

import com.aamir.game.state.FightState;
import com.aamir.game.state.PurchaseWeaponState;
import com.aamir.game.state.StartedState;
import com.aamir.game.cli.command.*;
import com.aamir.game.cli.in.ConsoleReader;
import com.aamir.game.cli.in.InputReader;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.aamir.game.cli.*")
public class GamePlayTest {


    private InputReader inputReader;

    @Before
    public void setUp() throws Exception {
        inputReader = mock(ConsoleReader.class);
    }

    @Test
    public void playGameWithCommands() throws Exception {
        Game game = new Game(inputReader);
        when(inputReader.readString()).thenReturn("Aamir");

        Command startGameCommand = new GameStartCommand(game);
        startGameCommand.execute();
        assertThat( game.getState(), CoreMatchers.instanceOf(StartedState.class));

        Command purchaseWeaponCommand = new PurchaseWeaponCommand(game, 2);
        purchaseWeaponCommand.execute();
        assertThat( game.getState(), CoreMatchers.instanceOf(StartedState.class));

        Command startFightCommand = new StartFightCommand(game);
        startFightCommand.execute();
        assertThat( game.getState(), CoreMatchers.instanceOf(FightState.class));

        Command attackCommand = new AttackOpponentCommand(game);
        for (int i = 0; i < 9; i++)
            attackCommand.execute();
        assertThat( game.getState(), CoreMatchers.instanceOf(FightState.class));
        attackCommand.execute();
        assertThat( game.getState(), CoreMatchers.instanceOf(StartedState.class));
    }

    @Test
    public void gamePlayWithMacroCommand() throws Exception {
        Game game = new Game(inputReader);
        game.executeCommand(1);
        assertThat( game.getState(), CoreMatchers.instanceOf(StartedState.class));

        game.executeCommand(2);
        assertThat( game.getState(), CoreMatchers.instanceOf(PurchaseWeaponState.class));

    }
}
