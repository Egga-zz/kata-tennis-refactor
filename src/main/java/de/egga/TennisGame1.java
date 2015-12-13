package de.egga;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    private final String[] SCORE_NAMES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {

        if (m_score1 == 3 && m_score2 == 3 || m_score1 == 4 && m_score2 == 4)
            return "Deuce";
        if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            if (Math.abs(minusResult)  == 1)
                return "Advantage " + (m_score1 > m_score2 ? player1Name : player2Name);
            return "Win for " + (m_score1 > m_score2 ? player1Name : player2Name);
        }
        if (m_score1 == m_score2)
            return SCORE_NAMES[m_score1] + "-All";
        return SCORE_NAMES[m_score1] + "-" + SCORE_NAMES[m_score2];


    }
}
