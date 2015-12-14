package de.egga;

import java.util.List;

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
            score = getOtherScore();
        }
        return score;
    }

    private boolean hasAnyPlayerEnoughPointsToWin() {
        return player1.hasEnoughPointsToWin() || player2.hasEnoughPointsToWin();
    }

    private String getOtherScore() {
        String score = getSuffix(player1.getScore());
        score += "-";
        score += getSuffix(player2.getScore());

        return score;
    }

    private String getSuffix(int tempScore) {
        String score = "";
        switch (tempScore) {
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
        String score;
        Player betterPlayer;
        int difference = player1.getScore() - player2.getScore();
        if (difference > 0) {
            betterPlayer = player1;
        } else {
            betterPlayer = player2;
        }
        if (Math.abs(difference) == 1) {
            score = "Advantage " + betterPlayer.getName();
        } else {
            score = "Win for " + betterPlayer.getName();
        }

        return score;
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
