package ch.heig.mcr.bouncers.render;

import ch.heig.mcr.bouncers.shape.Bouncable;
import java.awt.*;

/**
 * Interface for rendering shapes, instances should be registered as singletons.
 */
public interface Renderer {

    /**
     * Display the shape.
     *
     * @param g the graphics context
     * @param b the shape to display
     */
    void display(Graphics2D g, Bouncable b);
}
