package de.egga;

public class TennisGame1 implements TennisGame {

    private static class Team{
        private final String name;
        private final int score;

        private Team(String name, int score) {
            this.name = name;
            this.score = score;
        }

        static Team addScore(Team team){
            return new Team(team.name, team.score + 1);
        }


    }

    private class Game{
        private final Team one;
        private final Team two;

        public Game(String nameOfTeamOne, String nameOfTeamTwo) {
            one = new Team(nameOfTeamOne, 0);
            two = new Team(nameOfTeamTwo, 0);
        }

        private Game(Team one, Team two) {
            this.one = one;
            this.two = two;
        }
        

        private final String[] SCORE_NAMES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};


        public Game wonPoint(String playerName) {

            if (one.name.equals(playerName))
                return new Game(Team.addScore(one), two);
            else
                return new Game(one, Team.addScore(two));
        }

        public String getScore() {

            if (one.score == 3 && two.score == 3 || one.score == 4 && two.score == 4)
                return "Deuce";
            if (one.score >= 4 || two.score >= 4) {
                if (Math.abs(one.score - two.score)  == 1)
                    return "Advantage " + (one.score > two.score ? one.name : two.name);
                return "Win for " + (one.score > two.score ? one.name : two.name);
            }
            if (one.score == two.score)
                return SCORE_NAMES[one.score] + "-All";
            return SCORE_NAMES[one.score] + "-" + SCORE_NAMES[two.score];


        }


    }

    private Game game;


    public TennisGame1(String teamOne, String teamTwo) {
        game = new Game(teamOne, teamTwo);

    }

    public void wonPoint(String playerName) {
        game = game.wonPoint(playerName);

    }

    public String getScore() {
        return game.getScore();

    }
}
