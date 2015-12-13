package de.egga;

public class TennisGame1 implements TennisGame {

    private int scoreOfTeamOne = 0;
    private int scoreOfTeamTwo = 0;
    private final String teamOne;
    private final String teamTwo;

    private final String[] SCORE_NAMES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};


    public TennisGame1(String teamOne, String teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public void wonPoint(String playerName) {
        if (teamOne.equals(playerName))
            scoreOfTeamOne++;
        else
            scoreOfTeamTwo++;
    }

    public String getScore() {

        if (scoreOfTeamOne == 3 && scoreOfTeamTwo == 3 || scoreOfTeamOne == 4 && scoreOfTeamTwo == 4)
            return "Deuce";
        if (scoreOfTeamOne >= 4 || scoreOfTeamTwo >= 4) {
            if (Math.abs(scoreOfTeamOne - scoreOfTeamTwo)  == 1)
                return "Advantage " + (scoreOfTeamOne > scoreOfTeamTwo ? teamOne : teamTwo);
            return "Win for " + (scoreOfTeamOne > scoreOfTeamTwo ? teamOne : teamTwo);
        }
        if (scoreOfTeamOne == scoreOfTeamTwo)
            return SCORE_NAMES[scoreOfTeamOne] + "-All";
        return SCORE_NAMES[scoreOfTeamOne] + "-" + SCORE_NAMES[scoreOfTeamTwo];


    }
}
