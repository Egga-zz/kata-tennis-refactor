package de.egga;

import java.util.List;

import static java.lang.Math.abs;
import static java.util.Arrays.asList;

public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.isCalled(playerName)) {
            player1.addPoint();
        } else if (player2.isCalled(playerName)) {
            player2.addPoint();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getScore() {
        String score;
        if (player1.hasSameScoreAs(player2)) {
            score = getSpokenScoreInCaseOfDraw();
        } else if (hasAnyPlayerEnoughPointsToWin()) {
            score = getSpokenScoreInFinalPhase();
        } else {
            score = getSpokenScoreInStartingPhase();
        }
        return score;
    }

    private boolean hasAnyPlayerEnoughPointsToWin() {
        return player1.hasEnoughPointsToWin() || player2.hasEnoughPointsToWin();
    }

    private String getSpokenScoreInStartingPhase() {
        return getSpokenScoreOfSinglePlayer(player1) + "-" + getSpokenScoreOfSinglePlayer(player2);
    }

    private String getSpokenScoreOfSinglePlayer(Player player) {
        String score = "";
        switch (player.getScore()) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private String getSpokenScoreInFinalPhase() {
        Player betterPlayer = findBetterPlayer(player1, player2);
        int delta = abs(player1.getScore() - player2.getScore());
        if (delta == 1) {
            return "Advantage " + betterPlayer.getName();
        } else {
            return "Win for " + betterPlayer.getName();
        }
    }

    private Player findBetterPlayer(Player player1, Player player2) {
        int difference = player1.getScore() - player2.getScore();
        if (difference > 0) {
            return player1;
        } else {
            return player2;
        }
    }

    private String getSpokenScoreInCaseOfDraw() {
        List<String> spokenScore = asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce");
        int score = player1.getScore();
        if (score >= spokenScore.size()) {
            score = spokenScore.size() - 1;
        }
        return spokenScore.get(score);
    }
}
