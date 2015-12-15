package de.egga;

import java.util.HashMap;

public class TennisGame1 implements TennisGame {


    private String player1Name;
    private String player2Name;
    private ScoredPoints m_score = new ScoredPoints();

    private HashMap scoreNames = new HashMap<Integer, String>();

    private class ScoredPoints{
        private int m_score1;
        private int m_score2;
        public void ScoredPoints(){
            m_score1 = 0;
            m_score2 = 0;
        }

        void add(int playerNumber, int result){
            if(playerNumber == 1) m_score1 += result;
            else  m_score2 += result;
        }

        int get(int playerNumber){
            if(playerNumber == 1) return m_score1;
            else return m_score2;
        }

        int getDifference()
        {
            return m_score1 - m_score2;
        }

        boolean isEqual()
        {
            return getDifference() == 0;
        }

        boolean isPlayer1Better(){
            return getDifference() > 0;
        }

    }


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        scoreNames.put(0, "Love");
        scoreNames.put(1, "Fifteen");
        scoreNames.put(2, "Thirty");
        scoreNames.put(3, "Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            m_score.add(1,1);
        else
            m_score.add(2,1);
    }

    public String getScore() {
        String score;
        if (m_score.isEqual())
        {
            int equalScore = m_score.get(1);
            if(equalScore > 2) score = "Deuce";
            else score = scoreNames.get(equalScore) + "-All";
        }
        else if (m_score.get(1)>=4 || m_score.get(2)>=4)
        {
            int minusResult = m_score.getDifference();

            if(java.lang.Math.abs(minusResult) > 1){
                if(m_score.isPlayer1Better()) score = "Win for " + player1Name;
                else score ="Win for " + player2Name;
            }
            else{
                if(m_score.isPlayer1Better()) score ="Advantage " + player1Name;
                else score ="Advantage " + player2Name;
            }
        }
        else
        {
            score = scoreNames.get(m_score.get(1)) + "-" + scoreNames.get(m_score.get(2));
        }
        return score;
    }
}
