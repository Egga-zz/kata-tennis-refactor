package de.egga;

import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    public static final String DEUCE = "Deuce";

    private final String firstPlayerName;

    private final String secondPlayerName;

    public static final String ADVANTAGE_FORMAT = "Advantage %s";

    public static final String WIN_FORMAT = "Win for %s";

    private int firstPlayerScore = 0;

    private int secondPlayerScore = 0;

    private static final Map<Integer, String> SCORE_MAP = new HashMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    public TennisGame1(String player1Name, String player2Name) {

        this.firstPlayerName = player1Name;
        this.secondPlayerName = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {

        if (playerName.equals(firstPlayerName)) {
            firstPlayerScore++;
        } else if (playerName.equals(secondPlayerName)) {
            secondPlayerScore++;
        } else {
            throw new IllegalArgumentException("Player " + playerName + " is not playing in this game");
        }
    }

    @Override
    public String getScore() {

        if (isBeforeFirstDeuce()) {
            return getScoreBeforeFirstDeuce();
        } else {
            return getScoreAfterFirstDeuce();
        }
    }

    private boolean isBeforeFirstDeuce() {

        return firstPlayerScore < 4 && secondPlayerScore < 4 && (firstPlayerScore + secondPlayerScore < 6);
    }

    private String getScoreBeforeFirstDeuce() {

        return getScoreForOnePlayerUnderFourPoints(firstPlayerScore) + "-" + (firstPlayerScore == secondPlayerScore ?
                                                                              "All" :
                                                                              getScoreForOnePlayerUnderFourPoints(
                                                                                      secondPlayerScore          ));
    }

    private String getScoreForOnePlayerUnderFourPoints(final int playerScore) {

        return SCORE_MAP.get(playerScore);
    }

    private String getScoreAfterFirstDeuce() {

        int scoreDifference = firstPlayerScore - secondPlayerScore;

        if (scoreDifference == 0) {
            return DEUCE;
        }
        if (scoreDifference == 1) {
            return String.format(ADVANTAGE_FORMAT, firstPlayerName);
        }
        if (scoreDifference == -1) {
            return String.format(ADVANTAGE_FORMAT, secondPlayerName);
        }
        if (scoreDifference >= 2) {
            return String.format(WIN_FORMAT, firstPlayerName);
        }
        return String.format(WIN_FORMAT, secondPlayerName);
    }
}
