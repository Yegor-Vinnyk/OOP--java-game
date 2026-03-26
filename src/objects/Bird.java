package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.GameObject;
import levels.Level1;

public abstract class Bird extends GameObject {

    private double velocityX = 0;
    private double velocityY = 0;
    private double mass;
    private boolean isLaunched = false;

    public Bird(double x, double y, double width, double height, double mass) {
        super(x, y, width, height);
        this.mass = mass;


    }


    public double getVelocityX() {
        return this.velocityX;
    }

    public double getVelocityY() {
        return this.velocityY;
    }


    public double getMass() {
        return this.mass;
    }

    public boolean getIsLaunched() {
        return this.isLaunched;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void launch() {
        this.isLaunched = true;
    }

    public void applyForce(double fx, double fy) {
        this.velocityX += fx / this.mass;
        this.velocityY += fy / this.mass;
    }

    @Override
    public void update(double groundY) {
        if (this.isLaunched) {
            velocityY += 0.5;


            setX(getX() + velocityX);
            setY(getY() + velocityY);

            if (getY() + getHeight() >= groundY) {

                setY(groundY - getHeight());
                velocityY = 0;
            }


        }
        if (getY() + getHeight() >= groundY) {
            setY(groundY - getHeight());
        }

    }
}