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

        private static String get(int value) {
            switch (value) {
                case 0:
                    return LOVE_ALL;
                case 1:
                    return FIFTEEN_ALL;
                case 2:
                    return THIRTY_ALL;
                default:
                    return DEUCE;
            }
        }
    }

    private static String getWinningScore(int a1, int b1) {
        String score;
        int minusResult = a1 - b1;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    public String getScore() {
        String score = "";

        final int a1 = this.a;
        final int b1 = this.b;

        if (a1 == b1)
        {
            score = EqualScores.get(a1);
        }
        else if (a1 >=4 || b1 >=4)
        {
            score = getWinningScore(a1, b1);
        }
        else
        {
            int tempScore;
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
