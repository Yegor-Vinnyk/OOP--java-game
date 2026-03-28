package objects;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {

    private double x;
    private double y;
    private double width;
    private double height;
    private double mass;

    public GameObject(double x, double y, double width, double height, double mass) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.mass = mass;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getWidth() {
        return this.width;
    }

    public double getMass() {
        return mass;
    }

    public double getHeight() {
        return this.height;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public abstract void draw(GraphicsContext g);

    public boolean intersects(GameObject other) {
        return x < other.x + other.width &&
                x + width > other.x &&
                y < other.y + other.height &&
                y + height > other.y;
    }


}
