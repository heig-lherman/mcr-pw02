package ch.heig.mcr.bouncers.shape;

import ch.heig.mcr.bouncers.util.Vec2d;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {

    public Circle(Vec2d position, Vec2d velocity, int diameter) {
        super(position, velocity, diameter, diameter);
    }

    @Override
    protected void drawShape(Graphics2D graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fill(new Ellipse2D.Double(
                position.x(), position.y(),
                width, height
        ));
    }
}
