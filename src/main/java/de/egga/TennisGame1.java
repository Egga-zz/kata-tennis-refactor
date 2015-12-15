package de.egga;

public class TennisGame1 implements TennisGame {

    private static final int MAX_SCORE = 4;

    private int player1RawScore = 0;
    private int player2RawScore = 0;
    private String player1Name;
    private String player2Name;


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        // NOTE: check against actual player names
        if (playerName == this.player1Name) {
            player1RawScore += 1;
        } else if (playerName == this.player2Name) {
            player2RawScore += 1;
        }
        // TODO: throw exception for unknown name
    }

    public String getScore() {
        String score = "";

        // NOTE: logig moved to private functions
        if (player1RawScore==player2RawScore) {
            score = equalScoreToString(player1RawScore);
        } else if (player1RawScore>=MAX_SCORE || player2RawScore>=MAX_SCORE) {
            score = tiedScoreToString(player1RawScore, player2RawScore);
        } else {
            score = playerScoreToString(player1RawScore) + "-" + playerScoreToString(player2RawScore);
        }

        return score;
    }

    private String equalScoreToString(int mScore) {
        switch (mScore)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
        }
        return "Deuce";
    }

    private String tiedScoreToString(int p1Score, int p2Score) {
        int scoreDifference = p1Score - p2Score;
        if (scoreDifference == 1) {
            return "Advantage " + this.player1Name;
        } else if (scoreDifference == -1) {
            return "Advantage " + this.player2Name;
        } else if (scoreDifference >= 2) {
            return "Win for " + this.player1Name;
        }
        return "Win for " + this.player2Name;
    }

    private String playerScoreToString(int mScore) {
        // NOTE: unintuitive loop construct removed
        // NOTE: breaks removed
        switch(mScore)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        // TODO: Throw exception
        return "Undefined";
    }

}
