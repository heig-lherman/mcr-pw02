package ch.heig.mcr.bouncers.shape.square;

import ch.heig.mcr.bouncers.render.Renderer;
import ch.heig.mcr.bouncers.render.StrokeRenderer;
import java.awt.*;
import java.util.Random;

public class StrokedSquare extends Square {

    public StrokedSquare(Random random) {
        super(random);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    protected Renderer getRenderer() {
        return StrokeRenderer.getInstance();
    }
}
