package ch.heig.mcr.bouncers.shape;

import ch.heig.mcr.bouncers.shape.circle.FilledCircle;
import ch.heig.mcr.bouncers.shape.square.FilledSquare;
import java.util.Random;

public class FilledShapeFactory extends ShapeFactory {

    @Override
    public Bouncable createSquare(Random random) {
        return new FilledSquare(random);
    }

    @Override
    public Bouncable createCircle(Random random) {
        return new FilledCircle(random);
    }
}
