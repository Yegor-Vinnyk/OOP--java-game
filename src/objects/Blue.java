package objects;

import abilityStrategy.AbilityStrategy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import levels.Level;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Blue extends Bird {
    private Image image;

    public Blue(double x, double y, double width, double height, double mass,  AbilityStrategy strategy, Level level) {
        super(x, y, width, height, mass, strategy, level);
        image = new Image(getClass().getResourceAsStream("/images/blue.png"));

    }


    @Override
    public void draw(GraphicsContext g) {
        g.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }
}
