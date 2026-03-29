package levels;

import objects.Pig;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import objects.Bird;

class LevelTest {
    @Test
    void levelWinTest_allPigsDead() {
        Level1 level = new Level1(2, 2, 3);
        level.initLevel();
        for (Pig pig : level.getPigs()) {
            pig.takeDamage(100);
        }

        boolean condition = level.checkWinCondition();
        assertTrue(condition);
    }

    @Test
    void levelWinTest_allPigsAlive() {
        Level1 level = new Level1(2, 2, 3);
        level.initLevel();
        for (Pig pig : level.getPigs()) {
            pig.takeDamage(10);
        }

        boolean condition = level.checkWinCondition();
        assertFalse(condition);
    }

    @Test
    void levelLoseTest_noBirds_noPigs() {
        Level1 level = new Level1(0, 0, 3);
        level.initLevel();

        boolean condition = level.checkLoseCondition();

        assertFalse(condition);
    }

    @Test
    void levelLoseTest_noBirds_PigsAlive() {
        Level1 level = new Level1(0, 3, 3);
        level.initLevel();

        boolean condition = level.checkLoseCondition();

        assertTrue(condition);
    }

    @Test
    void levelLoseTest_BirdsExist_noPigs() {
        Level1 level = new Level1(2, 0, 3);
        level.initLevel();

        boolean condition = level.checkLoseCondition();

        assertFalse(condition);
    }


    @Test
    void levelNextBirdTest_BirdExists() {
        Level1 level = new Level1(2, 2, 3);
        level.initLevel();

        Bird bird1 = level.nextBird();

        assertEquals(bird1, level.getBirds().get(0));

    }

    @Test
    void levelNextBirdTest_NoBirds() {
        Level1 level = new Level1(0, 2, 3);
        level.initLevel();

        Bird bird1 = level.nextBird();

        assertEquals(bird1, null);

    }

    @Test
    void levelScoreAddTest() {
        Level1 level = new Level1(0, 2, 3);

        level.addScore(10);
        int score = level.getScore();

        assertEquals(10, score);

    }

}
