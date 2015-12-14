package de.egga;

public class TennisGame1 implements TennisGame {

    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private int m_score2 = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1.addPoint();
        } else {
            addScore2();
        }
    }

    private void addScore2() {
        player2.addPoint();
        m_score2 += 1;
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
        return hasEnoughPointsToWin(player1.getScore()) || hasEnoughPointsToWin(getM_score2());
    }

    private boolean hasEnoughPointsToWin(int m_score1) {
        return m_score1 >= 4;
    }

    private boolean isDraw() {
        return player1.getScore() == getM_score2();
    }

    private String getOtherScore() {
        String score = getSuffix(player1.getScore());
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
        int minusResult = player1.getScore() - getM_score2();
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private int getM_score2() {
        return player2.getScore();
    }

    private String getSubScore() {
        String score;
        switch (player1.getScore()) {
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
