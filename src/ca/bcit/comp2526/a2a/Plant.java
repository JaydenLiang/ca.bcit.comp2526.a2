package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.util.ArrayList;

/**
 * <p>
 * The Plant class.
 * </p>
 * 
 * @ClassName: Plant
 * @author Jayden Liang
 * @version 1.0
 * @date Feb 8, 2016 1:08:48 AM
 */
public class Plant extends LivingThing {
    /**
     * <p>Object unique ID.</p>
     */
    private static final long serialVersionUID = -3718803573942893310L;
    /**
     * <p>Background color.</p>
     */
    private static final int GRAPHIC_BACKGROUND_COLOR = 0x00FF00;

    /**
     * <p>How many lives this living thing can lose.</p>
     */
    public static final int LIVE_NUMBER = 1;
    /**
     * <p>
     * This is the constructor of Plant.
     * </p>
     */
    public Plant() {
        super(LIVE_NUMBER);
        init();
    }

    /* (non-Javadoc)
     * @see ca.bcit.comp2526.a2a.LivingThing#init()
     */
    @Override
    public void init() {
        super.init();
        setBackground(new Color(GRAPHIC_BACKGROUND_COLOR));
    }
    
    /* (non-Javadoc)
     * @see ca.bcit.comp2526.a2a.LivingThing#move()
     */
    @Override
    public Cell move() {
        //plant cannot move.
        return null;
    }

    @Override
    public int getType() {
        return TYPE_LIVING_THING_PLANT;
    }
    
    /* (non-Javadoc)
     * @see ca.bcit.comp2526.a2a.LivingThing#reproduce(ca.bcit.comp2526.a2a.ILivingThing)
     */
    @Override
    public ArrayList<ILivingThing> reproduce(ILivingThing livingThing) {
        return null;
    }

    /* (non-Javadoc)
     * @see ca.bcit.comp2526.a2a.ILivingThing#preyOn(ca.bcit.comp2526.a2a.IThing)
     */
    @Override
    public boolean preyOn(IThing thing) {
        return false;
    }
}
