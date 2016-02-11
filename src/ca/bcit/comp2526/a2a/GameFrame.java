package ca.bcit.comp2526.a2a;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * GameFrame.
 * 
 * @author BCIT
 * @version 1.0
 */
public class GameFrame extends JFrame {
    /**
     * <p>
     * Object Unique ID.
     * </p>
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private final World world;

    public GameFrame(final World world) {
        this.world = world;
    }

    /**
     * <p>GameFrame Initialization.</p>
     */
    public void init() {
        setTitle("Assignment 2a");
        setLayout(new GridLayout(world.getRowCount(), world.getColumnCount()));

        for (int row = 0; row < world.getRowCount(); row++) {
            for (int col = 0; col < world.getColumnCount(); col++) {
                add(world.getCellAt(row, col));
            }
        }

        addMouseListener(new TurnListener(this));
    }

    /**
     * <p>Take one turn in the world.</p>
     */
    public void takeTurn() {
        world.takeTurn();
        repaint();
    }
}
