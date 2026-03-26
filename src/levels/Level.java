package levels;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;

import objects.Bird;
import objects.Pig;
import objects.Obstacle;
import javafx.scene.canvas.GraphicsContext;

public abstract class Level {

    private List<Bird> birds;
    private List<Pig> pigs;
    private List<Obstacle> obstacles;
    private int score;
    private int currentBirdIndex;
    private double groundLevel = 940;

    public Level() {
        birds = new ArrayList<>();
        pigs = new ArrayList<>();
        obstacles = new ArrayList<>();
        score = 0;
        currentBirdIndex = 0;

    }

    public void update() {
        for (Bird bird : birds) {
            bird.update(groundLevel);
        }
    }


    public boolean checkWinCondition() {
        for (Pig pig : pigs) {
            if (!pig.isDead()) {

                return false;
            }
        }
        return true;
    }

    public boolean checkLoseCondition() {
        return currentBirdIndex > birds.size() - 1 && !checkWinCondition();
    }

    public Bird nextBird() {
        if (currentBirdIndex < birds.size() - 1) {

            return birds.get(currentBirdIndex++);
        }
        return null;
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public double  getGroundLevel() {
        return groundLevel;
    }

    public void resetLevel() {
        currentBirdIndex = 0;
        birds.clear();
        pigs.clear();
        obstacles.clear();
        score = 0;
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public List<Pig> getPigs() {
        return pigs;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public abstract void initLevel();

    public void drawObject(GraphicsContext g) {
        for (Bird bird : birds) {
            bird.draw(g);
        }

    }
}
