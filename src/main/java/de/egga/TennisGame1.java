package de.egga;

public class TennisGame1 implements TennisGame {

    private int a = 0;
    private int b = 0;

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            a += 1;
        } else {
            b += 1;
        }
    }

    static class Scores {
        static final String DEUCE = "Deuce";
        static final String THIRTY_ALL = "Thirty-All";
        static final String FIFTEEN_ALL = "Fifteen-All";
        static final String LOVE_ALL = "Love-All";
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (a == b)
        {
            switch (a)
            {
                case 0:
                    score = Scores.LOVE_ALL;
                    break;
                case 1:
                    score = Scores.FIFTEEN_ALL;
                    break;
                case 2:
                    score = Scores.THIRTY_ALL;
                    break;
                default:
                    score = Scores.DEUCE;
                    break;

            }
        }
        else if (a >=4 || b >=4)
        {
            int minusResult = a - b;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = a;
                else { score+="-"; tempScore = b;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
