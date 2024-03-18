package population;

import constant.CellState;

/**
 * Class which represents singular cell
 */
public class Cell {

    private CellState state;

    public Cell(CellState cellState) {
        this.state = cellState;
    }
	
	public CellState getState() {
		return this.state;
	}

    public boolean isAlive() {
        return this.state.equals(CellState.ALIVE);
    }

    public boolean isDead() {
        return this.state.equals(CellState.DEAD);
    }

    public void makeAlive() {
        this.state = CellState.ALIVE;
    }

    public void makeDead() {
        this.state = CellState.DEAD;
    }

    @Override
    public String toString() {
        return this.state.toString();
    }
}
