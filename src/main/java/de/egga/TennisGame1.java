package de.egga;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String firstTeamName;
    private final String secondTeamName;

    private final String[] SCORE_NAMES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};


    public TennisGame1(String firstTeamName, String secondTeamName) {
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
    }

    public void wonPoint(String playerName) {
        if (firstTeamName.equals(playerName))
            m_score1++;
        else
            m_score2++;
    }

    public String getScore() {

        if (m_score1 == 3 && m_score2 == 3 || m_score1 == 4 && m_score2 == 4)
            return "Deuce";
        if (m_score1 >= 4 || m_score2 >= 4) {
            if (Math.abs(m_score1 - m_score2)  == 1)
                return "Advantage " + (m_score1 > m_score2 ? firstTeamName : secondTeamName);
            return "Win for " + (m_score1 > m_score2 ? firstTeamName : secondTeamName);
        }
        if (m_score1 == m_score2)
            return SCORE_NAMES[m_score1] + "-All";
        return SCORE_NAMES[m_score1] + "-" + SCORE_NAMES[m_score2];


    }
}
