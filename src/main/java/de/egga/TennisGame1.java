package de.egga;

public class TennisGame1 implements TennisGame {

    private static class Team{
        private final String name;
        private final int score;

        private Team(String name, int score) {
            this.name = name;
            this.score = score;
        }

        static Team addPoint(Team team){
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
                return new Game(Team.addPoint(one), two);
            else
                return new Game(one, Team.addPoint(two));
        }

        public String getScore() {

            if (isDraft() && ( one.score == 3 || one.score == 4 ))
                return "Deuce";
            if (inEndphase()) {
                if (Math.abs(one.score - two.score)  == 1)
                    return "Advantage " + (one.score > two.score ? one.name : two.name);
                return "Win for " + (one.score > two.score ? one.name : two.name);
            }
            if (isDraft())
                return SCORE_NAMES[one.score] + "-All";
            return SCORE_NAMES[one.score] + "-" + SCORE_NAMES[two.score];


        }

        private boolean isDraft() {
            return one.score == two.score;
        }

        private boolean inEndphase() {
            return one.score >= 4 || two.score >= 4;
        }


    }


    private Game game;


    public TennisGame1(String teamOne, String teamTwo) {
        game = new Game(teamOne, teamTwo);

    }

    public void wonPoint(String playerName) {
        //I hate those tests ...
        game = game.wonPoint(playerName);

    }

    public String getScore() {
        return game.getScore();

    }
}
