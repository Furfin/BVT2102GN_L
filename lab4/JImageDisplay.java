import javax.swing.JComponent;
import java.awt.image.*;
import java.awt.*;


class JImageDisplay extends JComponent {
    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }
    
    public JImageDisplay(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    public void clearImage () {
        Graphics2D g = image.createGraphics(); // получаем объект с помощью которого можно изобразить что то в BufferedImage
        g.setBackground(new Color(0, 0, 0, 0));// устанавлием цвет фона на чёрный
        g.clearRect(0, 0, image.getWidth(), image.getHeight());// очищаем картинку от всей графики
    }

    public void drawPixel (int x, int y, int rgbColor) {
        this.image.setRGB(x, y, rgbColor);
    }
}