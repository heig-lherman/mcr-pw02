package ch.heig.mcr.bouncers;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

public class BouncersWindow implements Displayer {

    private static final class InstanceHolder {
        private static final BouncersWindow INSTANCE = new BouncersWindow();
    }

    public static BouncersWindow getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private final JFrame frame;
    private final GraphicsPanel contentPane;

    private BouncersWindow() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setPreferredSize(frame.getSize());
        frame.setVisible(true);

        contentPane = new GraphicsPanel();
        frame.setContentPane(contentPane);
    }

    @Override
    public int getWidth() {
        return contentPane.getWidth();
    }

    @Override
    public int getHeight() {
        return contentPane.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) contentPane.buffer.getGraphics();
    }

    @Override
    public void repaint() {
        contentPane.repaint();
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    private static class GraphicsPanel extends JPanel {

        private Image buffer;

        public GraphicsPanel() {
            setSize(800, 800);
            setPreferredSize(getSize());
            addComponentListener(new ResizeListener());
            clearBuffer();
        }

        @Override
        public void repaint() {
            super.repaint();
            clearBuffer();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (buffer != null) {
                g.drawImage(buffer, 0, 0, getWidth(), getHeight(), this);
            }
        }

        private void clearBuffer() {
            buffer = createImage(getWidth(), getHeight());
        }

        private class ResizeListener extends ComponentAdapter {

            @Override
            public void componentResized(ComponentEvent e) {
                clearBuffer();
            }
        }
    }
}
