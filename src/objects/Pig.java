package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.GameObject;

public class Pig extends GameObject {
    private int health = 100;

    public Pig(double x, double y, double width, double height) {
        super(x, y, width, height);

    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public void update(double groundY) {
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setFill(Color.GREEN);
    /*    g.fillOval((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());*/

    }
}

