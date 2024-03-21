package ch.heig.mcr.bouncers.display;

import java.awt.*;
import java.awt.event.KeyListener;

public interface Displayer {

    int getWidth();

    int getHeight();

    Graphics2D getGraphics();

    void repaint();

    void setTitle(String title);

    void addKeyListener(KeyListener ka);

    static Displayer getInstance() {
        return DisplayerSingleton.getInstance();
    }
}
