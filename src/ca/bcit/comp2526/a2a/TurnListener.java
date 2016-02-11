package ca.bcit.comp2526.a2a;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <p>This class can call the takeTurn method in GameFrame.</p>
 * @ClassName: TurnListener
 * @author Jayden Liang
 * @version 1.0
 * @date Feb 8, 2016 1:23:50 AM
 *
 */
public class TurnListener extends MouseAdapter {
    
    /**
     * <p>The game frame reference.</p>
     */
    private GameFrame gameFrame;

    /**
     * <p>This is the constructor of TurnListener.</p>
     */
    public TurnListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        this.gameFrame.takeTurn();
        super.mouseClicked(event);
    }
}
