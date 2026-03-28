package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;




public class Blue extends Bird {
    private Image image;
    private boolean splited;

    public Blue(double x, double y, double width, double height, double mass) {
        super(x, y, width, height, mass);
        image = new Image(getClass().getResourceAsStream("/images/blue.png"));

    }

    @Override
    public void draw(GraphicsContext g) {
        g.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }



}

