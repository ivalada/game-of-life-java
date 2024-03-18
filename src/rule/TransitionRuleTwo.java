package rule;

import population.Cell;

import java.util.List;

/**
 * Transition rule 2
 * Any live cell with more than three live neighbors dies
 */
public class TransitionRuleTwo implements TransitionRule {

	@Override
	public boolean isApplicableToCell(Cell cell) {
		return cell.isAlive();
	}

    @Override
    public boolean applyToCell(Cell cell, List<Cell> neighbours) {
        if ( !isCellShouldDie(neighbours) )
            return false;
		
		cell.makeDead();
		
		return true;
    }

    private boolean isCellShouldDie(List<Cell> neighbours) {
        return neighbours.stream().filter(Cell::isAlive).count() > 3;
    }
}
