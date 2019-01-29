package com.codepath.examples.basicsnakegame;

/**
 * The model for a player. Each has a unique id, name, and score.
 */

public class Player {

    private int id;
    private String name;
    private int score;

    //needed for Firebase
    public Player() {}

    public Player(int n, String name, int score) {
        this.id = n;
        this.name = name;
        this.score = score;
    }

    public Player(int n, int score) {
        this(n, "", score);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name + ": " + Integer.toString(score);
    }

    public int getScore() {
        return score;
    }
}
