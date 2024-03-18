package game;

import constant.GameConstants;
import population.Population;
import rule.TransitionRule;

import java.io.IOException;
import java.util.List;

/**
 * Main game class which encapsulates most of its logic
 */
public class Game {

    private final Population population;

    private final List<TransitionRule> transitionRules;

    private final long generationsNumber;

    public Game(int populationRows, int populationCols, List<TransitionRule> transitionRules, long generationsNumber, List<int[]> initSeed) {
        this.population = new Population(populationRows, populationCols, initSeed);
        this.transitionRules = transitionRules;
        this.generationsNumber = generationsNumber;
    }

    public void run() {
        long generationNumber = 1;
		render();
        initTick();
        while (generationNumber < this.generationsNumber) {
			delay();
            render();
            tick();
			generationNumber++;
        }
    }

    private void initTick() {
        this.population.produceFirstGeneration(this.transitionRules);
    }

    private void tick() {
        this.population.produceNextGeneration(this.transitionRules);
    }

    private void delay() {
        try {
            Thread.sleep(GameConstants.NEXT_GENERATION_RENDER_DELAY);
        } catch (InterruptedException ex) {
            System.out.println("Unexpected error: " + ex.getMessage());
        }
    }

    private void render() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (IOException | InterruptedException ex) {
			System.out.println("Unexpected error: " + ex.getMessage());
            return;
		}
        System.out.print(this.population);
    }

}
