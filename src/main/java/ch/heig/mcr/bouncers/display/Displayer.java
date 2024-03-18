package ch.heig.mcr.bouncers.display;

import java.awt.*;

public interface Displayer {

    int getWidth();

    int getHeight();

    Graphics2D getGraphics();

    void repaint();

    void setTitle(String title);

    static Displayer getInstance() {
        return DisplayerSingleton.getInstance();
    }
}
