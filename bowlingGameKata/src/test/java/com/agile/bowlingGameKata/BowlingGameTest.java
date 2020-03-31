package com.agile.bowlingGameKata;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void shouldReturnTrue_WhenRollsPerFrameAreTwo() {
        //Arrange
        BowlingGame bowlingGame = new BowlingGame();
        //Act
        boolean result = bowlingGame.checkIfRollsPerFrameAreValid(2);
        //Assert
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_WhenRollsPerFrameAreTwo() {
        //Arrange
        BowlingGame bowlingGame = new BowlingGame();
        //Act
        boolean result = bowlingGame.checkIfRollsPerFrameAreValid(3);
        //Assert
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrue_WhenScoreForARollIsValid() {
        
        BowlingGame bowlingGame = new BowlingGame();

        boolean result =  bowlingGame.isRollScoreValid(5);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_WhenScoreForARollIsInvalid() {
        
        BowlingGame bowlingGame = new BowlingGame();

        boolean result =  bowlingGame.isRollScoreValid(11);

        assertFalse(result);
    }

    @Test
    public void shouldReturnSumOf_TwoRollsOfAFrame() {
        BowlingGame bowlingGame = new BowlingGame();

        int scoreOfFirstRoll = bowlingGame.roll(1, 1, 2);

        int scoreOfSecondRoll = bowlingGame.roll(1, 2, 5);

        int sum = bowlingGame.sumOfTwoRollsInAFrame(scoreOfFirstRoll,scoreOfSecondRoll);

        assertEquals(7, sum);
    }

}