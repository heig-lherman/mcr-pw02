package ch.heig.mcr.bouncers.display;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Main contract for displaying the game, an implementation should be registered under
 * {@link DisplayerSingleton} to be used by the game.
 */
public interface Displayer {

    /**
     * @return the current play area width
     */
    int getWidth();

    /**
     * @return the current play area height
     */
    int getHeight();

    /**
     * @return a {@link Graphics2D} object to draw on the play area
     */
    Graphics2D getGraphics();

    /**
     * Calls to repaint the play area, should be called after all drawing operations
     * for the current frame are completed.
     */
    void repaint();

    /**
     * Overwrites the current window title.
     * @param title the new window title
     */
    void setTitle(String title);

    /**
     * Adds a key listener to the current window.
     * @param ka the key listener to add
     */
    void addKeyListener(KeyListener ka);

    /**
     * Utility method to return the currently registered {@link Displayer} instance, if any.
     * @return the currently registered {@link Displayer} instance
     */
    static Displayer getInstance() {
        return DisplayerSingleton.getInstance();
    }
}
