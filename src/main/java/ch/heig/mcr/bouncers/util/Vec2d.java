package ch.heig.mcr.bouncers.util;

import java.awt.*;

public record Vec2d(
        double x,
        double y
) {

    public static final Vec2d X_AXIS = new Vec2d(1, 0);
    public static final Vec2d Y_AXIS = new Vec2d(0, 1);

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public double dot(Vec2d other) {
        return x * other.x + y * other.y;
    }

    public Vec2d flip() {
        return new Vec2d(y, x);
    }

    public Vec2d invert() {
        return new Vec2d(-x, -y);
    }

    public Vec2d reflect(Vec2d normal) {
        return subtract(normal.scale(2 * dot(normal)));
    }

    public Vec2d add(Vec2d other) {
        return new Vec2d(x + other.x, y + other.y);
    }

    public Vec2d subtract(Vec2d other) {
        return new Vec2d(x - other.x, y - other.y);
    }

    public Vec2d scale(double factor) {
        return new Vec2d(x * factor, y * factor);
    }

    public Vec2d normalize() {
        return scale(1 / length());
    }

    public Vec2d clamp(int minX, int minY, int maxX, int maxY) {
        return new Vec2d(
                Math.max(minX, Math.min(maxX, x)),
                Math.max(minY, Math.min(maxY, y))
        );
    }
}
