package ca.bcit.comp2526.a2a;

/**
 * <p>
 * Javadoc description
 * </p>
 * 
 * @ClassName: CreatureFactory
 * @author Jayden Liang
 * @version 1.0
 * @date Feb 8, 2016 1:19:11 PM
 */
public class CreatureFactory {

    /**
     * <p>
     * This is the constructor of CreatureFactory.
     * </p>
     */
    public CreatureFactory() {
    }

    /**
     * <p>
     * Randomly create a living thing object.
     * </p>
     * 
     * @param min minimum possibility
     * @param max maximum possibility
     * @return LivingThing
     */
    public static LivingThing createLivingThing(int min, int max) {
        LivingThing livingThing = null;
        if (max > min) {
            int seed = RandomGenerator.nextNumber(max - min);
            if (seed <= 10) {
                livingThing = new Herbivore();
            } else if (seed > 10 && seed <= 40) {
                livingThing = new Plant();
            }
        }
        return livingThing;
    }
}
