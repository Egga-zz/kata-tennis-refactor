package de.egga;

import java.util.ArrayList;
import java.util.List;

public class TennisGame1 implements TennisGame {

    private static class Team {
        private final String name;
        private final int score;

        private Team(String name, int score) {
            this.name = name;
            this.score = score;
        }

        static Team addPoint(Team team) {
            return new Team(team.name, team.score + 1);
        }
    }

    private class GamePart {
        private final Team home;
        private final Team guest;

        public GamePart(String nameOfTeamOne, String nameOfTeamTwo) {
            home = new Team(nameOfTeamOne, 0);
            guest = new Team(nameOfTeamTwo, 0);
        }

        private GamePart(Team home, Team guest) {
            this.home = home;
            this.guest = guest;
        }


        private final String[] SCORE_NAMES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};


        public GamePart wonPoint(String playerName) {

            if (home.name.equals(playerName))
                return new GamePart(Team.addPoint(home), guest);
            else
                return new GamePart(home, Team.addPoint(guest));
        }

        public String getScore() {
            if (inEndphase()) {
                if (isDraft())
                    return "Deuce";
                String inFavourOf = home.score > guest.score ? home.name : guest.name;
                if (Math.abs(home.score - guest.score) == 1)
                    return "Advantage " + inFavourOf;
                return "Win for " + inFavourOf;
            }
            if (isDraft())
                return SCORE_NAMES[home.score] + "-All";
            return SCORE_NAMES[home.score] + "-" + SCORE_NAMES[guest.score];


        }

        private boolean isDraft() {
            return home.score == guest.score;
        }

        private boolean inEndphase() {
            return home.score >= 4 || guest.score >= 4 || (home.score & guest.score) == 3;
        }
    }



    private List<GamePart> rounds = new ArrayList<>();


    public TennisGame1(String teamOne, String teamTwo) {
        rounds.add(new GamePart(teamOne, teamTwo));
    }

    public void wonPoint(String playerName) {
        rounds.add(getTail().wonPoint(playerName));
    }

    private GamePart getTail() {
        return rounds.get(rounds.size() - 1);
    }

    public String getScore() {
        //rounds.stream().forEach(s -> System.out.println(s.getScore()));
        return getTail().getScore();
    }
}
