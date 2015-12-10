package de.egga;

public class TennisGame1 implements TennisGame {

    static final String LOVE = "Love";
    static final String FIFTEEN = "Fifteen";
    static final String THIRTY = "Thirty";
    static final String FORTY = "Forty";
    static final String DEUCE = "Deuce";
    static final String THIRTY_ALL = "Thirty-All";
    static final String FIFTEEN_ALL = "Fifteen-All";
    static final String LOVE_ALL = "Love-All";

    private static String equalScore(int value) {
        switch (value) {
            case 0:
                return LOVE_ALL;
            case 1:
                return FIFTEEN_ALL;
            case 2:
                return THIRTY_ALL;
            default:
                return DEUCE;
        }
    }

    private static String absoluteScore(int x, int y) {
        return absoluteScore(x) + "-" + absoluteScore(y);
    }

    private static String relativeScore(int x, int y) {
        String score;
        int minusResult = x - y;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String absoluteScore(int i) {
        switch (i) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
            default:
                return "";
        }
    }

    private int a = 0;
    private int b = 0;

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            a += 1;
        } else {
            b += 1;
        }
    }

    public String getScore() {
        if (a == b) {
            return equalScore(a);
        } else if (a < 4 && b < 4) {
            return absoluteScore(a, b);
        }

        return relativeScore(a, b);
    }

}