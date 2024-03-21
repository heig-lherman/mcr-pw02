package ch.heig.mcr.bouncers.shape.square;

import ch.heig.mcr.bouncers.shape.AbstractShape;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

abstract class Square extends AbstractShape {

    public Square(Random random) {
        super(random);
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getPosition().x(), getPosition().y(), getSize(), getSize());
    }
}
