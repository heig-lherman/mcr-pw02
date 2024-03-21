package ch.heig.mcr.bouncers.shape;

import java.util.Random;

public abstract class ShapeFactory {

    public abstract Bouncable createSquare(Random random);

    public abstract Bouncable createCircle(Random random);
}
