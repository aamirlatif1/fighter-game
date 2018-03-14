package com.aamir.game;

import com.aamir.game.cli.in.ConsoleReader;
import com.aamir.game.cli.in.InputReader;
import com.aamir.game.exception.SystemException;
import com.aamir.game.play.Game;
import org.junit.*;

import java.io.File;

import static com.aamir.game.util.Constants.GAME_STAE_FILE_PATH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoadMetadataTest {

    Game game;
    InputReader inputReader = new ConsoleReader();

    @AfterClass
    public static void tearDownClass() throws Exception {
        File file = new File(System.getProperty("user.home")+GAME_STAE_FILE_PATH);
        if(file.exists())
            file.delete();
    }

    @Before
    public void setUp() throws Exception {
        game = new Game(inputReader);
    }

    @Test(expected = SystemException.class)
    public void loadGameWhenNotExist() throws Exception {
        File file = new File(System.getProperty("user.home")+GAME_STAE_FILE_PATH);
        if(file.exists())
            file.delete();
        game.loadGameState();
    }
    
    @Test
    public void saveGameStateAndCheckFileExist() throws Exception {
        game.start("Aamir");
        game.getPlayer().saveGame();
        File file = new File(System.getProperty("user.home")+GAME_STAE_FILE_PATH);
        assertTrue(file.exists());
    }

    @Test
    public void loadSavedGame() throws Exception {
        game.loadGameState();
        assertEquals("Aamir", game.getPlayer().getDisplayName());
    }
}
