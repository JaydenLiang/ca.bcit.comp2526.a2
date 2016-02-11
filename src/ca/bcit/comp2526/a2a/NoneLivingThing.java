package ca.bcit.comp2526.a2a;

import java.awt.Point;

/**
 * <p>Javadoc description</p>
 * @ClassName: NoneLivingThing
 * @author Jayden Liang
 * @version 1.0
 * @date Feb 9, 2016 2:04:35 PM
 *
 */
public class NoneLivingThing extends Thing {
    /**
     * <p>Object Unique ID.</p>
     */
    private static final long serialVersionUID = -969824783624742157L;

    /**
     * <p>This is the constructor of NoneLivingThing.</p>
     */
    public NoneLivingThing() {
        // TODO Auto-generated constructor stub
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

}
