package ch.heig.mcr.bouncers.shape.square;

import ch.heig.mcr.bouncers.shape.AbstractShape;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Abstract class for a square.
 */
abstract class Square extends AbstractShape {

    public Square(Random random) {
        super(random);
    }

    /**
     * @inheritDoc
     */
    @Override
    public final Shape getShape() {
        return new Rectangle2D.Double(getPosition().x(), getPosition().y(), getSize(), getSize());
    }
}
