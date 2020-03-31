package com.agile.bowlingGameKata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void shouldReturnTrue_WhenFrameIsBetweenOneToTen() {
        //Arrange
        BowlingGame bowlingGame = new BowlingGame();
        //Act
        boolean result = bowlingGame.checkIfFrameIsValid(10);
        //Assert
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_WhenFrameIsNotBetweenOneToTen() {
        //Arrange
        BowlingGame bowlingGame = new BowlingGame();
        //Act
        boolean result = bowlingGame.checkIfFrameIsValid(11);
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
    public void shouldReturnFalse_WhenRollsPerFrameAreNotTwo() {
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

        bowlingGame.roll(1, 1, 3);   //roll(current frame, first roll/second roll, score)

        bowlingGame.roll(1, 2, 4);

        int sum = bowlingGame.sumOfTwoRollsInAFrame(1);

        assertEquals(7, sum);
    }

    @Test
    public void shouldReturnTotalScoreForNormalPlay() {

        BowlingGame bowlingGame = new BowlingGame();

        // Frame One
        bowlingGame.roll(1, 1, 2);   //roll(current frame, first roll/second roll, score)

        bowlingGame.roll(1, 2, 5);

        // Frame Two
        bowlingGame.roll(2, 1, 7);   //roll(current frame, first roll/second roll, score)

        bowlingGame.roll(2, 2, 2);

        int totalScore = bowlingGame.getTotalScoreForNormalPlay(2);

        assertEquals(16, totalScore);
    }

}