package ch.heig.mcr.bouncers.shape;

import java.awt.*;

/**
 * Interface for shapes that can be displayed and moved.
 */
public interface Bouncable {

    /**
     * Display the shape.
     */
    void draw();

    /**
     * Move the shape.
     */
    void move();

    /**
     * @return the color of the shape
     */
    Color getColor();

    /**
     * @return the shape
     */
    Shape getShape();
}
