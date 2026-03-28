package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Bird extends GameObject {

    private double velocityX = 0;
    private double velocityY = 0;
    private boolean isLaunched = false;
    protected boolean abilityUsed = false;
    protected List<Bird> spawnedBirds = new ArrayList<>();

    public Bird(double x, double y, double width, double height, double mass) {
        super(x, y, width, height, mass);

    }


    public double getVelocityX() {
        return this.velocityX;
    }

    public double getVelocityY() {
        return this.velocityY;
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

    public boolean getAbilityUse() {
        return this.abilityUsed;
    }

    public void setAbilityUse() {
         this.abilityUsed = true;
    }

    public abstract void useAbility();

    public List<Bird> getSpawnedBirds() {
        List<Bird> spawned = new ArrayList<>(spawnedBirds);
        spawnedBirds.clear(); // Clear so we don't add them multiple times
        return spawned;
    }

}
