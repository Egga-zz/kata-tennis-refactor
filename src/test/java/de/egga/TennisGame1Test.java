package de.egga;

import org.junit.Test;

public class TennisGame1Test {

    @Test(expected = IllegalArgumentException.class)
    public void game1_should_throw_exception_on_unknown_name() {
        TennisGame1 game = new TennisGame1("player1", "player2");
        game.wonPoint("some other name");
    }
}