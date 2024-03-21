package ch.heig.mcr.bouncers.shape;

import java.awt.*;

public interface Bouncable {

    void draw();

    void move();

    Color getColor();

    Shape getShape();
}
