package de.egga;

public class TennisGame1 implements TennisGame {

    private final Player player1 = new Player();
    private final Player player2 = new Player();

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1.addPoint();
        } else {
            player2.addPoint();
        }
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
        return Player.hasEnoughPointsToWin(player1.getScore()) || Player.hasEnoughPointsToWin(player2.getScore());
    }

    private boolean isDraw() {
        return player1.getScore() == player2.getScore();
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

    private String getMainScore() {
        String score;
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
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
