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

        int totalScore = bowlingGame.getTotalScore();

        assertEquals(16, totalScore);
    }

    @Test
    public void  shouldReturnTrue_WhenFrameHasAValidSpare() {

        BowlingGame bowlingGame = new BowlingGame();

        // Frame One
        bowlingGame.roll(1, 1, 5);   //roll(current frame, first roll/second roll, score)

        bowlingGame.roll(1, 2, 5);

       

        boolean result = bowlingGame.isValidSpare(1);

        assertTrue(result);


    }

    @Test
    public void shouldReturnTotalScore_OnSpare(){
     
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(1, 1, 5);   //roll(current frame, first roll/second roll, score)

        bowlingGame.roll(1, 2, 5);
        bowlingGame.roll(2, 1, 4);
        bowlingGame.roll(2, 2, 5);


        int result = bowlingGame.getTotalScore();
        assertEquals(23,result);
    }
    @Test
    public void shouldReturnTotalScore_WhenLastFrameHasASpare(){
     
        BowlingGame bowlingGame = new BowlingGame();
        for(int frame=1; frame<=9; frame++){
            bowlingGame.roll(frame, 1, 5);
            bowlingGame.roll(frame, 2, 2);
        

        }
        bowlingGame.roll(10, 1, 2);
        bowlingGame.roll(10, 2, 8);
        bowlingGame.roll(10, 3, 4);



        int result = bowlingGame.getTotalScore();
        assertEquals(77,result);
    }

    @Test
    public void  shouldReturnTrue_WhenFrameHasAValidStrike() {

        BowlingGame bowlingGame = new BowlingGame();

        // Frame One
        bowlingGame.roll(1, 1, 10);   //roll(current frame, first roll/second roll, score)

        //bowlingGame.roll(1, 2, 5);

       

        boolean result = bowlingGame.isValidStrike(1);

        assertTrue(result);


    }

    @Test
    public void shouldReturnTotalScore_OnStrike(){
     
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(1, 1, 10);   //roll(current frame, first roll/second roll, score)

        
        bowlingGame.roll(2, 1, 4);
        bowlingGame.roll(2, 2, 5);


        int result = bowlingGame.getTotalScore();
        assertEquals(28,result);
    }

    @Test
    public void shouldReturnTotalScore_WhenLastFrameHasAStrike(){
     
        BowlingGame bowlingGame = new BowlingGame();
        for(int frame=1; frame<=9; frame++){
            bowlingGame.roll(frame, 1, 5);
            bowlingGame.roll(frame, 2, 2);
        

        }
        bowlingGame.roll(10, 1, 10);
        bowlingGame.roll(10, 2, 10);
        bowlingGame.roll(10, 3, 10);



        int result = bowlingGame.getTotalScore();
        assertEquals(93,result);
    }

    @Test
    public void shouldReturnTotalScore_WithSampleDataGiven(){
     
        BowlingGame bowlingGame = new BowlingGame();
        
      
    bowlingGame.roll(1, 1, 1);   
    bowlingGame.roll(1, 2, 4);   
   
    bowlingGame.roll(2, 1, 4);   
    bowlingGame.roll(2, 2, 5);   
   
    bowlingGame.roll(3, 1, 6);   
    bowlingGame.roll(3, 2, 4);   
   
    bowlingGame.roll(4, 1, 5);   
    bowlingGame.roll(4, 2, 5);   
   
    bowlingGame.roll(5, 1, 10);   
   
    bowlingGame.roll(6, 1, 0);   
    bowlingGame.roll(6, 2, 1);   
   
    bowlingGame.roll(7, 1, 7);   
    bowlingGame.roll(7, 2, 3);   
   
    bowlingGame.roll(8, 1, 6);   
    bowlingGame.roll(8, 2, 4);   
   
    bowlingGame.roll(9, 1, 10);   
   
    bowlingGame.roll(10, 1, 2);   
    bowlingGame.roll(10, 2, 8);   
    bowlingGame.roll(10, 3, 6);



        int result = bowlingGame.getTotalScore();
        assertEquals(133,result);
    }




    

}