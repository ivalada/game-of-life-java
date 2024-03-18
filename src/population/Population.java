package population;

import constant.CellState;
import rule.TransitionRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents the population of cells
 */
public class Population {

    private final int rowsNumber;
    private final int colsNumber;
    private Cell[][] currentGeneration;

    public Population(int rows, int cols) {
        this.rowsNumber = rows;
        this.colsNumber = cols;
        this.currentGeneration = new Cell[rows][cols];
        fillCells();
    }

    public Population(int rows, int cols, List<int[]> aliveCellsPosition) {
        this(rows, cols);
        setAliveCells(aliveCellsPosition);
    }

    public List<Cell> getAllNeighboursForCell(int row, int col) {
        List<Cell> neighbours = new ArrayList<>(8);
        if (row - 1 >= 0)
            neighbours.add(this.currentGeneration[row - 1][col]);

        if (row + 1 < this.rowsNumber)
            neighbours.add(this.currentGeneration[row + 1][col]);

        if (col - 1 >= 0)
            neighbours.add(this.currentGeneration[row][col - 1]);

        if (col + 1 < this.colsNumber)
            neighbours.add(this.currentGeneration[row][col + 1]);

        if ( (row - 1 >= 0) && (col - 1 >= 0) )
            neighbours.add(this.currentGeneration[row - 1][col - 1]);

        if ( (row + 1 < this.rowsNumber) && (col - 1 >= 0) )
            neighbours.add(this.currentGeneration[row + 1][col - 1]);

        if ( (row - 1 >= 0) && (col + 1 <  this.colsNumber) )
            neighbours.add(this.currentGeneration[row - 1][col + 1]);

        if ( (row + 1 < this.rowsNumber) && (col + 1 <  this.colsNumber) )
            neighbours.add(this.currentGeneration[row + 1][col + 1]);

        return neighbours;
    }
	
	public void produceFirstGeneration(List<TransitionRule> rules) {
		Cell[][] nextGeneration = new Cell[this.rowsNumber][this.colsNumber];
        for (int i = 0; i < this.rowsNumber; i++) {
            for (int j = 0; j < this.colsNumber; j++) {
                Cell cell = new Cell(this.currentGeneration[i][j].getState());
                List<Cell> neighbours = getAllNeighboursForCell(i, j);
                for (TransitionRule rule : rules) {
                    if (!rule.isApplicableToCell(this.currentGeneration[i][j]))
                        continue;
                    if ( rule.applyToCell(cell, neighbours) || nextGeneration[i][j] == null )
                        nextGeneration[i][j] = cell;
                }
            }
        }
		this.currentGeneration = nextGeneration;
    }

    public void produceNextGeneration(List<TransitionRule> rules) {
        Cell[][] nextGeneration = new Cell[this.rowsNumber][this.colsNumber];
		for (TransitionRule rule : rules) {
            for (int i = 0; i < this.rowsNumber; i++) {
                for (int j = 0; j < this.colsNumber; j++) {
					if (!rule.isApplicableToCell(this.currentGeneration[i][j]))
						continue;
                    Cell cell = new Cell(this.currentGeneration[i][j].getState());
                    List<Cell> neighbours = getAllNeighboursForCell(i, j);
                    if ( rule.applyToCell(cell, neighbours) || nextGeneration[i][j] == null )
                        nextGeneration[i][j] = cell;
                }
            }
        }
		this.currentGeneration = nextGeneration;
    }

    private void fillCells() {
        for (int i = 0; i < this.rowsNumber; i++) {
            for (int j = 0; j < this.colsNumber; j++) {
                this.currentGeneration[i][j] = new Cell(CellState.DEAD);
            }
        }
    }

    private void setAliveCells(List<int[]> aliveCellsPosition) {
        for (int[] aliveCellPosition : aliveCellsPosition) {
            this.currentGeneration[aliveCellPosition[0]][aliveCellPosition[1]].makeAlive();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.rowsNumber; i++) {
            for (int j = 0; j < this.colsNumber; j++) {
                stringBuilder.append(this.currentGeneration[i][j].toString());
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
