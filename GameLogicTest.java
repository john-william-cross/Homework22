package edu.dmacc.codedsm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameLogicTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isVictorious() {
        TestGameRunner testGameRunner = new TestGameRunner() {
            @Override
            public boolean isVictorious() {
                return true;
            }
        };

        GameLogic gameLogic = new GameLogic(testGameRunner);
        GameResult gameResult = gameLogic.runGame("General Grievous");
        assertEquals(100, gameResult.getScore().intValue());

    }

    @Test
    public void isDefeated0() {
        TestGameRunner testGameRunner = new TestGameRunner() {
            @Override
            public boolean isDefeated() {
                return true;
            }
        };

        GameLogic gameLogic = new GameLogic(testGameRunner);
        GameResult gameResult = gameLogic.runGame("Mr. Hankey");
        assertEquals(4, gameResult.getScore().intValue());

    }

    @Test
    public void playerName() {
        TestGameRunner testGameRunner = new TestGameRunner() {
            @Override
            public boolean isDefeated() {
                return true;
            }
        };

        GameLogic gameLogic = new GameLogic(testGameRunner);
        GameResult gameResult = gameLogic.runGame("Thanos");
        assertEquals("Vision", gameResult.getPlayer());

    }

    private class TestGameRunner implements GameRunner {
        public boolean isVictorious() {
            return false;
        }

        public boolean isDefeated() {
            return false;
        }

    }
}