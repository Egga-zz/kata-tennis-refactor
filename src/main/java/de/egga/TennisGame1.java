package de.egga;

public class TennisGame1 implements TennisGame {

    private final Player player1 ;
    private final Player player2 ;

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
        return player1.hasEnoughPointsToWin() || player2.hasEnoughPointsToWin();
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
        if (minusResult == 1) score = "Advantage " + player1.getName();
        else if (minusResult == -1) score = "Advantage " + player2.getName();
        else if (minusResult >= 2) score = "Win for " + player1.getName();
        else score = "Win for " + player2.getName();
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
