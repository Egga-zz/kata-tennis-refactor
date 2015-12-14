package de.egga;

public class Player {

    int score = 0;
    final String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean hasSameScoreAs(Player player2) {
        return score == player2.getScore();
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

    public boolean isCalled(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }
}