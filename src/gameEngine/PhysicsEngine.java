package gameEngine;

import levels.Level;
import objects.Bird;
import objects.GameObject;
import objects.Pig;
import objects.Obstacle;

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
        if (bird != null && bird.getIsLaunched()) {
            // Apply gravity
            applyGravity(bird);

            // Check ground collision
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


                if (checkCollision(bird, o)) {
                    resolveCollision(o, bird);
                }
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
            Pig pig = (Pig) obj;
            pig.takeDamage(damage);

            bird.setX(bird.getX() - bird.getVelocityX() * deltaTime);
            bird.setY(bird.getY() - bird.getVelocityY() * deltaTime);


        }

        if (obj instanceof Obstacle) {
            Obstacle obstacle = (Obstacle) obj;


            obstacle.takeDamage(damage);


        }
        // World-class safety: ensure mass is at least a small positive value
        double resistance = Math.max(0.1, obj.getMass());

        bird.setVelocityX((bird.getVelocityX()) / resistance);
        bird.setVelocityY((bird.getVelocityY()) / resistance);
    }
}