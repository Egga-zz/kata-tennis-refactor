package de.egga;

public class Player {

    int score = 0;

    public Player() {
    }

    void addPoint() {
        score += 1;
    }

    int getScore() {
        return score;
    }

    public static boolean hasEnoughPointsToWin(Player player) {
        return player.getScore() >= 4;
    }
}