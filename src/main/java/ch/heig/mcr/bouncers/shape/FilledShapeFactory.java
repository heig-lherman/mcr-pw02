package ch.heig.mcr.bouncers.shape;

import ch.heig.mcr.bouncers.shape.circle.FilledCircle;
import ch.heig.mcr.bouncers.shape.square.FilledSquare;
import java.util.Random;

/**
 * Factory for creating filled shapes.
 */
public class FilledShapeFactory extends ShapeFactory {

    /**
     * @inheritDoc
     */
    @Override
    public Bouncable createSquare(Random random) {
        return new FilledSquare(random);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Bouncable createCircle(Random random) {
        return new FilledCircle(random);
    }
}
