import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FractalExplorer {
    private int size;
    private JImageDisplay image;
    private Rectangle2D.Double range;
    private Mandelbrot fractal;

    public static void main(String[] args) {
        FractalExplorer fractal = new FractalExplorer(800);
        fractal.createAndShowGUI();
        fractal.drawFractal();
    }

    public FractalExplorer(int size) {
        this.size = size;
        this.image = new JImageDisplay(size, size);
        this.range = new Rectangle2D.Double();
        this.fractal = new Mandelbrot();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal Generator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(this.size, this.size);

        frame.getContentPane().add(BorderLayout.CENTER, this.image);
        image.addMouseListener(new mouseClickListener());
        JButton resetButton = new JButton("Reset Display");
        resetButton.setPreferredSize(new Dimension(150, 30));
        resetButton.addActionListener(new resetButtonListener());
        frame.getContentPane().add(BorderLayout.SOUTH, resetButton);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal() {
        this.image.clearImage();
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, size, x);
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, size, y);
                int iterations = fractal.numIterations(xCoord, yCoord);
                int rgbColor;
                if (iterations != -1) {
                    float hue = 0.7f + (float) iterations / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                } else {
                    rgbColor = Color.HSBtoRGB(0, 0, 0);
                }
                image.drawPixel(x, y, rgbColor);
            }
        }
        image.repaint();
    }

    private class resetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            fractal.getInitialRange(range);
            FractalExplorer.this.drawFractal();
        }
    }

    private class mouseClickListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, image.getWidth(), x);
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, image.getHeight(), y);

            if (e.getButton() == MouseEvent.BUTTON1) {
                fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                fractal.recenterAndZoomRange(range, xCoord, yCoord, 1.5);
            }
            FractalExplorer.this.drawFractal();
        }
        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }
    }
}
