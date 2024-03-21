package ch.heig.mcr.bouncers.display;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BouncersWindow implements Displayer {

    private final JFrame frame;
    private final GraphicsPanel contentPane;

    protected BouncersWindow() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new GraphicsPanel();
        frame.setContentPane(contentPane);

        frame.pack();
        frame.setVisible(true);
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

    @Override
    public void addKeyListener(KeyListener kl) {
        frame.addKeyListener(kl);
    }

    private static class GraphicsPanel extends JPanel {

        private Image buffer;

        public GraphicsPanel() {
            setSize(800, 800);
            setPreferredSize(getSize());
            setBackground(Color.WHITE);

            resetBuffer();
            addComponentListener(new ResizeListener());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D graph = (Graphics2D) g;
            graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (buffer != null) {
                graph.drawImage(buffer, 0, 0, getWidth(), getHeight(), this);
                clear();
            }
        }

        private void clear() {
            buffer.getGraphics().clearRect(0, 0, getWidth(), getHeight());
            buffer.getGraphics().setColor(Color.WHITE);
            buffer.getGraphics().fillRect(0, 0, getWidth(), getHeight());
        }

        private void resetBuffer() {
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }

        private class ResizeListener extends ComponentAdapter {

            @Override
            public void componentResized(ComponentEvent e) {
                resetBuffer();
            }
        }
    }
}
