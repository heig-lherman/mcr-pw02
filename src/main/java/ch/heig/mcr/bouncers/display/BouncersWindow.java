package ch.heig.mcr.bouncers.display;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * Swing/AWT implementation of the displayer contract.
 */
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

    /**
     * @inheritDoc
     */
    @Override
    public int getWidth() {
        return contentPane.getWidth();
    }

    /**
     * @inheritDoc
     */
    @Override
    public int getHeight() {
        return contentPane.getHeight();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) contentPane.buffer.getGraphics();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void repaint() {
        contentPane.repaint();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void addKeyListener(KeyListener kl) {
        frame.addKeyListener(kl);
    }

    /**
     * Main content pane for the displayer, handles drawing and resizing.
     */
    private static class GraphicsPanel extends JPanel {

        // This images serves as a buffer to handle content updates on a frame-by-frame basis.
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
