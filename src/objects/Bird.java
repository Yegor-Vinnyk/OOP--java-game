package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.GameObject;
import levels.Level;

import java.util.ArrayList;
import java.util.List;


import abilityStrategy.AbilityStrategy;

public abstract class Bird extends GameObject {

    private Level currentLevel;
    private AbilityStrategy strategy;
    private double velocityX = 0;
    private double velocityY = 0;
    private boolean isLaunched = false;
    protected boolean abilityUsed = false;

    public Bird(double x, double y, double width, double height, double mass, AbilityStrategy strategy, Level level) {
        super(x, y, width, height, mass);
        this.strategy = strategy;
        this.currentLevel = level;
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

    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    public void useAbility() {
        this.abilityUsed = true;
        strategy.useAbility(this);
    }


}
