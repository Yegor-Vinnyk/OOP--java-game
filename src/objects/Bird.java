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
    private double gravity = 400.0; // Adjusted gravity for better feel

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
        this.velocityX += fx / getMass();
        this.velocityY += fy / getMass();
    }

    @Override
    public void update(double groundY) {
        if (this.isLaunched) {
            double deltaTime = 0.016; // Approximately 60 FPS
            

            setVelocityY(getVelocityY() + gravity * deltaTime);
            setX(getX() + getVelocityX() * deltaTime);
            setY(getY() + getVelocityY() * deltaTime);


            if (getY() + getHeight() >= groundY) {
                setY(groundY - getHeight());
                setVelocityY(getVelocityY() * -0.3); // Bounce slightly
                setVelocityX(getVelocityX() * 0.95); // Friction
                
                // Stop when moving very slowly
                if (Math.abs(getVelocityX()) < 10) setVelocityX(0);
                if (Math.abs(getVelocityY()) < 10) setVelocityY(0);
            }
        }
    }
}
