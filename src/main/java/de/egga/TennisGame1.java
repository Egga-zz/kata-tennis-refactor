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

    private int a = 0;
    private int b = 0;

    private static String getEqualScore(int value) {
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

    private static String absoluteScore(int a1, int b1) {
        return scoreToString(a1) + "-" + scoreToString(b1);
    }

    private static String getWinningScore(int a1, int b1) {
        String score;
        int minusResult = a1 - b1;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String scoreToString(int tempScore) {
        switch(tempScore)
        {
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

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            a += 1;
        } else {
            b += 1;
        }
    }

    public String getScore() {
        final int a1 = this.a;
        final int b1 = this.b;

        if (a1 == b1) {
            return getEqualScore(a1);
        }

        if (a1 < 4 && b1 < 4) {
            return absoluteScore(a1, b1);
        } else {
            return getWinningScore(a1, b1);
        }
    }
}
