package ch.heig.mcr.bouncers.shape;

import java.util.Random;

/**
 * Abstract factory for creating shapes.
 */
public abstract class ShapeFactory {

    /**
     * Create a square.
     *
     * @param random the random generator
     * @return the square
     */
    public abstract Bouncable createSquare(Random random);

    /**
     * Create a circle.
     *
     * @param random the random generator
     * @return the circle
     */
    public abstract Bouncable createCircle(Random random);
}
