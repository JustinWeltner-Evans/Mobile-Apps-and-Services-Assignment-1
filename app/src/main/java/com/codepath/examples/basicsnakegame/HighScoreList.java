package com.codepath.examples.basicsnakegame;

import java.util.List;
import java.util.ArrayList;

/**
 * The model for the high score list after the player gets game over.
 */

public class HighScoreList {

    private static List<String[]> highScoreList = new ArrayList<>();
    private static final int MAX_SIZE = 10;
    private static boolean hasBeenPopulated = false;
    private static String currUsername = "";
    private static int currScore = 0;

    /**
     * Populates the high score list with default data in format:
     * String[0] = username
     * String[1] = score.
     */
    public static void populateList() {
        highScoreList.add(new String[]{"jj", "600"});
        highScoreList.add(new String[]{"secondPlace", "500"});
        highScoreList.add(new String[]{"mp", "450"});
        highScoreList.add(new String[]{"hello", "450"});
        highScoreList.add(new String[]{"meow", "400"});
        highScoreList.add(new String[]{"mprouty", "300"});
        highScoreList.add(new String[]{"frisco", "250"});
        highScoreList.add(new String[]{"justin", "200"});
        highScoreList.add(new String[]{"bob", "150"});
        highScoreList.add(new String[]{"alice", "100"});
        hasBeenPopulated = true;
    }

    /**
     * A method to make sure the high score list is only initialized once.
     * @return True if has been populated already, false otherwise.
     */
    public static boolean isPopulated() {
        return hasBeenPopulated;
    }

    /**
     * Checks if current score falls in range of high score list; if so, adds new
     * score to the list.
     */
    public static void addNewHighScore() {
        for (int i = 0; i < MAX_SIZE; i++) {
            int score = Integer.parseInt(highScoreList.get(i)[1]);
            if (currScore > score) {
                highScoreList.add(i, new String[]{currUsername, Integer.toString(currScore)});
                break;
            }
        }
        highScoreList.remove(MAX_SIZE);
    }

    public static void updateCurrentScore(int score) {
        currUsername = "mprouty";
        currScore = score;
    }

    public static List<String> convertToStringList() {
        List<String> listValues = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            listValues.add(highScoreList.get(i)[0] + ": " + highScoreList.get(i)[1]);
        }
        return listValues;
    }


}
