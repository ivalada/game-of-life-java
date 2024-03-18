package rule;

import population.Cell;

import java.util.List;

/**
 * Base interface for all transition rules which are used to determine cell's state in next generation
 */
public interface TransitionRule {
	
	boolean isApplicableToCell(Cell cell);

    boolean applyToCell(Cell cell, List<Cell> neighbours);
}
