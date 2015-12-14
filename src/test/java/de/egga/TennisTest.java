package de.egga;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TennisTest {

    private static final String PLAYER1 = "player1";
    private static final String PLAYER2 = "player2";
    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }

    @Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, "Love-All" },
                { 1, 1, "Fifteen-All" },
                { 2, 2, "Thirty-All"},
                { 3, 3, "Deuce"},
                { 4, 4, "Deuce"},

                { 1, 0, "Fifteen-Love"},
                { 0, 1, "Love-Fifteen"},
                { 2, 0, "Thirty-Love"},
                { 0, 2, "Love-Thirty"},
                { 3, 0, "Forty-Love"},
                { 0, 3, "Love-Forty"},
                { 4, 0, "Win for " + PLAYER1},
                { 0, 4, "Win for " + PLAYER2},

                { 2, 1, "Thirty-Fifteen"},
                { 1, 2, "Fifteen-Thirty"},
                { 3, 1, "Forty-Fifteen"},
                { 1, 3, "Fifteen-Forty"},
                { 4, 1, "Win for " + PLAYER1},
                { 1, 4, "Win for " + PLAYER2},

                { 3, 2, "Forty-Thirty"},
                { 2, 3, "Thirty-Forty"},
                { 4, 2, "Win for " + PLAYER1},
                { 2, 4, "Win for " + PLAYER2},

                { 4, 3, "Advantage " + PLAYER1},
                { 3, 4, "Advantage " + PLAYER2},
                { 5, 4, "Advantage " + PLAYER1},
                { 4, 5, "Advantage " + PLAYER2},
                { 15, 14, "Advantage " + PLAYER1},
                { 14, 15, "Advantage " + PLAYER2},

                { 6, 4, "Win for " + PLAYER1},
                { 4, 6, "Win for " + PLAYER2},
                { 16, 14, "Win for " + PLAYER1},
                { 14, 16, "Win for " + PLAYER2},
        });
    }

    public void checkAllScores(TennisGame game) {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.wonPoint(PLAYER1);
            if (i < this.player2Score)
                game.wonPoint(PLAYER2);
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkAllScoresTennisGame1() {
        TennisGame1 game = new TennisGame1(PLAYER1, PLAYER2);
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame2() {
        TennisGame2 game = new TennisGame2(PLAYER1, PLAYER2);
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame3() {
        TennisGame3 game = new TennisGame3(PLAYER1, PLAYER2);
        checkAllScores(game);
    }

}