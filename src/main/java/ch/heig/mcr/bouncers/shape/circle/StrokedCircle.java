package ch.heig.mcr.bouncers.shape.circle;

import ch.heig.mcr.bouncers.render.Renderer;
import ch.heig.mcr.bouncers.render.StrokeRenderer;
import java.awt.*;
import java.util.Random;

public class StrokedCircle extends Circle {

    public StrokedCircle(Random random) {
        super(random);
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    protected Renderer getRenderer() {
        return StrokeRenderer.getInstance();
    }
}
