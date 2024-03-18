package ch.heig.mcr.bouncers.shape;

import ch.heig.mcr.bouncers.util.Vec2d;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Shape {

    public Square(Vec2d position, Vec2d velocity, int size) {
        super(position, velocity, size, size);
    }

    @Override
    protected void drawShape(Graphics2D graphics) {
        graphics.setColor(Color.ORANGE);
        graphics.fill(new Rectangle2D.Double(
                position.x(), position.y(),
                width, height
        ));
    }
}
