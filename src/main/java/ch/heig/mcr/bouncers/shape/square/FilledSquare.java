package ch.heig.mcr.bouncers.shape.square;

import ch.heig.mcr.bouncers.render.FillRenderer;
import ch.heig.mcr.bouncers.render.Renderer;
import java.awt.*;
import java.util.Random;

public class FilledSquare extends Square {

    public FilledSquare(Random random) {
        super(random);
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    protected Renderer getRenderer() {
        return FillRenderer.getInstance();
    }
}
