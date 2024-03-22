package ch.heig.mcr.bouncers.shape.circle;

import ch.heig.mcr.bouncers.shape.AbstractShape;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Abstract class for a circle.
 */
abstract class Circle extends AbstractShape {

    public Circle(Random random) {
        super(random);
    }

    /**
     * @inheritDoc
     */
    @Override
    public final Shape getShape() {
        return new Ellipse2D.Double(getPosition().x(), getPosition().y(), getSize(), getSize());
    }
}
