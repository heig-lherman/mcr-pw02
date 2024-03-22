package ch.heig.mcr.bouncers.util;

/**
 * A 2D vector.
 * @param x the x component
 * @param y the y component
 */
public record Vec2d(
        double x,
        double y
) {

    public static final Vec2d X_AXIS = new Vec2d(1, 0);
    public static final Vec2d Y_AXIS = new Vec2d(0, 1);

    /**
     * @return the length of the vector
     */
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * @param other the other vector
     * @return the dot product of this vector and the other vector
     */
    public double dot(Vec2d other) {
        return x * other.x + y * other.y;
    }

    /**
     * @return the vector flipped along the diagonal
     */
    public Vec2d flip() {
        return new Vec2d(y, x);
    }

    /**
     * @return the inverted vector
     */
    public Vec2d invert() {
        return new Vec2d(-x, -y);
    }

    /**
     * @param normal the normal vector
     * @return the reflected vector against the normal
     */
    public Vec2d reflect(Vec2d normal) {
        return subtract(normal.scale(2 * dot(normal)));
    }

    /**
     * @param other the other vector
     * @return the sum of the two vectors
     */
    public Vec2d add(Vec2d other) {
        return new Vec2d(x + other.x, y + other.y);
    }

    /**
     * @param other the other vector
     * @return the difference of the two vectors
     */
    public Vec2d subtract(Vec2d other) {
        return new Vec2d(x - other.x, y - other.y);
    }

    /**
     * @param factor the scaling factor
     * @return the scaled vector
     */
    public Vec2d scale(double factor) {
        return new Vec2d(x * factor, y * factor);
    }

    /**
     * @return the normalized vector
     */
    public Vec2d normalize() {
        return scale(1 / length());
    }

    /**
     * @param minX the minimum x value
     * @param minY the minimum y value
     * @param maxX the maximum x value
     * @param maxY the maximum y value
     * @return the clamped vector
     */
    public Vec2d clamp(int minX, int minY, int maxX, int maxY) {
        return new Vec2d(
                Math.max(minX, Math.min(maxX, x)),
                Math.max(minY, Math.min(maxY, y))
        );
    }
}
