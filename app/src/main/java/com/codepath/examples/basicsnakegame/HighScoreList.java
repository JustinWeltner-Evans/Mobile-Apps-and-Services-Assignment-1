package com.codepath.examples.basicsnakegame;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.ArrayList;

/**
 * The model for the high score list after the player gets game over.
 */

public class HighScoreList {

    private static List<Player> highScoreList = new ArrayList<>();
    private static final int MAX_SIZE = 12;
    private static boolean hasBeenPopulated = false;
    private static String currUsername = "";
    private static int currScore = 0;
    private static int numPlayer = 1;
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    /**
     * Populates the high score list with default players.
     */
    public static void populateList() {
        highScoreList.add(new Player(numPlayer++, "jj", 600));
        highScoreList.add(new Player(numPlayer++, "secondPlace", 500));
        highScoreList.add(new Player(numPlayer++, "mp", 450));
        highScoreList.add(new Player(numPlayer++, "hello", 450));
        highScoreList.add(new Player(numPlayer++, "meow", 400));
        highScoreList.add(new Player(numPlayer++, "mprouty", 300));
        highScoreList.add(new Player(numPlayer++, "frisco", 250));
        highScoreList.add(new Player(numPlayer++, "justin", 200));
        highScoreList.add(new Player(numPlayer++, "bob", 150));
        highScoreList.add(new Player(numPlayer++, "caleb", 100));
        highScoreList.add(new Player(numPlayer++, "maddie", 50));
        highScoreList.add(new Player(numPlayer++, "alice", 50));
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
            int score = highScoreList.get(i).getScore();
            if (currScore > score) {

                Player newPlayer = new Player(numPlayer++, currUsername, currScore);
                DatabaseReference player = mDatabase.child("Player");
                player.push().setValue(newPlayer);

                highScoreList.add(i,newPlayer);
                highScoreList.remove(MAX_SIZE);
                break;
            }
        }

    }

    public static void updateList(Player player) {
        System.out.println(player.toString());
        for (int i = 0; i < MAX_SIZE; i++) {
            int score = highScoreList.get(i).getScore();
            if (player.getScore() > score) {
                highScoreList.add(i,player);
                highScoreList.remove(MAX_SIZE);
                break;
            }
        }
    }



    /**
     * Update the current score to the most recently played score.
     * @param score The score from the last game of Snake.
     */
    public static void updateCurrentScore(int score) {
        currUsername = "freddie";
        currScore = score;
    }

    /**
     * Converts the high score list to a list of Strings for the ListView.
     * @return the list of Strings representing the high scores for each username
     * and score combination.
     */
    public static List<String> convertToStringList() {
        List<String> listValues = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            listValues.add(highScoreList.get(i).toString());
        }
        return listValues;
    }


}
