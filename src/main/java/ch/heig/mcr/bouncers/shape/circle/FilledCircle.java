package ch.heig.mcr.bouncers.shape.circle;

import ch.heig.mcr.bouncers.render.FillRenderer;
import ch.heig.mcr.bouncers.render.Renderer;
import java.awt.*;
import java.util.Random;

public class FilledCircle extends Circle {

    public FilledCircle(Random random) {
        super(random);
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    protected Renderer getRenderer() {
        return FillRenderer.getInstance();
    }
}
