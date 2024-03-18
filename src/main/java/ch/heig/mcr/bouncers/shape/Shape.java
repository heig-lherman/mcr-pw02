package ch.heig.mcr.bouncers.shape;

import ch.heig.mcr.bouncers.BouncersWindow;
import ch.heig.mcr.bouncers.Displayer;
import ch.heig.mcr.bouncers.util.Vec2d;
import java.awt.*;

public abstract class Shape {

    protected Vec2d position;
    protected Vec2d velocity;

    protected final int width;
    protected final int height;

    protected Shape(
            Vec2d position,
            Vec2d velocity,
            int width,
            int height
    ) {
        this.position = position;
        this.velocity = velocity;
        this.width = width;
        this.height = height;
    }

    protected abstract void drawShape(Graphics2D graphics);

    public final void tick(double deltaTime) {
        Displayer window = BouncersWindow.getInstance();

        position = position.add(velocity.scale(deltaTime));
        if (!isWithinBounds(window)) {
            velocity = velocity.reflect(getWallNormal(window));
            position = getClampedPosition(window);
        }

        drawShape(window.getGraphics());
    }

    protected boolean isWithinBounds(Displayer window) {
        return position.x() >= 0 && position.x() + width <= window.getWidth()
                && position.y() >= 0 && position.y() + height <= window.getHeight();
    }

    protected Vec2d getClampedPosition(Displayer window) {
        return position.clamp(
                0, 0,
                window.getWidth() - width, window.getHeight() - height
        );
    }

    protected Vec2d getWallNormal(Displayer window) {
        Vec2d normal = new Vec2d(0, 0);
        if (position.x() <= 0) {
            normal = normal.add(Vec2d.X_AXIS);
        }
        if (position.x() + width >= window.getWidth()) {
            normal = normal.add(Vec2d.X_AXIS.invert());
        }
        if (position.y() <= 0) {
            normal = normal.add(Vec2d.Y_AXIS);
        }
        if (position.y() + height >= window.getHeight()) {
            normal = normal.add(Vec2d.Y_AXIS.invert());
        }
        return normal.normalize();
    }
}
