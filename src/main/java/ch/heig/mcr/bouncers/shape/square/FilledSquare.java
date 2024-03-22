package ch.heig.mcr.bouncers.shape.square;

import ch.heig.mcr.bouncers.render.FillRenderer;
import ch.heig.mcr.bouncers.render.Renderer;
import java.awt.*;
import java.util.Random;

/**
 * A filled square.
 */
public class FilledSquare extends Square {

    public FilledSquare(Random random) {
        super(random);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Renderer getRenderer() {
        return FillRenderer.getInstance();
    }
}
