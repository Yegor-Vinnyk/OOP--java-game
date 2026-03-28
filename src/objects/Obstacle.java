package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.GameObject;


public class Obstacle extends GameObject {

    private double health;
    private String type;

    public Obstacle(double x, double y, double width, double height, String type, double mass) {
        super(x, y, width, height, mass);

        this.type = type;
        switch (type) {
            case "Glass":
                this.health = 30;
                break;
            case "Wood":
                this.health = 50 ;
                break;
            case "Stone":
                this.health = 100;
                break;
        }
    }

    public String getType() {
        return this.type;
    }

    public void takeDamage(double damage) {
        this.health -= damage;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public void draw(GraphicsContext g) {
        switch (getType()) {
            case "Glass":
                g.setFill(Color.LIGHTBLUE);
                break;
            case "Wood":
                g.setFill(Color.BROWN);
                break;
            case "Stone":
                g.setFill(Color.GREY);
                break;
        }
        

        g.fillRect(getX(), getY(), getWidth(), getHeight());
        

        g.setStroke(Color.BLACK);
        g.setLineWidth(0.5);
        g.strokeRect(getX(), getY(), getWidth(), getHeight());
    }
}
