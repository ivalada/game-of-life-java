package rule;

import population.Cell;

import java.util.List;

/**
 * Transition rule 3
 * Any dead cell with exactly three live neighbors becomes a live cell
 */
public class TransitionRuleThree implements TransitionRule {

	@Override
	public boolean isApplicableToCell(Cell cell) {
		return cell.isDead();
	}

    @Override
    public boolean applyToCell(Cell cell, List<Cell> neighbours) {
        if ( !isCellShouldBecomeAlive(neighbours) )
            return false;
		
		cell.makeAlive();
		
		return true;
    }

    private boolean isCellShouldBecomeAlive(List<Cell> neighbours) {
        return neighbours.stream().filter(Cell::isAlive).count() == 3;
    }
}
