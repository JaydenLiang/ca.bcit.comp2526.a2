package ca.bcit.comp2526.a2a;

import java.awt.Dimension;
import java.util.ArrayList;

/**
 * <p>
 * Javadoc description
 * </p>
 * 
 * @ClassName: World
 * @author Jayden Liang
 * @version 1.0
 * @date Feb 7, 2016 11:38:45 PM
 */
public class World {
    /**
     * <p>
     * Row count of cells on this world.
     * </p>
     */
    private int rowCount;
    /**
     * <p>
     * Column count of cells on this world.
     * </p>
     */
    private int columnCount;
    /**
     * <p>
     * The list of all cells on this world.
     * </p>
     */
    private Cell[][] cells;
    /**
     * <p>
     * The array to store all cells been modified.
     * </p>
     */
    private ArrayList<Cell> affectedCells;

    /**
     * <p>
     * This is the constructor of World.
     * </p>
     * 
     * @param row Cells per row.
     * @param column Cells per column.
     */
    public World(int row, int column) {
        this.rowCount = row;
        this.columnCount = column;
        cells = new Cell[row][column];
        affectedCells = new ArrayList<Cell>();
    }

    /**
     * <p>
     * Get row count.
     * </p>
     * 
     * @return int row count
     */
    public int getRowCount() {
        return rowCount;
    }

    /**
     * <p>
     * Get column count.
     * </p>
     * 
     * @return int column count.
     */
    public int getColumnCount() {
        return columnCount;
    }

    /**
     * <p>
     * Initializes the world class.
     * </p>
     */
    public void init() {
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                this.cells[i][j] = new Cell(this, i, j);
                LivingThing livingThing =
                        CreatureFactory.createLivingThing(0, 100);
                if (livingThing != null) {
                    this.cells[i][j].setThing(livingThing);
                }
            }
        }
    }

    /**
     * <p>
     * Set a new size to the world and its cells.
     * </p>
     * 
     * @param width the new width
     * @param height the new height
     */
    public void setSize(int width, int height) {
        int cellWidth = width / columnCount;
        int cellHeight = height / rowCount;
        Dimension dimension = new Dimension(cellWidth, cellHeight);
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                this.cells[i][j].setSize(dimension);
            }
        }
    }

    /**
     * <p>
     * Retrieves the requested Cell from the speci ed location in the World.
     * </p>
     * 
     * @param row row number.
     * @param column column number.
     * @return a cell object
     * @throws IndexOutOfBoundsException Cell
     */
    public Cell getCellAt(int row, int column)
            throws IndexOutOfBoundsException {
        if (row < 0 || row >= this.rowCount || column < 0
                || column >= this.columnCount) {
            throw new IndexOutOfBoundsException();
        }
        return cells[row][column];
    }

    /**
     * <p>
     * Moves Herbivores one Cell.
     * </p>
     */
    public void takeTurn() {
        IThing thing;
        Cell cell;
        int index;
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                cell = this.cells[i][j];
                // when this cell is affected by other living thing. skip this.
                if (cell.isAffected()) {
                    continue;
                }
                thing = cell.getThing();
                if (thing != null && (thing instanceof LivingThing)) {
                    cell = ((ILivingThing) thing).move();
                    if (cell != null) {
                        affectedCells.add(cell);
                        cell.setAffected(true);
                    }
                }
            }
        }
        while ((index = affectedCells.size() - 1) >= 0) {
            cell = affectedCells.remove(index);
            cell.setAffected(false);
        }
        spawnLivingThings();
    }

    /**
     * <p>
     * Add more living things to the world.
     * </p>
     */
    private void spawnLivingThings() {
        ArrayList<LivingThing> lives = new ArrayList<LivingThing>();
        lives.add(CreatureFactory.createLivingThing(0, 99));
        lives.add(CreatureFactory.createLivingThing(0, 99));
        Cell cell;
        int index;
        int row = 0;
        int col = 0;
        while ((index = lives.size() - 1) >= 0) {
            while (true) {
                row = RandomGenerator.nextNumber(rowCount);
                col = RandomGenerator.nextNumber(columnCount);
                cell = getCellAt(row, col);
                if (cell.getThing() == null) {
                    cell.setThing(lives.remove(index));
                    break;
                }
            }
        }
    }
    
    /**
     * <p>
     * Returns the adjacent Cells { corners only return 3 Cells, sides only
     * return 5, and all others return 8.
     * </p>
     * 
     * @return Point[] return a list of Cells
     */
    public ArrayList<Cell> getNeighbors(int row, int column){
        ArrayList<Cell> adjacent = new ArrayList<Cell>();
        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;
        // the cell on the top
        if (row > 0) {
            top = true;
            adjacent.add(getCellAt(row - 1, column));
        }
        // the cell on the bottom
        if (row < getRowCount() - 1) {
            bottom = true;
            adjacent.add(getCellAt(row + 1, column));
        }
        // the cell on the left
        if (column > 0) {
            left = true;
            adjacent.add(getCellAt(row, column - 1));
        }
        // the cell on the right
        if (column < getColumnCount() - 1) {
            right = true;
            adjacent.add(getCellAt(row, column + 1));
        }
        // the cell on the top left
        if (top && left) {
            adjacent.add(getCellAt(row - 1, column - 1));
        }
        // the cell on the top right
        if (top && right) {
            adjacent.add(getCellAt(row - 1, column + 1));
        }
        // the cell on the bottom left
        if (bottom && left) {
            adjacent.add(getCellAt(row + 1, column - 1));
        }
        // the cell on the bottom right
        if (bottom && right) {
            adjacent.add(getCellAt(row + 1, column + 1));
        }
        return adjacent;
    }
}
