package com.agile.bowlingGameKata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void shouldReturnTrue_WhenFramesAreTen() {
        //Arrange
        BowlingGame bowlingGame = new BowlingGame();
        //Act
        boolean result = bowlingGame.getTotalFrames(10);
        //Assert
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_WhenFramesAreNotTen() {
        //Arrange
        BowlingGame bowlingGame = new BowlingGame();
        //Act
        boolean result = bowlingGame.getTotalFrames(11);
        //Assert
        assertFalse(result);
    }

}