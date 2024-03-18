package ch.heig.mcr.bouncers;

import ch.heig.mcr.bouncers.display.BouncersWindow;
import ch.heig.mcr.bouncers.display.Displayer;
import ch.heig.mcr.bouncers.display.DisplayerSingleton;
import ch.heig.mcr.bouncers.shape.Circle;
import ch.heig.mcr.bouncers.shape.Shape;
import ch.heig.mcr.bouncers.shape.Square;
import ch.heig.mcr.bouncers.util.Vec2d;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: java -jar bouncers.jar <nbSquares> <nbCircles>");
            System.exit(1);
        }

        var random = new Random();

        int nbSquares = Integer.parseInt(args[0]);
        int nbCircles = Integer.parseInt(args[1]);

        var window = DisplayerSingleton.registerInstance(BouncersWindow.class);
        List<Shape> shapes = new ArrayList<>(nbSquares + nbCircles);

        window.setTitle("Bouncers");

        for (int i = 0; i < nbSquares; i++) {
            shapes.add(new Square(
                    new Vec2d(random.nextDouble(window.getWidth()), random.nextDouble(window.getHeight())),
                    new Vec2d(random.nextDouble() * 45 + 5, random.nextDouble() * 45 + 5),
                    random.nextInt(35) + 15
            ));
        }

        for (int i = 0; i < nbCircles; i++) {
            shapes.add(new Circle(
                    new Vec2d(random.nextDouble(window.getWidth()), random.nextDouble(window.getHeight())),
                    new Vec2d(random.nextDouble() * 45 + 5, random.nextDouble() * 45 + 5),
                    random.nextInt(35) + 15
            ));
        }

        var executor = Executors.newSingleThreadScheduledExecutor();
        var lastTime = new AtomicLong(System.currentTimeMillis());
        executor.scheduleAtFixedRate(() -> {
            long deltaTime = System.currentTimeMillis() - lastTime.getAndSet(System.currentTimeMillis());
            for (Shape shape : shapes) {
                shape.tick(deltaTime / 1000.0);
            }

            window.repaint();
        }, 0, 40, TimeUnit.MILLISECONDS).get();
    }
}
