package ch.heig.mcr.bouncers.render;

import ch.heig.mcr.bouncers.shape.Bouncable;
import java.awt.*;

/**
 * Renderer that displays shapes as filled.
 *
 * @implNote Singleton, use {@link #getInstance()} to get the instance.
 */
public final class FillRenderer implements Renderer {

    private static final class InstanceHolder {

        private static final FillRenderer instance = new FillRenderer();
    }

    /**
     * @return the instance of the renderer
     */
    public static FillRenderer getInstance() {
        return InstanceHolder.instance;
    }

    private FillRenderer() {
    }

    /**
     * @inheritDoc
     */
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
