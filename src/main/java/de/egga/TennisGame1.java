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

    static class EqualScores {
        static final String DEUCE = "Deuce";
        static final String THIRTY_ALL = "Thirty-All";
        static final String FIFTEEN_ALL = "Fifteen-All";
        static final String LOVE_ALL = "Love-All";
    }

    private static String getEqualScore(int a1) {
        String score;
        switch (a1)
        {
            case 0:
                score = EqualScores.LOVE_ALL;
                break;
            case 1:
                score = EqualScores.FIFTEEN_ALL;
                break;
            case 2:
                score = EqualScores.THIRTY_ALL;
                break;
            default:
                score = EqualScores.DEUCE;
                break;

        }
        return score;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        final int a1 = this.a;
        final int b1 = this.b;
        if (a1 == b1)
        {
            score = getEqualScore(a1);
        }
        else if (a1 >=4 || b1 >=4)
        {
            int minusResult = a1 - b1;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = a1;
                else { score+="-"; tempScore = b1;}
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
