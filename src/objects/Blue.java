package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Blue extends Bird {
    private Image image;

    public Blue(double x, double y, double width, double height, double mass) {
        super(x, y, width, height, mass);
        image = new Image(getClass().getResourceAsStream("/images/blue.png"));

    }

    @Override
    public void useAbility() {
        // Only allow splitting if launched and hasn't split yet
        if (getIsLaunched() && !getAbilityUse()) {
            abilityUsed = true;

            // Create two new birds: one aimed higher, one aimed lower

            // Add to the list that the Level class will check

        }
    }


    @Override
    public void draw(GraphicsContext g) {
        g.drawImage(image, getX(), getY(), getWidth(), getHeight());
    }
}
