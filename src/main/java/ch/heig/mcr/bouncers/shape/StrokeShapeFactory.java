package ch.heig.mcr.bouncers.shape;

import ch.heig.mcr.bouncers.shape.circle.StrokedCircle;
import ch.heig.mcr.bouncers.shape.square.StrokedSquare;
import java.util.Random;

/**
 * Factory for creating stroked shapes.
 */
public class StrokeShapeFactory extends ShapeFactory {

    /**
     * @inheritDoc
     */
    @Override
    public Bouncable createSquare(Random random) {
        return new StrokedSquare(random);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Bouncable createCircle(Random random) {
        return new StrokedCircle(random);
    }
}
