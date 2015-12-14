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

    static boolean hasEnoughPointsToWin(int m_score1) {
        return m_score1 >= 4;
    }

    public static boolean hasEnoughPointsToWin(Player player) {
        return hasEnoughPointsToWin(player.getScore());
    }
}