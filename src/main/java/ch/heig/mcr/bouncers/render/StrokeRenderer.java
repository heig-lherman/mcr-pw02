package ch.heig.mcr.bouncers.render;

import ch.heig.mcr.bouncers.shape.Bouncable;
import java.awt.*;

/**
 * Renderer that displays shapes as stroked.
 * @implNote Singleton, use {@link #getInstance()} to get the instance.
 */
public final class StrokeRenderer implements Renderer {

    private static final class InstanceHolder {

        private static final StrokeRenderer instance = new StrokeRenderer();
    }

    /**
     * @return the instance of the renderer
     */
    public static StrokeRenderer getInstance() {
        return InstanceHolder.instance;
    }

    private StrokeRenderer() {
    }

    /**
     * @inheritDoc
     */
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.setStroke(new BasicStroke(2));
        g.draw(b.getShape());
    }
}
