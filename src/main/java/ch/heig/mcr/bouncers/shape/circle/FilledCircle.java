package ch.heig.mcr.bouncers.shape.circle;

import ch.heig.mcr.bouncers.render.FillRenderer;
import ch.heig.mcr.bouncers.render.Renderer;
import java.awt.*;
import java.util.Random;

/**
 * A filled circle.
 */
public class FilledCircle extends Circle {

    public FilledCircle(Random random) {
        super(random);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Renderer getRenderer() {
        return FillRenderer.getInstance();
    }
}
