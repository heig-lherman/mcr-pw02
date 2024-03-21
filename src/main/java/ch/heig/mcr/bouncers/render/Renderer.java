package ch.heig.mcr.bouncers.render;

import ch.heig.mcr.bouncers.shape.Bouncable;
import java.awt.*;

public interface Renderer {

    void display(Graphics2D g, Bouncable b);
}
