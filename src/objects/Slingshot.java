package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class Slingshot {

    private double centerX;
    private double centerY;
    private double maxDistance;
    private double power = 8.0;
    private boolean isDragged = false;
    private Image image;
    private double width;
    private double height;
    private double bandOffsetY = 170.0;
    private double bandOffsetX = 30.0;
    private double restX;
    private double restY;

    private double currentX;
    private double currentY;

    private Bird loadedBird;

    public Slingshot(double x, double y, double width, double height) {
        this.centerX = x;
        this.centerY = y;
        this.width = width;
        this.height = height;
        this.maxDistance = width; // Increased max drag distance

        image = new Image(getClass().getResourceAsStream("/images/slingshot.png"));
    }

    public void setBird(Bird bird) {
        this.loadedBird = bird;
        restX = this.centerX - this.bandOffsetX;
        restY = this.centerY - this.bandOffsetY;
        if (loadedBird != null) {
            bird.setX(restX);
            bird.setY(restY);

        }
    }

    public void onMousePressed(double x, double y) {
        if (loadedBird == null) return;

        isDragged = true;
        this.currentX = x;
        this.currentY = y;

    }

    public void onMouseDragged(double x, double y) {
        if (!isDragged || loadedBird == null) return;

        double dx = x - restX;
        double dy = y - restY;

        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > maxDistance) {
            double scale = maxDistance / distance;
            dx *= scale;
            dy *= scale;
        }

        currentX = dx +restX;
        currentY = dy +restY;

        loadedBird.setX(currentX);
        loadedBird.setY(currentY);
    }

    public void onMouseReleased() {
        if (!isDragged || loadedBird == null) return;

        isDragged = false;

        double dx = restX - currentX;
        double dy = restY - currentY;

        double velocityX = dx * power;
        double velocityY = dy * power;

        loadedBird.setVelocityX(velocityX);
        loadedBird.setVelocityY(velocityY);
        loadedBird.launch();
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getCurrentX() {
        return currentX;
    }

    public double getCurrentY() {
        return currentY;
    }

    public boolean isDragged() {
        return isDragged;
    }

    public void draw(GraphicsContext g) {
        g.drawImage(image, centerX - width / 2,
                centerY - height, width, height);

        if (isDragged && loadedBird != null) {
            g.setStroke(Color.rgb(48, 23, 8));
            g.setLineWidth(10);


            g.strokeLine(centerX - 20, centerY - height + 30, loadedBird.getX() + loadedBird.getWidth()/2, loadedBird.getY() + loadedBird.getHeight()/2);
            g.strokeLine(centerX + 20, centerY - height + 30, loadedBird.getX() + loadedBird.getWidth()/2, loadedBird.getY() + loadedBird.getHeight()/2);
        }
    }
}
