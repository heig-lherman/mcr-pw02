package ch.heig.mcr.bouncers.render;

import ch.heig.mcr.bouncers.shape.Bouncable;
import java.awt.*;

public final class FillRenderer implements Renderer {

    private static final class InstanceHolder {

        private static final FillRenderer instance = new FillRenderer();
    }

    public static FillRenderer getInstance() {
        return InstanceHolder.instance;
    }

    private FillRenderer() {
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
