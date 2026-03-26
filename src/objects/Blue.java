package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Blue extends Bird {
    private Image image;

    public Blue(double x, double y, double width, double height, double mass) {
        super(x, y, width, height, mass);
        image = new Image(getClass().getResourceAsStream("/images/blue.png"));


    }

    @Override
    public void draw(GraphicsContext g) {
        g.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }
}
