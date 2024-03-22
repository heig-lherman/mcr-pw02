package ch.heig.mcr.bouncers.shape;

import ch.heig.mcr.bouncers.display.Displayer;
import ch.heig.mcr.bouncers.render.Renderer;
import ch.heig.mcr.bouncers.util.Vec2d;
import java.util.Random;

/**
 * Abstract drawable shape with bouncing capabilities.
 */
public abstract class AbstractShape implements Bouncable {

    private final int size;

    private Vec2d position;
    private Vec2d velocity;

    protected AbstractShape(Random random) {
        int maxWidth = Displayer.getInstance().getWidth();
        int maxHeight = Displayer.getInstance().getHeight();

        position = new Vec2d(random.nextDouble(maxWidth), random.nextDouble(maxHeight));
        velocity = new Vec2d(random.nextDouble(-1.5, 1.5), random.nextDouble(-1.5, 1.5));
        size = random.nextInt(35) + 10;
    }

    protected Vec2d getPosition() {
        return position;
    }

    protected Vec2d getVelocity() {
        return velocity;
    }

    protected int getSize() {
        return size;
    }

    /**
     * Get the renderer for the shape.
     * @return an instance of the renderer
     */
    protected abstract Renderer getRenderer();

    /**
     * @inheritDoc
     */
    @Override
    public final void draw() {
        getRenderer().display(
                Displayer.getInstance().getGraphics(),
                this
        );
    }

    /**
     * @inheritDoc
     */
    @Override
    public final void move() {
        Displayer window = Displayer.getInstance();
        position = position.add(velocity);
        if (!isWithinBounds(window)) {
            velocity = velocity.reflect(getWallNormal(window));
            position = getClampedPosition(window);
        }
    }

    protected boolean isWithinBounds(Displayer window) {
        return position.x() >= 0 && position.x() + size <= window.getWidth()
                && position.y() >= 0 && position.y() + size <= window.getHeight();
    }

    protected Vec2d getClampedPosition(Displayer window) {
        return position.clamp(
                0, 0,
                window.getWidth() - size, window.getHeight() - size
        );
    }

    protected Vec2d getWallNormal(Displayer window) {
        Vec2d normal = new Vec2d(0, 0);
        if (position.x() <= 0) {
            normal = normal.add(Vec2d.X_AXIS);
        }
        if (position.x() + size >= window.getWidth()) {
            normal = normal.add(Vec2d.X_AXIS.invert());
        }
        if (position.y() <= 0) {
            normal = normal.add(Vec2d.Y_AXIS);
        }
        if (position.y() + size >= window.getHeight()) {
            normal = normal.add(Vec2d.Y_AXIS.invert());
        }
        return normal.normalize();
    }
}
