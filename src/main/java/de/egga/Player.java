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

    public boolean hasEnoughPointsToWin() {
        return score >= 4;
    }

}