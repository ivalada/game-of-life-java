package rule;

import population.Cell;

import java.util.List;

/**
 * Transition rule 1
 * Any live cell with fewer than two live neighbors dies
 */
public class TransitionRuleOne implements TransitionRule {

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
        return neighbours.stream().filter(Cell::isAlive).count() < 2;
    }
}
