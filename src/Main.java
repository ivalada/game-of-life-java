import constant.Figure;
import constant.GameConstants;
import game.Game;

public class Main {
    public static void main(String[] args) {
        Figure initSeed = Figure.PULSAR;        // set initial pattern for the game

        long generationsNumber = 100000;        // set max number of generations

        Game game = new Game(
                GameConstants.GRID_ROWS,        // number of rows on a game grid
                GameConstants.GRID_COLUMNS,     // number of columns on a game grid
                GameConstants.GAME_RULES,       // collection of transition rules for the game
                generationsNumber,              // max number of generations
                initSeed.cellPositions()        // initial pattern
        );
        game.run();                             // start the game
    }
}