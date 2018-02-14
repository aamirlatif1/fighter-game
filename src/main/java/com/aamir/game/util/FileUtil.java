package com.aamir.game.util;

import com.aamir.game.cli.out.Logger;
import com.aamir.game.cli.out.LoggerFactory;
import com.aamir.game.exception.ResourceNotFoundException;
import com.aamir.game.exception.SystemException;
import com.aamir.game.model.Player;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.aamir.game.util.Constants.GAME_STAE_FILE_PATH;


public final class FileUtil {

    private static Logger logger = LoggerFactory.getLogger();

    public static List<String> readData(String fileName) throws ResourceNotFoundException {
        InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new ResourceNotFoundException(String.format("%s file not found", fileName));
        }
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            list = br.lines().skip(1).collect(Collectors.toList());
        } catch (IOException e) {
            throw new ResourceNotFoundException(e.getMessage(), e);
        }
        return list;
    }

    public static void savePlayer(Player player) {
        File file = new File(System.getProperty("user.home") + GAME_STAE_FILE_PATH);
        file.getParentFile().mkdirs();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            // Method for serialization of object
            oos.writeObject(player);
            logger.log("Player state has been Saved.");
        } catch (IOException ex) {
            throw new SystemException(ex.getMessage(), ex);
        }

    }

    public static Player loadPlayer() {
        Player player = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.home") + GAME_STAE_FILE_PATH))) {
            player = (Player) ois.readObject();
            //Files.deleteIfExists(Paths.get(System.getProperty("user.home") + GAME_STAE_FILE_PATH));
        } catch (IOException | ClassNotFoundException ex) {
            throw new SystemException(ex.getMessage(), ex);
        }
        return player;
    }

    public static boolean gameStateFileExist() {
        File file = new File(System.getProperty("user.home") + GAME_STAE_FILE_PATH);
        return file.exists();
    }
}
