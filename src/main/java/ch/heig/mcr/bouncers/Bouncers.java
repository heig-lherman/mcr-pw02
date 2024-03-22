package ch.heig.mcr.bouncers;

import ch.heig.mcr.bouncers.display.BouncersWindow;
import ch.heig.mcr.bouncers.display.Displayer;
import ch.heig.mcr.bouncers.display.DisplayerSingleton;
import ch.heig.mcr.bouncers.shape.Bouncable;
import ch.heig.mcr.bouncers.shape.FilledShapeFactory;
import ch.heig.mcr.bouncers.shape.ShapeFactory;
import ch.heig.mcr.bouncers.shape.StrokeShapeFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

/**
 * Main class for the bouncers application, registers the main displayer instance and
 * starts the main loop inside AWT's event queue.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 * @version 1.0
 * @since 2024-02-22
 */
public class Bouncers {

    private final List<Bouncable> bouncers = new LinkedList<>();
    private final Random random = new Random();

    public Bouncers() throws Exception {
        DisplayerSingleton.registerInstance(BouncersWindow.class);
        Displayer.getInstance().addKeyListener(new BouncableActions());
    }

    /**
     * Main loop for the bouncers application, moves and draws all bouncers on the screen.
     */
    public void run() {
        Displayer.getInstance().setTitle("Bouncers");
        new Timer(10, event -> {
            for (Bouncable bouncer : bouncers) {
                bouncer.move();
                bouncer.draw();
            }

            Displayer.getInstance().repaint();
        }).start();
    }

    private void createShapes(ShapeFactory factory) {
        for (int i = 0; i < 10; i++) {
            bouncers.add(factory.createCircle(random));
            bouncers.add(factory.createSquare(random));
        }
    }

    /**
     * KeyAdapter implementation for the bouncers application,
     * handles key events to create new shapes,
     * clear the screen or exit the application.
     */
    private class BouncableActions extends KeyAdapter {

        private final ShapeFactory fillFactory = new FilledShapeFactory();
        private final ShapeFactory strokeFactory = new StrokeShapeFactory();

        @Override
        public void keyTyped(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'e':
                    bouncers.clear();
                    break;
                case 'b':
                    createShapes(strokeFactory);
                    break;
                case 'f':
                    createShapes(fillFactory);
                    break;
                case 'q':
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * Main method for the bouncers application, starts the application.
     *
     * @param args command line arguments
     * @throws Exception if an error occurs
     */
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Bouncers()::run);
    }
}
