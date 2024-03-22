package ch.heig.mcr.bouncers.shape.square;

import ch.heig.mcr.bouncers.render.Renderer;
import ch.heig.mcr.bouncers.render.StrokeRenderer;
import java.awt.*;
import java.util.Random;

/**
 * A stroked square.
 */
public class StrokedSquare extends Square {

    public StrokedSquare(Random random) {
        super(random);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Color getColor() {
        return Color.RED;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Renderer getRenderer() {
        return StrokeRenderer.getInstance();
    }
}
