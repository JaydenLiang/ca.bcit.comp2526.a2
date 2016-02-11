package ca.bcit.comp2526.a2a;

import java.awt.Point;

import javax.swing.JPanel;

/**
 * <p>Javadoc description</p>
 * @ClassName: Thing
 * @author Jayden Liang
 * @version 1.0
 * @date Feb 9, 2016 2:11:13 PM
 *
 */
public class Thing  extends JPanel implements IThing {
    /**
     * <p>Object Unique ID.</p>
     */
    private static final long serialVersionUID = 4785172134632879906L;
    /**
     * <p>
     * The Cell the herbivore currently stays on.
     * </p>
     */
    private Cell cell;

    /**
     * <p>This is the constructor of Thing.</p>
     */
    public Thing() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * @see ca.bcit.comp2526.a2a.IThing#setCell(ca.bcit.comp2526.a2a.Cell)
     */
    @Override
    public final void setCell(Cell cell) {
        if (cell == null || cell.getThing() == this) {
            this.cell = cell;
        }
    }

    /* (non-Javadoc)
     * @see ca.bcit.comp2526.a2a.IThing#getType()
     */
    @Override
    public int getType() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see ca.bcit.comp2526.a2a.IThing#getCellLocation()
     */
    @Override
    public Point getCellLocation() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * <p>
     * Sets up the layout.
     * </p>
     */
    public void init() {

    }
    
    /**
     * <p>Get the cell this thing stays on.</p>
     * @return Cell
     */
    protected Cell getCell() {
        return cell;
    }

}
