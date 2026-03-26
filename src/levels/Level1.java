package levels;
import levels.Level;
import objects.Blue;


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
            getBirds().add(new Blue((370 - i * 50), 880, 60.0, 60.0, 35.0));
        }
    }

}
