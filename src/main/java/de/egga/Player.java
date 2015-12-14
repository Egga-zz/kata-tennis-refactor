package de.egga;

public class Player {

    int score = 0;
    final String name;

    public Player(String name) {
        this.name = name;
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