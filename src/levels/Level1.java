package levels;

import levels.Level;
import objects.Blue;
import objects.Obstacle;
import objects.Pig;


public class Level1 extends Level {
    private int numberOfBirds;
    private int numberOfPigs;
    private int numberOfObstacles;

    public Level1(int numberOfBirds, int numberOfPigs, int numberOfObstacles) {
        this.numberOfBirds = numberOfBirds;
        this.numberOfPigs = numberOfPigs;
        this.numberOfObstacles = numberOfObstacles;

    }

    @Override
    public void initLevel() {
        for (int i = 0; i < numberOfBirds; i++) {
            getBirds().add(new Blue((370 - i * 50), 880, 60.0, 60.0, 1));
        }

        for (int i = 0; i < numberOfPigs; i++) {
            getPigs().add(new Pig((700), (840 - 90 * 5), 80, 80, 3));

        }

        for (int i = 0; i < numberOfObstacles; i++) {
            getObstacles().add(new Obstacle((700), (840 - 90 * i), 10, 90, "Glass", 1.5));

        }
    }

}
