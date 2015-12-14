package de.egga;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            addScore1();
        } else {
            addScore2();
        }
    }

    private void addScore2() {
        m_score2 += 1;
    }

    private void addScore1() {
        m_score1 += 1;
    }

    public String getScore() {
        String score;
        if (isDraw()) {
            score = getSubScore();
        } else if (hasAnyPlayerEnoughPointsToWin()) {
            score = getMainScore();
        } else {
            score = getOtherScore();
        }
        return score;
    }

    private boolean hasAnyPlayerEnoughPointsToWin() {
        return hasEnoughPointsToWin(getM_score1()) || hasEnoughPointsToWin(getM_score2());
    }

    private int getM_score1() {
        return this.m_score1;
    }

    private boolean hasEnoughPointsToWin(int m_score1) {
        return m_score1 >= 4;
    }

    private boolean isDraw() {
        return getM_score1() == getM_score2();
    }

    private String getOtherScore() {
        String score = getSuffix(getM_score1());
        score += "-";
        score += getSuffix(getM_score2());

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

    private String getMainScore() {
        String score;
        int minusResult = getM_score1() - getM_score2();
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private int getM_score2() {
        return m_score2;
    }

    private String getSubScore() {
        String score;
        switch (getM_score1()) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
