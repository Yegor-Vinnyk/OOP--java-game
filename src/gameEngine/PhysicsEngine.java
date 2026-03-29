package gameEngine;

import levels.Level;
import objects.Bird;
import objects.GameObject;
import objects.Pig;
import objects.Obstacle;
import java.util.List;
import java.util.ArrayList;

public class PhysicsEngine {

    private double gravity = 400;
    private double deltaTime = 0.016; // Approximately 60 FPS

    public void applyGravity(Bird bird) {
        bird.setVelocityY(bird.getVelocityY() + gravity * deltaTime);

        // Apply horizontal and vertical movement
        bird.setX(bird.getX() + bird.getVelocityX() * deltaTime);
        bird.setY(bird.getY() + bird.getVelocityY() * deltaTime);
    }

    public void update(Bird bird, Level level) {
        // First, handle the bird's physics
        if (bird != null && bird.getIsLaunched()) {
            applyGravity(bird);

            if (bird.getY() + bird.getHeight() >= level.getGroundLevel()) {
                bird.setY(level.getGroundLevel() - bird.getHeight());
                bird.setVelocityY(bird.getVelocityY() * -0.3); // Bounce
                bird.setVelocityX(bird.getVelocityX() * 0.95); // Friction

                // Finalize stop
                if (Math.abs(bird.getVelocityX()) < 5) bird.setVelocityX(0);
                if (Math.abs(bird.getVelocityY()) < 5) bird.setVelocityY(0);
            }

            if (level.getPigs() != null) {
                for (Pig pig : level.getPigs()) {
                    if (checkCollision(bird, pig)) {
                        resolveCollision(pig, bird);
                    }
                }
            }
            
            for (Obstacle o : level.getObstacles()) {
                if (!o.isDead() && checkCollision(bird, o)) {
                    resolveCollision(o, bird);
                }
            }
        }

        handleChainReaction(level);
    }

    private void handleChainReaction(Level level) {
        List<GameObject> dynamicObjects = new ArrayList<>();
        dynamicObjects.addAll(level.getPigs());
        dynamicObjects.addAll(level.getObstacles());

        for (GameObject obj : dynamicObjects) {
            if (obj instanceof Obstacle && ((Obstacle) obj).isDead()) continue;
            if (obj instanceof Pig && ((Pig) obj).isDead()) continue;

            boolean hasSupport = false;

            // Check if object is on the ground
            if (obj.getY() + obj.getHeight() >= level.getGroundLevel() - 1) {
                hasSupport = true;
            } else {
                // Check if supported by another (living) object
                for (GameObject other : dynamicObjects) {
                    if (obj == other) continue;
                    if (other instanceof Obstacle && ((Obstacle) other).isDead()) continue;
                    if (other instanceof Pig && ((Pig) other).isDead()) continue;

                    // If 'other' is directly below 'obj'
                    if (Math.abs(obj.getX() - other.getX()) < Math.max(obj.getWidth(), other.getWidth()) &&
                        Math.abs((obj.getY() + obj.getHeight()) - other.getY()) < 5) {
                        hasSupport = true;
                        break;
                    }
                }
            }

            // If no support, fall
            if (!hasSupport) {
                obj.setY(obj.getY() + 80 * deltaTime);
            }
        }
    }

    public boolean checkCollision(Bird bird, GameObject object) {
        return bird.intersects(object);
    }

    public void resolveCollision(GameObject obj, Bird bird) {
        double speed = Math.sqrt(bird.getVelocityX() * bird.getVelocityX() + bird.getVelocityY() * bird.getVelocityY());
        double damage = 0.1 * bird.getMass() * speed;

        if (obj instanceof Pig) {
            ((Pig) obj).takeDamage(damage);
        } else if (obj instanceof Obstacle) {
            ((Obstacle) obj).takeDamage(damage);
        }

        double resistance = Math.max(0.1, obj.getMass());
        bird.setVelocityX(bird.getVelocityX() / resistance);
        bird.setVelocityY(bird.getVelocityY() / resistance);
    }
}
