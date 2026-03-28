package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.GameObject;
import javafx.scene.image.Image;

public class Pig extends GameObject {
    private double health = 100;
    private Image image;


    public Pig(double x, double y, double width, double height, double mass) {
        super(x, y, width, height, mass);
        image = new Image(getClass().getResourceAsStream("/images/pig.png"));
    }

    public void takeDamage(double damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return this.health <= 0;
    }


    @Override
    public void draw(GraphicsContext g) {
           g.drawImage(image, getX(),getY(), getWidth(), getHeight());

    }
}

